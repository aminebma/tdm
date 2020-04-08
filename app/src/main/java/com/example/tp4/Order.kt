package com.example.tp4

import java.util.*

data class Order(val num: Long, val date: Date, val orderList:List<OrderLine>, var amount:Int)