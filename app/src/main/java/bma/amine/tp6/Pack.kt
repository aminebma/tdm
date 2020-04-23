package bma.amine.tp6

class Pack(val giftName:String, val giftQte:Int, name: String, price: Long, Qte: Int, image: Int, description: String )
                : Product(name, price, Qte, image, description) {

    var smartphoneList:MutableMap<Smartphone,Int> = mutableMapOf()

    fun addSmartphone(s:Smartphone,qtePhone:Int) = smartphoneList.put(s,qtePhone)
}