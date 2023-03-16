package com.webapp.jwt

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/auth")
class Controller(val service : Service) {
    @PostMapping("/login")
    fun login(@RequestParam email: String, password: String) : String {
        service.login(
            User (
                email = email,
                pass = password
            )
        )
        return "user authenticate"
    }

    @PostMapping("/registration")
    fun register(@RequestParam email: String, password : String) : String {
        service.registration(email, password)
        return email + password;
    }
}