package com.example.registrationmvc_kt.repository

import com.example.registrationmvc_kt.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User,Long> {
    fun findByLoginAndPassword(login:String,password:String):User?
}