package com.newworld.hope.translateapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordModel {

    private long id;
    private String text;
    private String description;
    private String propertyName;

}
