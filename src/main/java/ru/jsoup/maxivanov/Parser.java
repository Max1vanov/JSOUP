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
        //return Jsoup.connect(Search.getURL(test)).get().html();

        Document doc = Jsoup.connect(Search.getURL(text)).get();
        Elements elements = doc.select(".search-item-name");
        //start
        //vacancies + href
        int count = 0;
        for (Element el : elements) {
            System.out.println(el.text() + ": " + el.select("a").attr("href"));
            //Описание вакансии
            Document docVacancy = Jsoup.connect(el.select("a").attr("href")).get();
            if(!docVacancy.select(".g-user-content").text().equals("")){
                System.out.println(docVacancy.select(".g-user-content").text());
            }else {
                System.out.println(docVacancy.select(".vacancy-branded-user-content").text());
            }

            //ключевые навыки
            Elements tagList = docVacancy.select(".Bloko-TagList-Text");
            for (Element tag : tagList){
                System.out.print(tag.text() + "/ ");
            }
            System.out.println();

            //дата вакансии
            System.out.println(docVacancy.select(".vacancy-creation-time").text());

            //компания
            System.out.println(docVacancy.select(".vacancy-company-name-wrapper").select("span[itemprop=\"name\"]").text());

            //ссылка на компанию
            System.out.println("https://ekaterinburg.hh.ru"+docVacancy.select(".vacancy-company-name-wrapper").select("a").attr("href"));

            //адрес компании
            System.out.println(docVacancy.select(".vacancy-company-wrapper").select("span[data-qa=\"vacancy-view-raw-address\"]").text());

            //требуемый опыт
            System.out.println(docVacancy.select(".vacancy-description").select("span[data-qa=\"vacancy-experience\"]").text());

            //тип занятости
            System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"employmentType\"]").text());

            //график
            System.out.println(docVacancy.select(".vacancy-description").select("span[itemprop=\"workHours\"]").text());

            //зп
            System.out.println(docVacancy.select(".vacancy-salary").text());

            //контактная инфа
            Elements pContacts = docVacancy.select(".vacancy-contacts__body");
            for (Element p : pContacts) {
                System.out.println(p.select("p").text());
            }
            Elements aContacts = docVacancy.select(".vacancy-contacts__body");
            for (Element a : aContacts) {
                System.out.println(a.select("a").text());
            }

            //тип вакансии
            System.out.println(docVacancy.select(".bloko-columns-row").select("meta[itemprop=\"industry\"]").attr("content"));




            System.out.println("------------------------------");
            count++;
        }
        System.out.println(count);
        System.out.println();

        //salary
        Elements salary = doc.select(".vacancy-serp-item__sidebar");
        for (Element el2 : salary) {
            System.out.println(el2.text());
        }

        return "hello";
    }

    public static ArrayList<Vacancy> pars(String text) throws IOException {

        Document doc = Jsoup.connect(Search.getURL(text)).get();
        Elements elements = doc.getElementsByClass(".vacancy-serp-item");


        return vacancies;
    }
}
