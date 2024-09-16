package com.example.registrationmvc_kt.controler

import com.example.registrationmvc_kt.model.User
import com.example.registrationmvc_kt.repository.UserRepository
import com.example.registrationmvc_kt.service.UserService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
class Controller(var service: UserService) {

    @Autowired
    private lateinit var httpServletResponse: HttpServletResponse

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    var userRepository: UserRepository? = null


    @GetMapping("/home")
    fun home(): String {
        return "home"
    }


    @GetMapping("/login")
    fun login(): String {
        return "log_into"
    }

    @GetMapping("/information")
    fun information(): String {
        return "information"
    }

    @GetMapping("/registration")
    fun registration(): String {
        return "registration"
    }

    @GetMapping("/stats")
    fun stats(): String {
        return "stats"
    }

    @PostMapping("/reg")
    fun reg(
        @RequestParam login: String,
        @RequestParam password: String,
        @RequestParam password2: String,
        @RequestParam date: LocalDate,
        model: Model
    ): String {

        println("login $login")
        println("pass $password")
        println("pass2 $password2")
        println("date $date")

        if (password != password2) {
            model.addAttribute("message", "пароли не совпадают")
            return "registration"
        }

        var user = User()
        user.login = login;
        user.password = password;
        user.localDate = date;

        userService.save(user)
        return "home"
    }

    @GetMapping("/authorization")
    fun authorization(
        @RequestParam login: String,
        @RequestParam password: String,
        model: Model
    ): String {

        var user = userRepository!!.findByLoginAndPassword(login, password)

        if (user == null) {
            model.addAttribute("message", "Логин или пароль не верны")
            return "log_into"
        }

        model.addAttribute("balance", user.balance)
        model.addAttribute("level", user.lvl)
        model.addAttribute("userId", user.id)
        model.addAttribute("login", login)
        return "stats"


    }

    @GetMapping("/statistick")
    fun statistick(model: Model): String {

        val users = service.findAll();
        model.addAttribute("users", users)
        return "statistick"
    }






}
