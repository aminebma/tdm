package com.example.exo2

class Pack(val giftName:String, val giftQte:Int, name: String, price: Long, Qte: Int) : Product(name, price, Qte) {

    var smartphoneList:MutableMap<Smartphone,Int> = mutableMapOf()

    fun addSmartphone(s:Smartphone,qtePhone:Int) = smartphoneList.put(s,qtePhone)

    override fun getType():String = "Pack"
}