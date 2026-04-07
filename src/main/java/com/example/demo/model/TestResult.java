package com.example.demo.model;

public class TestResult {

    private int id;
    private String testName;
    private String status;
    private double executionTime;

    public TestResult(){}

    public TestResult(String testName,String status,double executionTime){
        this.testName=testName;
        this.status=status;
        this.executionTime=executionTime;
    }

    public String getTestName(){ return testName; }
    public String getStatus(){ return status; }
    public double getExecutionTime(){ return executionTime; }

}