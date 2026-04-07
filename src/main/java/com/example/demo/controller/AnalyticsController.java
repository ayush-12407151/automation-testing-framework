package com.example.demo.controller;

import com.example.demo.repository.TestResultRepository;
import com.example.demo.model.TestResult;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final TestResultRepository repository;

    public AnalyticsController(TestResultRepository repository){
        this.repository = repository;
    }

    @GetMapping("/trends")
    public String getTrends(){

        List<TestResult> results = repository.findAll();

        int pass = 0;
        int fail = 0;

        for(TestResult r : results){
            if(r.getStatus().equals("PASS")){
                pass++;
            } else {
                fail++;
            }
        }

        return "Total: " + results.size() +
                " | Passed: " + pass +
                " | Failed: " + fail;
    }
}