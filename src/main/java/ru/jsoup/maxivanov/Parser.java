package ru.jsoup.maxivanov;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    //private static ArrayList<Vacancy> vacancies;
    //private static HashSet<Company> companies;


    public static String printHTML(String text) throws IOException {
        return Jsoup.connect(Search.getURL(text)).get().html();
    }

    public static HashMap<Integer,Vacancy> pars(String text) throws IOException {

        Document doc = Jsoup.connect(Search.getURL(text)).get();
        //vacancies = new ArrayList<Vacancy>();
        //companies = new HashSet<Company>();

        Elements elements = doc.select(".search-item-name");
        //start
        //vacancies + href
        int count = 0;

        boolean debug = false;

        for (Element el : elements) {
            Vacancy vacancy = new Vacancy();
            Company company = new Company();
            String[] url = el.select("a").attr("href").split("\\?");
            vacancy.setVacancyURL(url[0]);
            vacancy.setVacancyTitle(el.text());
            if (debug)
                System.out.println(el.text() + ": " + url[0]);

            Document docVacancy = Jsoup.connect(el.select("a").attr("href")).get();

            //Описание вакансии
            if (!docVacancy.select(".g-user-content").text().equals("")) {
                Elements desc = docVacancy.select(".g-user-content").select("*");
                vacancy.setVacancyDescription(parseDescriprionVacancy(desc));

                //vacancy.setVacancyDescription(docVacancy.select(".g-user-content").text());
                //System.out.println(parseDescriprionVacancy(desc));
                //System.out.println("*********************");
                if (debug)
                    System.out.println(parseDescriprionVacancy(desc));
                    //System.out.println(docVacancy.select(".g-user-content").text());
            } else {
                Elements desc = docVacancy.select(".vacancy-branded-user-content").select("*");
                vacancy.setVacancyDescription(parseDescriprionVacancy(desc));

                //vacancy.setVacancyDescription(docVacancy.select(".vacancy-branded-user-content").text());
                //System.out.println(parseDescriprionVacancy(desc));
                //System.out.println("*********************");
                if (debug)
                    System.out.println(parseDescriprionVacancy(desc));
                    //System.out.println(docVacancy.select(".vacancy-branded-user-content").text());
            }

            //ключевые навыки
            Elements tagList = docVacancy.select(".Bloko-TagList-Text");
            ArrayList<String> tags = new ArrayList<String>();
            for (Element tag : tagList) {
                tags.add(tag.text());
                if (debug)
                    System.out.print(tag.text() + "/ ");
            }
            vacancy.setVacancyTags(tags);
            //System.out.println();

            //дата вакансии
            vacancy.setVacancyCreationTime(docVacancy.select(".vacancy-creation-time").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-creation-time").text());

            //компания
            company.setCompanyName(docVacancy.select(".vacancy-company-name-wrapper").select("span[itemprop=\"name\"]").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-company-name-wrapper").select("span[itemprop=\"name\"]").text());

            //ссылка на компанию
            company.setCompanyURL("https://ekaterinburg.hh.ru" + docVacancy.select(".vacancy-company-name-wrapper").select("a").attr("href"));
            vacancy.setCompanyID(company.getCompanyId());

            if (debug)
                System.out.println("https://ekaterinburg.hh.ru" + docVacancy.select(".vacancy-company-name-wrapper").select("a").attr("href"));

            //адрес компании
            company.setCompanyAddress(docVacancy.select(".vacancy-company-wrapper").select("span[data-qa=\"vacancy-view-raw-address\"]").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-company-wrapper").select("span[data-qa=\"vacancy-view-raw-address\"]").text());

            //требуемый опыт
            vacancy.setVacancyExperience(docVacancy.select(".vacancy-description").select("span[data-qa=\"vacancy-experience\"]").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-description").select("span[data-qa=\"vacancy-experience\"]").text());

            //тип занятости
            vacancy.setVacancyEmploymentType(docVacancy.select(".vacancy-description").select("span[itemprop=\"employmentType\"]").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"employmentType\"]").text());

            //график
            vacancy.setVacancyWorkHours(docVacancy.select(".vacancy-description").select("span[itemprop=\"workHours\"]").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"workHours\"]").text());

            //зп
            vacancy.setVacancySalary(docVacancy.select(".vacancy-salary").text());
            if (debug)
                System.out.println(docVacancy.select(".vacancy-salary").text());

            //контактная инфа
            Elements pContacts = docVacancy.select(".vacancy-contacts__body").select("p");
            StringBuilder contact = new StringBuilder();
            for (Element p : pContacts) {
                contact.append(p.text()).append("\n");
                if (debug)
                    System.out.println(p.text());
            }
            vacancy.setVacancyCompanyContacts(contact.toString());

            vacancy.setVacancyCompanyEmail(docVacancy.select(".vacancy-contacts__body").select("a").text());
                if (debug)
                    System.out.println(docVacancy.select(".vacancy-contacts__body").select("a").text());


            //тип вакансии
            vacancy.setVacancyIndustry(docVacancy.select(".bloko-columns-row").select("meta[itemprop=\"industry\"]").attr("content"));
            if (debug)
                System.out.println(docVacancy.select(".bloko-columns-row").select("meta[itemprop=\"industry\"]").attr("content"));

            //System.out.println("------------------------------");
            count++;

            //vacancies.add(vacancy);
            VacanciesSet.vacancies.put(vacancy.getVacancyID(), vacancy);
            if(!VacanciesSet.companies.containsKey(company.getCompanyId())) {
                VacanciesSet.companies.put(company.getCompanyId(), company);
            }

        }

        System.out.println(count);
        System.out.println();

        /*//salary
        Elements salary = doc.select(".vacancy-serp-item__sidebar");
        for (Element el2 : salary) {
            System.out.println(el2.text());
        }*/

        return VacanciesSet.vacancies;
    }

    private static String parseDescriprionVacancy(Elements desc) {
        StringBuilder builder = new StringBuilder();
        for (Element d : desc) {
            if (d.tagName().equals("p")) {
                builder.append(d.text()).append("\n");
                //System.out.println(d.text());
            }else if (d.tagName().equals("li")) {
                builder.append("* ").append(d.text()).append("\n");
                //System.out.println("*" + d.text());
            }
        }
        return builder.toString();
    }
}
