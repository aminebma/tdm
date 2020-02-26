package exo1

import java.text.NumberFormat
import java.util.*

object Exo1 {
    fun orderByAge(p:MutableList<Person>) = p.sortedWith(compareBy({it.age}))
    fun filterByAge(p:MutableList<Person>) = p.filter { it.age>20 }
    fun freqChar(chaine:String,caract:Char):Int{
        var cpt=0
        for(car in chaine){
            if (car == caract) cpt++
        }
        return cpt
    }
    fun hundredsSeparator(num:Long) = NumberFormat.getInstance(Locale.FRANCE).format(num)
}

