package com.webapp.jwt

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service;

@Service
class Service(val db: Repository) : UserDetailsService {
    val bCryptPasswordEncoder = BCryptPasswordEncoder(16)

    fun registration(email : String, password : String) : Boolean {
        val user = User(email = email, pass = bCryptPasswordEncoder.encode(password))
        db.save(user)
        return true
    }

    override fun loadUserByUsername(username: String?): User? {
        return db.findByEmail(username)
    }
}