package com.newworld.hope.translateapp.model;

public class WordModel {
    private long id;
    private String text;
    private String description;
    private String locale;

    public WordModel() {
    }

    public WordModel(long id, String text, String description, String locale) {
        this.id = id;
        this.text = text;
        this.description = description;
        this.locale = locale;
    }

    public long getId() {
        return id;
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
