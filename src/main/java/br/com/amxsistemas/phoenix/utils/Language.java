package br.com.amxsistemas.phoenix.utils;

public class Language {

    private static String language;

    public static void setLanguage(String language) {
        Language.language = language;
    }

    public static String getLanguage() {
        return language;
    }
}
