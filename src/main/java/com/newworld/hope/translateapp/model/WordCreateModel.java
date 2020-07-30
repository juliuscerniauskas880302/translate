package com.newworld.hope.translateapp.model;

public class WordCreateModel {

    private String text;
    private String description;
    private String locale;

    public WordCreateModel(String text, String description, String locale) {
        this.text = text;
        this.description = description;
        this.locale = locale;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public String getLocale() {
        return locale;
    }

}
