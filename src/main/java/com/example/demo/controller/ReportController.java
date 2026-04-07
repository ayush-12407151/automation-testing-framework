package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reporting.HTMLReportGenerator;
import com.example.demo.reporting.CSVReportGenerator;

@RestController
public class ReportController {

    @GetMapping("/reports/generate")
    public String generateReports(){

        HTMLReportGenerator.generateReport();
        CSVReportGenerator.generateReport();

        return "Reports Generated Successfully";
    }
}