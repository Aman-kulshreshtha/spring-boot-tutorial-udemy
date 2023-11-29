package com.example.demo.coaches;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice baseball for 20 minutes....";
    }
}
