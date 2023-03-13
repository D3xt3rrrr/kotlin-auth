package com.webapp.jwt

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class Controller {
    @GetMapping("/")
    fun hello() : String {
        return "hello world";
    }
}