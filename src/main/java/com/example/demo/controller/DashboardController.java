package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.analytics.AnalyticsService;
import com.example.demo.repository.TestResultRepository;

@Controller
public class DashboardController {

    @Autowired
    private TestResultRepository repository;

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        model.addAttribute("total", AnalyticsService.getTotal());
        model.addAttribute("passed", AnalyticsService.getPassed());
        model.addAttribute("failed", AnalyticsService.getFailed());

        model.addAttribute("results", repository.findAll());

        return "dashboard";
    }
}