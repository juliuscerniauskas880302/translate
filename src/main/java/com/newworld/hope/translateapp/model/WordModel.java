package com.newworld.hope.translateapp.model;

public class WordModel {
    private long id;
    private String text;
    private String description;

    public WordModel() {
    }

    public WordModel(long id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
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

}
