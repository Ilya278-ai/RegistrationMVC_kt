package com.example.registrationmvc_kt.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "users")
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var premium = false
    var login: String = ""
    var password: String = ""
    var lvl: Int = 1
    var balance: Long = 0
        set(value) {
            if (field <= 100) {
                status = "бедняк"
            } else if (field <= 200) {
                status = "работяга"
            } else if (field > 500) {
                status = "бывалый"
            }
        }

    var localDate = LocalDate.now()
    var status = "бедняк"

    @ManyToMany
    @JoinTable(
        name = "user_business",
        joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "business_id", referencedColumnName = "id"))
    )

    var businesses: List<Business> = listOf()

    constructor(login: String, password: String) : this() {
        this.login = login
        this.password = password
        this.status = "бедняк"
    }


}