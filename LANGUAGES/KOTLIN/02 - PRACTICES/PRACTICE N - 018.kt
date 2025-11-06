package TP11_KOTLIN

// Exercice 1 : Calcul avec lambda

fun main () {

    fun calculate (a: Int, b: Int, lambda: (Int, Int) -> Int) : Int {
        return lambda (a, b)
    }

    var ajoute = calculate(33, 67) {a, b -> a + b}
    var soustraction = calculate(30, 100) {a, b -> a - b}
    var multiplication = calculate(9, 7) {a, b -> a * b}

    println("l'Ajoute : $ajoute")
    println("Soustraction : $soustraction")
    println("Multiplication : $multiplication")

}

// Run :

// l'Ajoute : 100
// Soustraction : -70
// Multiplication : 63


// ------------------------------------------------------------------------



// Exercice 2 : filtage d'une liste

fun main () {

    var nombres = List(10) { (1..100).random() }
    println("l'Affichage des nombres : " + nombres)

    var pairNombres = nombres.filter { it % 2 == 0 }
    println("Les nombres Pairs : $pairNombres")

    var nonPairNombres = nombres.filter { it % 2 != 0 }
    println("Les nombres inPairs : $nonPairNombres")

    var superrieurs = nombres.filter { it > 10 }
    println("Les nombres supperieures a 10 : $superrieurs")

}

// Run : 

// l'Affichage des nombres : [3, 45, 63, 15, 21, 22, 46, 100, 16, 23]
// Les nombres Pairs : [22, 46, 100, 16]
// Les nombres inPairs : [3, 45, 63, 15, 21, 23]
// Les nombres supperieures a 10 : [45, 63, 15, 21, 22, 46, 100, 16, 23]


// ------------------------------------------------------------------------



// Exercice 3 : Somme avec fonction anonyme

fun main () {

    var nombres = mutableListOf(10, 20, 30, 40, 50, 60)

    var sommeCalcul = fun (list: List<Int>) : Int {
        var somme = 0
        for (n in list) {
            somme += n
        }
        return somme
    }

    println("La somme des éléments : ${sommeCalcul(nombres)}")

}

//  Run 

// La somme des éléments : 210


// ------------------------------------------------------------------------

// Exercice 4 : Test pair/impair

fun main () {

    var pairCheck = { n: Int -> n % 2 == 0}

    var nombres = mutableListOf<Int>(1, 22, 3, 76, 9, 32, 23)

    for (n in nombres) {
        if (pairCheck(n)) { println("Le nombre : $n, est Pair 👍") }
        else { println("Le nombre : $n, est imPair !") }
    }

}


// Run :

// Le nombre : 1, est imPair !
// Le nombre : 22, est Pair 👍
// Le nombre : 3, est imPair !
// Le nombre : 76, est Pair 👍
// Le nombre : 9, est imPair !
// Le nombre : 32, est Pair 👍
// Le nombre : 23, est imPair !


// ------------------------------------------------------------------------


// Exercice 5 : Transformer une liste de chaines

fun main () {

    var names = mutableListOf<String>("Abderrafie", "Taha", "Obaida", "Adnane")
    println("La liste des nomes : $names")

    var tranforme = { n: String -> n.uppercase() }

    for (n in names) {
        tranforme(n)
        println("le nom '$n' en majuscule : " + tranforme(n))
    }

}

// Run :

// La liste des nomes : [Abderrafie, Taha, Obaida, Adnane]
// le nom 'Abderrafie' en majuscule : ABDERRAFIE
// le nom 'Taha' en majuscule : TAHA
// le nom 'Obaida' en majuscule : OBAIDA
// le nom 'Adnane' en majuscule : ADNANE


// ------------------------------------------------------------------------


import kotlin.random.Random

// Exercice 6 : Trier une liste

fun main () {

    var numbers = List(7) { (3..76).random() }
    println("La liste des nombres avant le Triage : $numbers")

    var triage = { ns: List<Int> -> ns.sorted() }
    println("La liste des nombres après le Triage : ${triage(numbers)}")

}

// Run :

// La liste des nombres apres le Triage : [75, 19, 61, 22, 9, 24, 34]
// La liste des nombres avant le Triage : [9, 19, 22, 24, 34, 61, 75]


// ------------------------------------------------------------------------


// Exercice 7 : Appliquer une opération sur chaque élément

fun main () {

    var numbers = List (10) { (2..23).random() }
    println("La liste des nombre avant la multiplication : $numbers")

    var multiple = { nbs: List<Int> -> nbs.map { it * 2 } }
    println("La liste des nombres après la multiplication : ${multiple(numbers)}")

}

// Run :

// La liste des nombre apres la multiplication : [21, 6, 17, 20, 3, 14, 6, 8, 3, 13]
// La liste des nombres avant la multiplication : [42, 12, 34, 40, 6, 28, 12, 16, 6, 26]


// ------------------------------------------------------------------------


// Exercice 8 : Vérification conditionnelle

fun main () {

    var nombres = List<Int>(10) { (1..90).random() }
    println("La liste des nombres : $nombres")

    var supperieur = { n: Int -> n > 50 }

    var unSupperieur = nombres.any(supperieur)
    var toutSupperieur = nombres.all(supperieur)

    println("Un nombre moins un nombre est supperieur a 50 ? : $unSupperieur")
    println("Tout les nombres sont supperieurs a 50 ? : $toutSupperieur")

}

// Run :

// La liste des nombres : [74, 1, 64, 79, 13, 42, 47, 32, 47, 76]
// Un nombre moins un nombre est supperieur a 50 ? : true
// Tout les nombres sont supperieurs a 50 ? : false

// ---

// Thanks for your reading to my code ❤
// @ rfchatt
