package ru.jsoup.maxivanov;

public class Vacancy {

    String vacancyTitle;//header + salary .vacancy-title
    String vacancyCompanyWrapper;// companyName + logo + адрес .vacancy-company-wrapper
    //HH/VacancyResponsePopup/VacancyResponsePopup - properties vacancy
    String vacancyDescription;//bloko-gap bloko-gap_bottom(требуемый опыт работы)
                              //g-user-content - описание вакансии
                              //vacancy-section - ключевые навыки
                              //vacancy-section - jobLocation - адрес
                              //vacancy-icon-wrapper - доступность инвалидам и тд
                                //vacancy-section - контактная инфа. телефон. имя
                                //.vacancy-description



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
