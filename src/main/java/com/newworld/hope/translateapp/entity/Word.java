package com.newworld.hope.translateapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "words")
public class Word implements Serializable {
    private static final long serialVersionUID = -5254443854998426904L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text", length = 80)
    private String text;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "locale", length = 3)
    private String locale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
