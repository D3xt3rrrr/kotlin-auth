package com.webapp.jwt.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class CustomAuthenticationFilter: OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response : HttpServletResponse, filter : FilterChain) {
        filter.doFilter(request, response)
    }
}