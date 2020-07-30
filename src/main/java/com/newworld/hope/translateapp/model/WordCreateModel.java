package com.newworld.hope.translateapp.model;

public class WordCreateModel {

    private String text;
    private String description;

    public WordCreateModel(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

}
