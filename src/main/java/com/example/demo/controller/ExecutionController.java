package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.analytics.AnalyticsService;

@RestController
public class ExecutionController {

    @GetMapping("/execution/status")
    public String getExecutionStatus(){

        int total = AnalyticsService.getTotal();
        int pass = AnalyticsService.getPassed();
        int fail = AnalyticsService.getFailed();

        return "Total Tests: " + total +
                " | Passed: " + pass +
                " | Failed: " + fail;
    }
}