package bma.amine.tp5

class Smartphone(val brand:String, val color:String, val model:String,
                       name:String, price: Long, Qte: Int, image: Int, description: String) : Product(name, price, Qte, image, description){

    fun getType():String = "Smartphone"
}