package com.newworld.hope.translateapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TranslationCreateModel {

    private long wordId;
    private String translation;
    private String countryCode;

}
