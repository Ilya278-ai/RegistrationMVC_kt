package com.example.registrationmvc_kt.service

import com.example.registrationmvc_kt.model.User
import com.example.registrationmvc_kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(var userRepository : UserRepository) {

    fun save(user : User) : User {
        return userRepository.save(user)
    }


    fun findAll() : List<User> {
        return userRepository.findAll();
    }
}