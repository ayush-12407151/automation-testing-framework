package com.example.demo.controller;

import com.example.demo.repository.TestResultRepository;
import com.example.demo.model.TestResult;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final TestResultRepository repository;

    public ResultController(TestResultRepository repository){
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public TestResult getResult(@PathVariable int id){
        return repository.findById(id);
    }
}