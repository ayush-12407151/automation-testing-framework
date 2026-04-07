package com.example.demo.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo.execution.SeleniumTestRunner;
import com.example.demo.execution.ApiTestRunner;
import com.example.demo.reporting.ReportGenerator;

public class TestExecutor {

    public String runAllTests() {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {

            Future<String> uiResult = executor.submit(() -> {
                SeleniumTestRunner uiTest = new SeleniumTestRunner();
                return uiTest.runTest();
            });

            Future<String> apiResult = executor.submit(() -> {
                ApiTestRunner apiTest = new ApiTestRunner();
                return apiTest.runTest();
            });

            String ui = uiResult.get();
            String api = apiResult.get();

            ReportGenerator report = new ReportGenerator();
            report.generateReport(ui, api);

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return "Tests executed and report generated.";
    }
}