package com.webapp.jwt.security

import com.webapp.jwt.Repository
import com.webapp.jwt.User
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(private val db: Repository): UserDetailsService  {
    override fun loadUserByUsername(username: String?): User? {
        return db.findByEmail(username)
    }
}