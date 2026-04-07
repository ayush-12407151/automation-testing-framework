package com.example.demo;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void testHelloEndpoint() {

        given()
                .when()
                .get("http://localhost:8080/hello")
                .then()
                .statusCode(200)
                .body(equalTo("Spring Boot is working!"));

        System.out.println("API Test Passed!");
    }
}