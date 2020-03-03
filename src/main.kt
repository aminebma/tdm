import exo1.Exo1
import exo1.Person
import exo2.WordGenerator
import exo3.Pack
import exo3.Product
import exo3.ProductManager
import exo3.Smartphone

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
    println("\nExercice 2:")
    var score:Int = 0
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

    //Exercice 3
    println("\nExercice 3:")
    val productManager:ProductManager = ProductManager()
    val productList:MutableList<Product> = mutableListOf()
    val smartphone1 = Smartphone("Samsung","Blanc","G980","Galaxy S20",150000L,10)
    val smartphone2 = Smartphone("Apple","Noir","AX11000","iPhone 11",180000L,7)
    val pack1:Pack=Pack(
        "Gift Name 1",
        5,
        "Pack de rentrée",
        500000,
        5
    )
    val pack2:Pack=Pack(
        "Gift Name 2",
        5,
        "Pack de fin d\'année",
        300000,
        5
    )

    pack1.addSmartphone(smartphone1,2)
    pack1.addSmartphone(smartphone2,3)
    pack2.addSmartphone(smartphone2,2)

    productList.add(smartphone1)
    productList.add(pack1)
    productList.add(smartphone2)
    productList.add(pack2)

    println("Nombre de smartphones: "+productManager.getTypeNumber(productList,"Smartphone"))
    println("Nombre de packs: "+productManager.getTypeNumber(productList,"Pack"))
    println("Packs du Samsung Galaxy S20:")
    for(p:Pack in productManager.getPacks(productList,"Galaxy S20"))
        println("   *"+p.name)
    println("Prix de la liste de produits: "+productManager.getTotalPrice(productList)+" DZD")
}