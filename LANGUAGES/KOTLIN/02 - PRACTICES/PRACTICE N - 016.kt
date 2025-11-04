package TP9_KOTLIN

// Exercice 1 :

fun main () {

    // 1. ---
    var stagiaires = mutableListOf<String>()
    println(stagiaires) // []

    // 2. ---
    stagiaires.add("Abderrafie")
    stagiaires.add("Barae")
    stagiaires.add("Ahmed")
    println(stagiaires) // [Abderrafie, Barae, Ahmed]

    // 3. ---
    stagiaires.remove("Ahmed")
    println(stagiaires) // [Abderrafie, Barae]

    // 4. ---
    var recherche1 = stagiaires.find { it == "Barae" }
    println(recherche1) // Barae
    var recherche2 = stagiaires.find { it == "Mohamed" }
    println(recherche2) // null

    // 5. ---
    var taille = stagiaires.size
    println(taille) // 2

}


// --------------------------------------------------------------


//Exercice 2 :

fun main () {

    // 1. ---
    var nombres = mutableSetOf<Int>()
    println(nombres) // []

    // 2. ---
    nombres.add(7)
    nombres.add(30)
    nombres.add(55)
    nombres.add(61)
    println(nombres) // [7, 30, 55, 61]

    // 3. ---
    nombres.remove(55)
    println(nombres) // [7, 30, 61]

    // 4. ---
    var recherche1 = nombres.find { it == 30 }
    println(recherche1) // 30
    var recherche2 = nombres.find { it == 78 }
    println(recherche2) // null

    // 5. ---
    println(nombres) // [7, 30, 61]

}


// --------------------------------------------------------------


// Exercice 3 :

fun main () {

    // 1. ---
    var stagiaires = mutableMapOf(
                    "Abderrafie" to 20,
                    "Youssef" to 27,
                    "Imad" to 24,
                    "Amal" to 26
                    )
    println(stagiaires) // {Abderrafie=20, Youssef=27, Imad=24, Amal=26}

    // 2. ---
    stagiaires.remove("Amal")
    println(stagiaires) // {Abderrafie=20, Youssef=27, Imad=24}

    // 3. ---
    println(stagiaires["Youssef"]) // 27

    // 4. ---
    println(stagiaires) // {Abderrafie=20, Youssef=27, Imad=24}

}


// --------------------------------------------------------------


//Exercice 4 :

fun main () {

    // 1. ---
    var annees = mutableListOf<Int>()
    println(annees) // []

    // 2. ---
    annees.add(2008)
    annees.add(2005)
    annees.add(2033)
    annees.add(2029)
    println(annees) // [2008, 2005, 2033, 2029]

    // 3. ---
    var anneesV2 = annees.toList()

    // 4. ---
    annees.sort()
    println(annees) // [2005, 2008, 2029, 2033]

    // 5. ---
    println(annees) // mutable et Trie => [2005, 2008, 2029, 2033]
    println(anneesV2) // [2008, 2005, 2033, 2029]

  
}


