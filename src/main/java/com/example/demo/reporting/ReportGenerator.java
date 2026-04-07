package com.example.demo.reporting;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReportGenerator {

    public void generateReport(String uiResult, String apiResult){

        try {

            FileWriter writer = new FileWriter("test-report.txt");

            writer.write("Automation Test Execution Report\n");
            writer.write("---------------------------------\n");
            writer.write("Execution Time: " + LocalDateTime.now() + "\n\n");

            writer.write("UI Test Result: " + uiResult + "\n");
            writer.write("API Test Result: " + apiResult + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}