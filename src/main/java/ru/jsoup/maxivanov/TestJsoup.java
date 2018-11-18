package ru.jsoup.maxivanov;

import java.io.IOException;
import java.util.HashMap;

public class TestJsoup {

    public static void main(String[] args) throws IOException {
        //TestUI.runGUI();
        //System.out.println(Parser.printHTML("java"));
        //System.out.println(Parser.pars("java"));

        HashMap<Integer, Vacancy> vacancies = Parser.pars("java");
        for (Vacancy vacancy : vacancies.values()) {
            System.out.println(vacancy.toString());
            System.out.println("--------------------------------------");
        }

    }
}


