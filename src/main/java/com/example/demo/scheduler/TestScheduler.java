package com.example.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

    private final TestExecutor executor = new TestExecutor();

    @Scheduled(fixedRate = 30000)
    public void runScheduledTests(){

        System.out.println("Running Scheduled Tests...");

        executor.runAllTests();

    }
}