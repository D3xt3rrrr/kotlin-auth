package com.webapp.jwt

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Document("user")
data class User(
    @Id
    val id : ObjectId = ObjectId(),
    val email : String,
    val pass : String,
    @Transient
    var grantedAuthorities: MutableCollection<out GrantedAuthority> = mutableListOf()
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.grantedAuthorities
    }

    override fun getPassword(): String {
        return this.pass
    }


    override fun getUsername(): String {
        return this.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}


