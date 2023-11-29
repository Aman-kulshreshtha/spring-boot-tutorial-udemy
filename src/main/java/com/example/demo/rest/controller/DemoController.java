package com.example.demo.rest.controller;

import com.example.demo.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach coach;

    @Autowired
    public DemoController(Coach thisCoach) {
        coach = thisCoach;
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return coach.getDailyWorkout();
    }
}
