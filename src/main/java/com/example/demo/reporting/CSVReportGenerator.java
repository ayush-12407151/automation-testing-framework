package com.example.demo.reporting;

import java.io.FileWriter;
import java.io.IOException;

import com.example.demo.analytics.AnalyticsService;

public class CSVReportGenerator {

    public static void generateReport(){

        try{

            FileWriter writer = new FileWriter("reports/report.csv");

            writer.write("Total,Passed,Failed\n");

            writer.write(
                    AnalyticsService.getTotal() + "," +
                            AnalyticsService.getPassed() + "," +
                            AnalyticsService.getFailed()
            );

            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}