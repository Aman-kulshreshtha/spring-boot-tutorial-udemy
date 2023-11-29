package com.example.demo.coaches;

import com.example.demo.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice tennis for 20 minutes";
    }
}
