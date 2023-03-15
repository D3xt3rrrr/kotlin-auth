package com.webapp.jwt

import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.data.mongodb.repository.MongoRepository;


interface Repository : MongoRepository<User, String> {
    fun findByEmail(email : String?) : User?
}