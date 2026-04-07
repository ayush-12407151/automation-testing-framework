package com.example.demo.reporting;

import java.io.FileWriter;
import java.io.IOException;

import com.example.demo.analytics.AnalyticsService;

public class HTMLReportGenerator {

    public static void generateReport(){

        try{

            FileWriter writer = new FileWriter("reports/report.html");

            writer.write("<html><body>");
            writer.write("<h1>Automation Test Report</h1>");

            writer.write("<p>Total Tests: " + AnalyticsService.getTotal() + "</p>");
            writer.write("<p>Passed: " + AnalyticsService.getPassed() + "</p>");
            writer.write("<p>Failed: " + AnalyticsService.getFailed() + "</p>");

            writer.write("</body></html>");

            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}