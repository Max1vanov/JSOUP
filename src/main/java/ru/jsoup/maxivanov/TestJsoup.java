package ru.jsoup.maxivanov;

import java.io.IOException;
import java.util.HashMap;

public class TestJsoup {

    public static void main(String[] args) throws IOException {
        //TestUI.runGUI();
        //System.out.println(Parser.printHTML("java"));
        //System.out.println(Parser.pars("java"));
        long startTime = System.currentTimeMillis();

        HashMap<Integer, Vacancy> vacancies = Parser.pars("java");
        for (Vacancy vacancy : vacancies.values()) {
            System.out.println(vacancy.toString());
            System.out.println("--------------------------------------");
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Program exec. time = " + (timeSpent/1000) + "s.");

    }
}


