package com.front.end.pk.encrypt.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
          http.csrf().disable()
            .authorizeRequests()
                  .antMatchers(
                          "/",
                          "/signup",
                          "/update",
                          "/savePassword",
                        "/getKeyPair.html").permitAll()
                  .and().formLogin().disable();

    }
}
