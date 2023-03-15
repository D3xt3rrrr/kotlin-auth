package com.webapp.jwt.security

import com.webapp.jwt.Service
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class ApplicationConfig(private val service: Service) {


    @Bean
    fun authenticationProvider() : AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(service)
        authProvider.setPasswordEncoder(bCryptPasswordEncoder())
        return authProvider
    }

    private fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder(16)
    }
}