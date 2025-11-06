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


