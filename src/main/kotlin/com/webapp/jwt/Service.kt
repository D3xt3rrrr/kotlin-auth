package com.webapp.jwt

import org.bson.conversions.Bson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service;

@Service
class Service(
    val db: Repository,
    val auth : AuthenticationManager
) {


    fun registration(email : String, password : String) : Boolean {
        val bCryptPasswordEncoder : BCryptPasswordEncoder = BCryptPasswordEncoder(16)
        val user = User(email = email, pass = bCryptPasswordEncoder.encode(password))
        db.save(user)
        return true
    }

    fun login(user : User) {

        auth
            .authenticate(
                UsernamePasswordAuthenticationToken(
                    user.email,
                    user.pass
                )
            )
    }
}

