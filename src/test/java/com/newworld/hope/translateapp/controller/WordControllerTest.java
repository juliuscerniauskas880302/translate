package com.newworld.hope.translateapp.controller;

import com.newworld.hope.translateapp.service.WordService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.when;

class WordControllerTest {

    @Mock
    private WordService wordService;

    @InjectMocks
    private WordController wordController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        RestAssured.port = 8080;
    }

    @Test
    public void testGetAllWords() {
        when(wordService.getAllWords()).thenReturn(Collections.emptyList());

        Response response = given()
                .when()
                .get("/words")
                .then()
                .statusCode(200)
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .extract()
                .response();
    }
}