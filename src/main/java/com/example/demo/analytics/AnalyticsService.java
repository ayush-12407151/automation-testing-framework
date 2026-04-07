package com.example.demo.analytics;

import com.example.demo.model.TestResult;
import com.example.demo.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;

    private static TestResultRepository repository;

    @Autowired
    public void setRepository(TestResultRepository repo) {
        repository = repo;
    }

    public static void recordPass(String testName, double time) {

        totalTests++;
        passedTests++;

        repository.save(new TestResult(testName,"PASS",time));
    }

    public static void recordFail(String testName) {

        totalTests++;
        failedTests++;

        repository.save(new TestResult(testName,"FAIL",0));
    }

    public static int getTotal(){
        return totalTests;
    }

    public static int getPassed(){
        return passedTests;
    }

    public static int getFailed(){
        return failedTests;
    }
}