package com.example.tp4

import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Order(val num: Long, val date: LocalDate, val orderList:List<OrderLine>):Serializable{
    var amount:Long = 0
}