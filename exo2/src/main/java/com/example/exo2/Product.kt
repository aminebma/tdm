package com.example.exo2

abstract class Product(val name:String, val price:Long, val Qte:Int) {
    abstract fun getType():String
}