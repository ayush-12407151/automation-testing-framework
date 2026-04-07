package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.TestIntegrationService;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestIntegrationService service = new TestIntegrationService();

    @PostMapping("/integrate")
    public String integrateTests(){

        return service.runAllTests();
    }

    @GetMapping("/{id}")
    public String getTestById(@PathVariable int id){

        return "Test details for ID: " + id;
    }

}