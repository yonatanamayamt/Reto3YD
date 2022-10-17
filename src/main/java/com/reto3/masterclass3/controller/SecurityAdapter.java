package com.reto3.masterclass3.controller;

import org.springframework.web.bind.annotation.RestController;

/*@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws  Exception{
        http.authorizeRequests(a-> a
                .antMatchers("/","/error","/webjars/**","/api/**").permitAll()
                .anyRequest().authenticated()
        )/*.exceptionHandling(e->e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login();
        http.cors().and().csrf().disable();


    }

}*/