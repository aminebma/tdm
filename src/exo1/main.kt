package exo1

fun main(args: Array<String>){
    var listPersons = mutableListOf<Person>()
    listPersons.add(Person("Amine", "BENBAKHTA", 21))
    listPersons.add(Person("Rosane", "BENKHELIL", 19))
    listPersons.add(Person("Lotfi", "DARSOUNI", 21))
    listPersons.add(Person("Sidali", "FAHAS", 20))
    listPersons.add(Person("Mehdi", "ARRAR", 22))
    listPersons.add(Person("Reda", "ZENAGUI", 17))
    var orderedList = Exo1.orderByAge(listPersons)
    var filteredList = Exo1.filterByAge(listPersons)
    var freq = Exo1.freqChar("Ceci est un tres long message",'e')
    println("Liste totale:")
    for(item in listPersons) println(item.firstname+" "+item.lastname+" "+item.age)
    println("\nListe ordonnée:")
    for(item in orderedList) println(item.firstname+" "+item.lastname+" "+item.age)
    println("\nListe filtrée:")
    for(item in filteredList) println(item.firstname+" "+item.lastname+" "+item.age)
    print("\nFrequence de la lettre \'e\' dans la phrase : \"Ceci est un tres long message\": $freq")
}