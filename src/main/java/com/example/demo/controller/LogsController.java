package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logging.TestLogger;

@RestController
public class LogsController {

    @PostMapping("/logs/collect")
    public String collectLogs(){

        TestLogger.log("Logs collected");

        return "Logs collected successfully";
    }
}