package com.example.registrationmvc_kt.model

import jakarta.persistence.*

@Entity
@Table(name = "Buisness")
class Business() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var name: String = ""
    var profit: Int = 0
    var price: Int = 0
    var premprice: Int = 0

    @ManyToMany(mappedBy = "businesses")
    var users: List<User> = listOf()

    constructor(name: String, profit: Int, price: Int = 0) : this() {
        this.name = name
        this.profit = profit
        this.price = price
        this.premprice = price
    }

}