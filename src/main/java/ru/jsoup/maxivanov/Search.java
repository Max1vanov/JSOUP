package ru.jsoup.maxivanov;

public class Search {
    private static final String URL = "https://ekaterinburg.hh.ru/search/vacancy?";

    //https://ekaterinburg.hh.ru/search/vacancy?area=3&clusters=true&enable_snippets=true&page=99
    //ссылка на общий список вакансий с атрибутами:
    //area=3 регион
    //page=99 страница - 0 - первый индекс
    //items_on_page=100/50/20 - вакансий на странице
    //text=Java - текст запроса
    //experience=doesNotMatter/noExperience/between1And3/between3And6/moreThan6 - опыт
    //order_by=relevance/salary_asc/salary_desc/publication_time - сортировка
    //no_magic=true ???
    //from=suggest_post ???
    //search_period - нет-за месяц/7/3/1
    //salary - зп
    //only_with_salary=true - только с указанием зп
    //search_field - name/company_name/description

    private final String AREA = "area=3";//area - EKB
    private final String itemsOnPage = "items_on_page=100";//100 результатов на странице, для парсинга
    private final String currencyCode = "currency_code=RUR";//код валюты
    private String text = "text=";
    private String experience = "experience=";
    private String orderBy = "order_by=";
    private String searchPeriod = "search_period=";
    private String salary = "salary=";
    private String onlyWithSalary = "only_with_salary=";





}
