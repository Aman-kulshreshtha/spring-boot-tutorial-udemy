package com.example.demo.config;

import com.example.demo.coaches.BaseballCoach;
import com.example.demo.coaches.CricketCoach;
import com.example.demo.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsCoachConfig {

    @Bean
    public Coach cricketCoach() {
        return new CricketCoach();
    }

    @Bean
    public Coach baseballCoach() {
        return new BaseballCoach();
    }

}
