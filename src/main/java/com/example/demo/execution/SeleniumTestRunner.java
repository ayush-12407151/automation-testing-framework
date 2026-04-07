package com.example.demo.execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.example.demo.logging.TestLogger;
import com.example.demo.analytics.AnalyticsService;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SeleniumTestRunner {

    public String runTest() {

        WebDriver driver = new ChromeDriver();
        TestLogger.log("Starting UI Test");

        long startTime = System.currentTimeMillis();

        try {

            driver.get("https://www.google.com");

            String title = driver.getTitle();

            if (!title.contains("Google")) {

                takeScreenshot(driver);
                AnalyticsService.recordFail("UI Test");
                TestLogger.log("UI Test FAILED");

                return "UI Test FAILED";
            }

            long endTime = System.currentTimeMillis();
            double executionTime = (endTime - startTime) / 1000.0;

            AnalyticsService.recordPass("UI Test", executionTime);
            TestLogger.log("UI Test PASSED");

            return "UI Test PASSED";

        } catch (Exception e) {

            takeScreenshot(driver);
            AnalyticsService.recordFail("UI Test");
            TestLogger.log("UI Test FAILED");

            return "UI Test FAILED";

        } finally {

            driver.quit();
        }
    }

    private void takeScreenshot(WebDriver driver) {

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/failure.png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot captured.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}