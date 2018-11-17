package ru.jsoup.maxivanov;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private static ArrayList<Vacancy> vacancies;

    public static String printHTML(String text) throws IOException {
        return Jsoup.connect(Search.getURL(text)).get().html();
    }

    public static ArrayList<Vacancy> pars(String text) throws IOException {

        Document doc = Jsoup.connect(Search.getURL(text)).get();
        vacancies = new ArrayList<Vacancy>();
        Elements elements = doc.select(".search-item-name");
        //start
        //vacancies + href
        int count = 0;

        for (Element el : elements) {
            Vacancy vacancy = new Vacancy();
            vacancy.setVacancyURL(el.select("a").attr("href"));
            vacancy.setVacancyTitle(el.text());

            System.out.println(el.text() + ": " + el.select("a").attr("href"));

            Document docVacancy = Jsoup.connect(el.select("a").attr("href")).get();

            //Описание вакансии
            if(!docVacancy.select(".g-user-content").text().equals("")){
                vacancy.setVacancyDescription(docVacancy.select(".g-user-content").text());
                System.out.println(docVacancy.select(".g-user-content").text());
            }else {
                vacancy.setVacancyDescription(docVacancy.select(".vacancy-branded-user-content").text());
                System.out.println(docVacancy.select(".vacancy-branded-user-content").text());
            }

            //ключевые навыки
            Elements tagList = docVacancy.select(".Bloko-TagList-Text");
            ArrayList<String> tags = new ArrayList<String>();
            for (Element tag : tagList){
                tags.add(tag.text());
                System.out.print(tag.text() + "/ ");
            }
            vacancy.setVacancyTags(tags);
            System.out.println();

            //дата вакансии
            vacancy.setVacancyCreationTime(docVacancy.select(".vacancy-creation-time").text());
            System.out.println(docVacancy.select(".vacancy-creation-time").text());

            //компания
            vacancy.setVacancyCompanyName(docVacancy.select(".vacancy-company-name-wrapper").select("span[itemprop=\"name\"]").text());
            System.out.println(docVacancy.select(".vacancy-company-name-wrapper").select("span[itemprop=\"name\"]").text());

            //ссылка на компанию
            vacancy.setVacancyCompanyURL("https://ekaterinburg.hh.ru"+docVacancy.select(".vacancy-company-name-wrapper").select("a").attr("href"));
            System.out.println("https://ekaterinburg.hh.ru"+docVacancy.select(".vacancy-company-name-wrapper").select("a").attr("href"));

            //адрес компании
            vacancy.setVacancyCompanyAddress(docVacancy.select(".vacancy-company-wrapper").select("span[data-qa=\"vacancy-view-raw-address\"]").text());
            System.out.println(docVacancy.select(".vacancy-company-wrapper").select("span[data-qa=\"vacancy-view-raw-address\"]").text());

            //требуемый опыт
            vacancy.setVacancyExperience(docVacancy.select(".vacancy-description").select("span[data-qa=\"vacancy-experience\"]").text());
            System.out.println(docVacancy.select(".vacancy-description").select("span[data-qa=\"vacancy-experience\"]").text());

            //тип занятости
            vacancy.setVacancyEmploymentType(docVacancy.select(".vacancy-description").select("span[itemprop=\"employmentType\"]").text());
            System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"employmentType\"]").text());

            //график
            vacancy.setVacancyWorkHours(docVacancy.select(".vacancy-description").select("span[itemprop=\"workHours\"]").text());
            System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"workHours\"]").text());

            //зп
            vacancy.setVacancySalary(docVacancy.select(".vacancy-salary").text());
            System.out.println(docVacancy.select(".vacancy-salary").text());

            //контактная инфа
            Elements pContacts = docVacancy.select(".vacancy-contacts__body");
            for (Element p : pContacts) {
                vacancy.setVacancyCompanyContacts(p.select("p").text());
                System.out.println(p.select("p").text());
            }
            Elements aContacts = docVacancy.select(".vacancy-contacts__body");
            for (Element a : aContacts) {
                vacancy.setVacancyCompanyEmail(a.select("a").text());
                System.out.println(a.select("a").text());
            }

            //тип вакансии
            vacancy.setVacancyIndustry(docVacancy.select(".bloko-columns-row").select("meta[itemprop=\"industry\"]").attr("content"));
            System.out.println(docVacancy.select(".bloko-columns-row").select("meta[itemprop=\"industry\"]").attr("content"));

            System.out.println("------------------------------");
            count++;

            vacancies.add(vacancy);
        }

        System.out.println(count);
        System.out.println();

        /*//salary
        Elements salary = doc.select(".vacancy-serp-item__sidebar");
        for (Element el2 : salary) {
            System.out.println(el2.text());
        }*/

        return vacancies;
    }
}
