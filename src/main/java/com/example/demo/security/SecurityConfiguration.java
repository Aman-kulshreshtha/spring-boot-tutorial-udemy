package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}test123")
                            .roles("EMPLOYEE")
                            .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);

    }

    // COde for restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(
                config-> {
                    config.requestMatchers(HttpMethod.GET,"/api/employee").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/api/employee/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.PUT,"/api/employee/**").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasRole("ADMIN");
                }
        );

        // tell spring boot to use basic auth

        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable csrf
        // in general csrf is not required for stateless REST api calls that use methods like POST, PUT, PATCH or DELETE
        httpSecurity.csrf(csrf->csrf.disable());

        return httpSecurity.build();
    }

}
