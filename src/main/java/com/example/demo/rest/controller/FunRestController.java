package com.example.demo.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // injecting custom properties from properties file namely machine.name and machine.company

    @Value("${machine.name}")
    private String machineName;

    @Value("${machine.company}")
    private String machineCompany;


    // exposes a simple "/" endpoint that will return a string "Hello World!" at the endpoint
    // for local the endpoint is "http://localhost:8080/"
    @GetMapping("/") // using greet url from the properties file ( application.properties ) in this case /greet
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/work")
    public String getWork() {
        return "Your work for today is to chill !!";
    }

    @GetMapping("/machine")
    public String getMachineDetails() {
        return "This is running on an "+ machineCompany + " " + machineName;
    }

}
