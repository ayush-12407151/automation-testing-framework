package com.example.demo.execution;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.example.demo.logging.TestLogger;
import com.example.demo.analytics.AnalyticsService;

public class ApiTestRunner {

    public String runTest() {

        TestLogger.log("Starting API Test");

        long startTime = System.currentTimeMillis();

        try {

            Response response = RestAssured
                    .given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/posts/1");

            int statusCode = response.getStatusCode();

            if (statusCode != 200) {

                AnalyticsService.recordFail("API Test");
                TestLogger.log("API Test FAILED");

                return "API Test FAILED";
            }

            long endTime = System.currentTimeMillis();
            double executionTime = (endTime - startTime) / 1000.0;

            AnalyticsService.recordPass("API Test", executionTime);
            TestLogger.log("API Test PASSED");

            return "API Test PASSED";

        } catch (Exception e) {

            AnalyticsService.recordFail("API Test");
            TestLogger.log("API Test FAILED");

            return "API Test FAILED";
        }
    }
}