package bma.amine.tp5

import java.io.Serializable

open class Product(val name:String, val price:Long, val Qte:Int, val image: Int, val description: String):Serializable {
}