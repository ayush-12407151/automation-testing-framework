package com.example.demo.service;

import com.example.demo.execution.SeleniumTestRunner;
import com.example.demo.execution.ApiTestRunner;
import com.example.demo.scheduler.TestExecutor;

public class TestIntegrationService {

    public String runUITest(){
        SeleniumTestRunner runner = new SeleniumTestRunner();
        return runner.runTest();
    }

    public String runTest(){
        ApiTestRunner runner = new ApiTestRunner();
        return runner.runTest();
    }

    public String runAllTests(){
        TestExecutor executor = new TestExecutor();
        return executor.runAllTests();
    }
}