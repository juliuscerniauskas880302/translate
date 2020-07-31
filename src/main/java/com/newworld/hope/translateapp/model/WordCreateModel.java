package com.newworld.hope.translateapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordCreateModel {

    private String text;
    private String description;
    private String propertyName;

}
