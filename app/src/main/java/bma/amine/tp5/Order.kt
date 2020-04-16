package com.example.tp5

import java.io.Serializable
import java.util.*

data class Order(val num: Long, val date: Date, val orderList:List<OrderLine>):Serializable{
    var amount:Long = 0
}