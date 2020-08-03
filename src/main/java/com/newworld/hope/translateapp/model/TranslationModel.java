package com.newworld.hope.translateapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TranslationModel {

    private long id;
    private long wordId;
    private String countryCode;
    private String translation;

}
