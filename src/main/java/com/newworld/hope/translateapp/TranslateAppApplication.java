package com.newworld.hope.translateapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newworld.hope.translateapp")
public class TranslateAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslateAppApplication.class, args);
    }

}
