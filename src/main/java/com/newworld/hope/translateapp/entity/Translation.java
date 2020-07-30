package com.newworld.hope.translateapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "translation")
@NoArgsConstructor
@Data
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "word_id")
    private long wordId;

    @Column(name = "country_code", length = 3)
    private String countryCode;

    @Column(name = "translation", length = 120)
    private String translation;
}
