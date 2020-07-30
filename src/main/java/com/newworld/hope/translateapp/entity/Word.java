package com.newworld.hope.translateapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "words")
@NoArgsConstructor
@Data
public class Word implements Serializable {
    private static final long serialVersionUID = -5254443854998426904L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text", length = 80)
    private String text;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "property_name", length = 150)
    private String propertyName;

}
