package com.example.tp4

class Smartphone(val brand:String, val color:String, val model:String,
                       name:String, price: Long, Qte: Int) : Product(name, price, Qte){

    fun getType():String = "Smartphone"
}