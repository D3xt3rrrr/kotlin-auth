package com.webapp.jwt.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityBuilder
import org.springframework.security.config.annotation.web.WebSecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun securityFilterChain(http : HttpSecurity) : SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**").permitAll()
            .anyRequest()
            .authenticated().and()
            .formLogin()
        //http.addFilter()

        return http.build()
    }

}