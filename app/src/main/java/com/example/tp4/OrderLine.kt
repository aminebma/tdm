package com.example.tp4

import java.io.Serializable

data class OrderLine(val product: Product, var qteOrder: Int):Serializable