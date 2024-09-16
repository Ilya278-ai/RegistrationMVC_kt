package com.example.registrationmvc_kt.controler

import com.example.registrationmvc_kt.repository.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClockRestController(val userRepository: UserRepository) {

    @PostMapping("/increment")
    fun increment(@RequestBody requestBody: Map<String, Long>): Map<String, Long> {
        val userId = requestBody["userId"] ?: return mapOf("newBalance" to 0)

        val optionalUser = userRepository.findById(userId)

        if (optionalUser.isPresent) {
            val user = optionalUser.get()
            user.balance += 1
            userRepository.save(user)
            println("click")
            return mapOf("newBalance" to user.balance)
        }

        println("not id")
        return mapOf("newBalance" to 0)
    }
}

