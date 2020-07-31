package com.newworld.hope.translateapp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCreateWord {

    private final String CONTEXT_PATH = "/";
    private final String BASE_URI = "http://localhost";
    private final int PORT = 8080;
    private final String APPLICATION_JSON = "application/json";

    @BeforeEach
    void setUp() throws Exception {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = PORT;
    }

    @Test
    final void testCreateWord() {
        Map<String, Object> wordDetails = new HashMap<>();
        wordDetails.put("text", "Arrival");
        wordDetails.put("description", "Arrival port");
        wordDetails.put("propertyName", "logbook.arrival.port");

        Response response = given()
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(wordDetails)
                .when()
                .post("/words")
                .then()
                .statusCode(200)
                .contentType(APPLICATION_JSON)
                .extract()
                .response();

        long id = Long.parseLong(response.jsonPath().getString("id"));
        assertNotNull(id);
    }

}
