package com.example.demo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    // exposes a simple "/" endpoint that will return a string "Hello World!" at the endpoint
    // for local the endpoint is "http://localhost:8080/"
    @GetMapping("${url.greet}") // using greet url from the properties file ( application.properties ) in this case /greet
    public String sayHello() {
        return "Hello World!";
    }
}
