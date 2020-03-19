package com.example.tp3

class Pack(val giftName:String, val giftQte:Int, name: String, price: Long, Qte: Int): Product(name,
    price, Qte) {

    var smartphoneList:MutableMap<Smartphone,Int> = mutableMapOf()

    fun addSmartphone(s:Smartphone,qtePhone:Int) = smartphoneList.put(s,qtePhone)

    fun getType():String = "Pack"
}