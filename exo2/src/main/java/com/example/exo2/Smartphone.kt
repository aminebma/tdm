package com.example.exo2

class Smartphone(val brand:String, val color:String, val model:String,
                 name:String, price: Long, Qte: Int) : Product(name, price, Qte){

    override fun getType():String = "Smartphone"
}