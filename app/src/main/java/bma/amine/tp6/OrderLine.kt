package bma.amine.tp6

import java.io.Serializable

data class OrderLine(val product: Product):Serializable{
    var qteOrder:Int = 0
}