package exo1

import java.util.ArrayList

class main {
    fun main(args: ArrayList<String>){
        var listPersons = mutableListOf<Person>()
        listPersons.add(Person("Amine","BENBAKHTA",21))
        listPersons.add(Person("Rosane","BENKHELIL",19))
        listPersons.add(Person("Lotfi","DARSOUNI",21))
        listPersons.add(Person("Sidali","FAHAS",20))
        listPersons.add(Person("Mehdi","ARRAR",22))
        listPersons.add(Person("Reda","ZENAGUI",69))
        var orderedList = Exo1.orderByAge(listPersons)
        var filteredList = Exo1.filterByAge(listPersons)
        var freq = Exo1.freqChar("Ceci est un tres long message",'e')
    }
}