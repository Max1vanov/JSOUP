package ru.jsoup.maxivanov;

import java.util.ArrayList;

public class Vacancy {

    private String vacancyTitle;
    private String vacancySalary;
    private String vacancyURL;
    private ArrayList<String> vacancyTags;
    private String vacancyCreationTime;
    private int companyID;
    private String vacancyExperience;
    private String vacancyEmploymentType;
    private String vacancyWorkHours;
    private String vacancyDescription;
    private String vacancyCompanyContacts;
    private String vacancyCompanyEmail;
    private String vacancyIndustry;
    private int vacancyID;

    /*private String vacancyCompanyName;
    private String vacancyCompanyAddress;
    private String vacancyCompanyURL;*/
    //vacancy-icon-wrapper - доступность инвалидам и тд

    public Vacancy(){}

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }


    public int getVacancyID() {
        return vacancyID;
    }

    public void setVacancyID(int vacancyID) {
        this.vacancyID = vacancyID;
    }

    public String getVacancyURL() {
        return vacancyURL;
    }

    public void setVacancyURL(String vacancyURL) {
        this.vacancyURL = vacancyURL;

        String[] id = vacancyURL.split("/");
        setVacancyID(Integer.valueOf(id[id.length-1]));
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

    /*public String getVacancyCompanyName() {
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
*/
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

    @Override
    public int hashCode() {
        int hash = vacancyID;
        hash = 31 * hash + (this.vacancyCompanyContacts != null ? this.vacancyCompanyContacts.hashCode() : 0);
        hash = 31 * hash + (this.vacancyCompanyEmail != null ? this.vacancyCompanyEmail.hashCode() : 0);
        hash = 31 * hash + (this.vacancyCreationTime != null ? this.vacancyCreationTime.hashCode() : 0);
        hash = 31 * hash + (this.vacancyIndustry != null ? this.vacancyIndustry.hashCode() : 0);
        hash = 31 * hash + (this.vacancySalary != null ? this.vacancySalary.hashCode() : 0);
        hash = 31 * hash + (this.vacancyWorkHours != null ? this.vacancyWorkHours.hashCode() : 0);
        hash = 31 * hash + (this.vacancyEmploymentType != null ? this.vacancyEmploymentType.hashCode() : 0);
        hash = 31 * hash + (this.vacancyExperience != null ? this.vacancyExperience.hashCode() : 0);
        hash = 31 * hash + (this.vacancyTags != null ? this.vacancyTags.hashCode() : 0);
        hash = 31 * hash + (this.vacancyDescription != null ? this.vacancyDescription.hashCode() : 0);
        hash = 31 * hash + (this.vacancyTitle != null ? this.vacancyTitle.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!Vacancy.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Vacancy otherV = (Vacancy) obj;
        if (this.vacancyID != otherV.vacancyID) {
            return false;
        }
        if ((this.vacancyCompanyContacts == null) ? (otherV.vacancyCompanyContacts != null) : (!this.vacancyCompanyContacts.equals(otherV.vacancyCompanyContacts))) {
            return false;
        }
         if ((this.vacancyCompanyEmail == null) ? (otherV.vacancyCompanyEmail != null) : (!this.vacancyCompanyEmail.equals(otherV.vacancyCompanyEmail))) {
            return false;
        }
         if ((this.vacancyCreationTime == null) ? (otherV.vacancyCreationTime != null) : (!this.vacancyCreationTime.equals(otherV.vacancyCreationTime))) {
            return false;
        }
         if ((this.vacancyIndustry == null) ? (otherV.vacancyIndustry != null) : (!this.vacancyIndustry.equals(otherV.vacancyIndustry))) {
            return false;
        }
         if ((this.vacancySalary == null) ? (otherV.vacancySalary != null) : (!this.vacancySalary.equals(otherV.vacancySalary))) {
            return false;
        }
         if ((this.vacancyWorkHours == null) ? (otherV.vacancyWorkHours != null) : (!this.vacancyWorkHours.equals(otherV.vacancyWorkHours))) {
            return false;
        }
         if ((this.vacancyEmploymentType == null) ? (otherV.vacancyEmploymentType != null) : (!this.vacancyEmploymentType.equals(otherV.vacancyEmploymentType))) {
            return false;
        }
         if ((this.vacancyExperience == null) ? (otherV.vacancyExperience != null) : (!this.vacancyExperience.equals(otherV.vacancyExperience))) {
            return false;
        }
         if ((this.vacancyTags == null) ? (otherV.vacancyTags != null) : (!this.vacancyTags.equals(otherV.vacancyTags))) {
            return false;
        }
         if ((this.vacancyDescription == null) ? (otherV.vacancyDescription != null) : (!this.vacancyDescription.equals(otherV.vacancyDescription))) {
            return false;
        }
         if ((this.vacancyTitle == null) ? (otherV.vacancyTitle != null) : (!this.vacancyTitle.equals(otherV.vacancyTitle))) {
            return false;
        }
         if ((this.vacancyURL == null) ? (otherV.vacancyURL != null) : (!this.vacancyURL.equals(otherV.vacancyURL))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       if (vacancyTags == null || vacancyTags.size()==0 || vacancyTags.get(0).equals("") || vacancyTags.get(0) == null) {
           builder.append("");
       } else {
           for (String t : vacancyTags) {
               builder.append(t).append(" / ");
           }
       }

        Company company = VacanciesSet.companies.get(this.companyID);
        return "\tVacancy industry: '" +this.vacancyIndustry+"'\n\nVacancy title: '" + this.vacancyTitle +
                "'\n\tSalary: '" +this.vacancySalary +
                "'\n\tLink: '" + this.vacancyURL +
                ((builder.toString().equals(""))?"":"'\n\tTags: '" + builder.toString()+ "'") +
                "\n\t" + this.vacancyCreationTime +
                "\n\n" + company.toString() + "\n\n\t"+
                "Required experience: '" + this.vacancyExperience + "'\n\t"+
                "Employment type: '" + this.vacancyEmploymentType + "', Work schedule: '" + this.vacancyWorkHours +
                "'\n\n" + this.vacancyDescription + "\n\t" +
                (this.vacancyCompanyContacts == null ||
                        this.vacancyCompanyContacts.equals("null")||
                        this.vacancyCompanyContacts.equals("") ? "" :
                        ("Company contacts:\n" + this.vacancyCompanyContacts))+ "\n\t" +
                ((this.vacancyCompanyEmail == null ||
                        this.vacancyCompanyEmail.equals("null") ||
                        this.vacancyCompanyEmail.equals("")) ? "" : (
                "Company e-mail: '" + this.vacancyCompanyEmail + "'"));
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
