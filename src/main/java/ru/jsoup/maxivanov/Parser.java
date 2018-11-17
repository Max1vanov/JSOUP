package ru.jsoup.maxivanov;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Parser {
    public static String pars(String test) throws IOException {
        return Jsoup.connect(Search.getURL(test)).get().html();
    }
}
