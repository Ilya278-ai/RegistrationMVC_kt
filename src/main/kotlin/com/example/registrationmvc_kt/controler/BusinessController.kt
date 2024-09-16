package com.example.registrationmvc_kt.controler

import ch.qos.logback.core.model.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BusinessController {

    @GetMapping("/business/add")
    fun add(model: Model): String {
        return "addbuisness"
    }

    @GetMapping("/business")
    fun login(model: Model): String {
        return "business_menu"
    }

}