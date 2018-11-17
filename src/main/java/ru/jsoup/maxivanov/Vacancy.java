package ru.jsoup.maxivanov;

import java.util.ArrayList;

public class Vacancy {

    private String vacancyURL;
    private String vacancyTitle;
    private String vacancyDescription;
    private ArrayList<String> vacancyTags;
    private String vacancyCreationTime;
    private String vacancyCompanyName;
    private String vacancyCompanyAddress;
    private String vacancyCompanyURL;
    private String vacancyExperience;
    private String vacancyEmploymentType;
    private String vacancyWorkHours;
    private String vacancySalary;
    private String vacancyCompanyContacts;
    private String vacancyCompanyEmail;
    private String vacancyIndustry;

    //vacancy-icon-wrapper - доступность инвалидам и тд

    public Vacancy(){}

    public String getVacancyURL() {
        return vacancyURL;
    }

    public void setVacancyURL(String vacancyURL) {
        this.vacancyURL = vacancyURL;
    }

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public ArrayList<String> getVacancyTags() {
        return vacancyTags;
    }

    public void setVacancyTags(ArrayList<String> vacancyTags) {
        this.vacancyTags = vacancyTags;
    }

    public String getVacancyCreationTime() {
        return vacancyCreationTime;
    }

    public void setVacancyCreationTime(String vacancyCreationTime) {
        this.vacancyCreationTime = vacancyCreationTime;
    }

    public String getVacancyCompanyName() {
        return vacancyCompanyName;
    }

    public void setVacancyCompanyName(String vacancyCompanyName) {
        this.vacancyCompanyName = vacancyCompanyName;
    }

    public String getVacancyCompanyAddress() {
        return vacancyCompanyAddress;
    }

    public void setVacancyCompanyAddress(String vacancyCompanyAddress) {
        this.vacancyCompanyAddress = vacancyCompanyAddress;
    }

    public String getVacancyCompanyURL() {
        return vacancyCompanyURL;
    }

    public void setVacancyCompanyURL(String vacancyCompanyURL) {
        this.vacancyCompanyURL = vacancyCompanyURL;
    }

    public String getVacancyExperience() {
        return vacancyExperience;
    }

    public void setVacancyExperience(String vacancyExperience) {
        this.vacancyExperience = vacancyExperience;
    }

    public String getVacancyEmploymentType() {
        return vacancyEmploymentType;
    }

    public void setVacancyEmploymentType(String vacancyEmploymentType) {
        this.vacancyEmploymentType = vacancyEmploymentType;
    }

    public String getVacancyWorkHours() {
        return vacancyWorkHours;
    }

    public void setVacancyWorkHours(String vacancyWorkHours) {
        this.vacancyWorkHours = vacancyWorkHours;
    }

    public String getVacancySalary() {
        return vacancySalary;
    }

    public void setVacancySalary(String vacancySalary) {
        this.vacancySalary = vacancySalary;
    }

    public String getVacancyCompanyContacts() {
        return vacancyCompanyContacts;
    }

    public void setVacancyCompanyContacts(String companyContacts) {
        this.vacancyCompanyContacts = companyContacts;
    }

    public String getVacancyCompanyEmail() {
        return vacancyCompanyEmail;
    }

    public void setVacancyCompanyEmail(String companyEmail) {
        this.vacancyCompanyEmail = companyEmail;
    }

    public String getVacancyIndustry() {
        return vacancyIndustry;
    }

    public void setVacancyIndustry(String vacancyIndustry) {
        this.vacancyIndustry = vacancyIndustry;
    }


//.header data-qa[page-title] - сколько вакансий по данному запросу
    //.search-suggestion - результаты запроса. Если "Попробуйте другие варианты поискового запроса" то конец
    //.bloko-form-spacer потом .bloko-button HH-Pager-Control rel = "nofollow" - последняя страница
//НАШЕЛ сопсоб определения последней вакансии для парсинга .search-item-name  0..."data-position"<"data-totalvacancies"<2000


//.vacancy-serp - блок вакансий на странице

    //для каждой вакансии инфа с предпросмотром
    //.vacancy-serp-item - блок с отдельной вакансией
    //в ней 3 блока .vacancy-serp-item__row .vacancy-serp-item__info
    //1 - Блок со ссылкой на вакансию(название вакансии, компания,адрес) и инфой о з/п
    //2 - описание вакансии, лого
    //3 - ссылки на контакты, откликнуться, инфо. когда вакансия была размещена

    //1. .search-item-name - a text - название вакансии
    //                      href - ссылка на вакансию
    //  компания - признак проверки на сайте, адрес

    //2. div data-qa="vacancy-serp__vacancy_snippet_responsibility" - обязанности
    //  div data-qa="vacancy-serp__vacancy_snippet_requirement" - требования

    //3. .vacancy-serp-item__publication-date text- дата публикации


    //нужно найти способ классифицировать вакансию, когда поиск общий по всем, чтобы можно было сортировать
    //как таковую вакансию через общий список найти не возможно, после того, как зашли в вакансию - можно


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

    //в самой вакансии в метаданных есть инфа о
    //og:description - Название вакансии, зп, когда опублековано

    //div itemscope="itemscope" meta itemprop="industry" content=" ... " - название типа вакансии


}
