package bma.amine.tp5

import java.io.Serializable

data class OrderLine(val product: Product, var qteOrder: Int):Serializable