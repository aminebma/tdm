import exo1.Exo1
import exo1.Person
import exo2.WordGenerator

fun main(args: Array<String>){

    //Exercice 1
    println("Exercice 1:")
    var listPersons = mutableListOf<Person>()
    listPersons.add(Person("Amine", "BENBAKHTA", 21))
    listPersons.add(Person("Anis", "MEHENNI", 19))
    listPersons.add(Person("Lotfi", "DARSOUNI", 21))
    listPersons.add(Person("Sidali", "FAHAS", 20))
    listPersons.add(Person("Mehdi", "ARRAR", 22))
    listPersons.add(Person("Reda", "ZENAGUI", 17))
    var orderedList = Exo1.orderByAge(listPersons)
    var filteredList = Exo1.filterByAge(listPersons)
    var freq = Exo1.freqChar("Ceci est un tres long message", 'e')
    println("Liste totale:")
    for(item in listPersons) println(item.firstname+" "+item.lastname+" "+item.age)
    println("\nListe ordonnée:")
    for(item in orderedList) println(item.firstname+" "+item.lastname+" "+item.age)
    println("\nListe filtrée:")
    for(item in filteredList) println(item.firstname+" "+item.lastname+" "+item.age)
    println("\nFrequence de la lettre \'e\' dans la phrase : \"Ceci est un tres long message\": $freq")

    //Exercice 2
    var score:Int = 0
    println("Exercice 2:")
    var wordList = mutableListOf<String>()
    wordList.add("Bonjour")
    wordList.add("Ordinateur")
    wordList.add("Piano")
    var wordGenerator = WordGenerator(wordList)
    var word:String = ""
    var stop:Boolean = false
    while(!stop){
        print("Entrez un mot:")
        var userWord = readLine()
        word = wordGenerator.generateWord()
        var result = if (userWord.equals(word)){
            score+=5
            "Bravo !!!! Vous avez obtenu 5 points, le score total est : $score points"
        }else{
            "Echec !!!!  le score total est : $score points"
        }
        println(result+".\nAppuyez sur q pour quitter le jeu: ")
        if(readLine().equals("q")) stop=true
    }

}