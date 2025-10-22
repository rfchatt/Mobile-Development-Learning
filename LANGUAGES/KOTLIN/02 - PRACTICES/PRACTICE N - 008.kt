// path : 

//__________________________
//src ¬                     |
//  TP3_KOTLIN (package) ¬  |
//       Exercise_1.kt      |
//       Exercise_2.kt      | 
//__________________________|

// ----------------------------------------------------------------------------
 
// Exercice_1.kt
package TP3_KOTLIN
  
// Exercice 1

fun startsWithVowel () {
    print("Entrer un mots :  ")
    val nom = readln()

    when (nom.first().lowercaseChar()) {
        'a' -> println("true => Le mots '$nom' commence par une voyelle : [a]")
        'e' -> println("true => Le mots '$nom' commence par une voyelle : [e]")
        'i' -> println("true => Le mots '$nom' commence par une voyelle : [i]")
        'o' -> println("true => Le mots '$nom' commence par une voyelle : [o]")
        'u' -> println("true => Le mots '$nom' commence par une voyelle : [u]")
        else -> println("false => Le mots '$nom' ne commence pas par une voyelle !")
    }
}

fun main () {

    println()
    println("=== Vowel Starting detector ===")
    println()

    while (true) {
        startsWithVowel()
    }

}

// Terminal :

//   _________________________________________________________
//                                                            |
// === Vowel Starting detector ===                            |
//                                                            |
// Entrer un mots :  Abderrafie                               |
// true => Le mots 'Abderrafie' commence par une voyelle : [a]|
//                                                            |
//   _________________________________________________________|



// ----------------------------------------------------------------------------


// Exercice_2.kt
package TP3_KOTLIN

// Exercise 2

// --- 1) Appareil
open class Appareil (var marque: String, var modele: String) {

    open fun afficherDetails () {
        println("La marque : $marque")
        println("Le modele : $modele")
    }

}

// --- 2) AppareilBase
open class AppareilBase (marque: String, modele: String) : Appareil (marque, modele) {

    open fun allumer () {
        println("L'appareil est allumé")
    }

}

// --- 3) Telephone
open class Telephone (marque: String, modele: String, var capaciteBatterie : Int, var consommationParHeure : Int) : AppareilBase (marque, modele) {

    open fun appeler () {
        println("Appel en cours ...")
    }

    open fun calculerAutonomie (capaciteBatterie: Int, consommationParHeure: Int) : Int {
        var autonomie = capaciteBatterie / consommationParHeure
        return autonomie;
    }

    override fun afficherDetails () {
        super.afficherDetails()
        println("La capacité de Batterie : $capaciteBatterie mAh")
        println("Consommation de Batterie : $consommationParHeure mAh/h")
    }

}

// --- 4) Ordinateur
open class Ordinateur (var memoireRAM: Int, var prix: Double, marque: String, modele: String) : Appareil (marque, modele) {

    open fun executerProgramme () {
        println("Programme en execution !")
    }

    open fun performance () : Double {
        var performance = memoireRAM * 12.5
        println("Performmance d'ordinateur : $performance")
        return performance;
    }

    override fun afficherDetails () {
        super.afficherDetails()
        println("La memoire RAM : $memoireRAM RAM")
        println("Le Prix d'Ordinateur : $prix DH")
    }
}

// --- 5) l'Execution
fun main () {

    // --- 5) -1)
    var telephone1 = Telephone("Samsung", "A53 5G", 5000, 200)
    var telephone2 = Telephone("Iphone", "17 Air", 3150, 262)

    var ordinateur1 = Ordinateur(8, 4500.0, "FUJITSU", "lifebook S935")
    var ordinateur2 = Ordinateur(16, 15000.0, "hp", "OmniBook")

    // --- 5) -2)
    // Objet 1 de class Telephone
    telephone1.afficherDetails()
    telephone1.allumer()
    telephone1.appeler()
    println()
    // Objet 2 de class Telephone
    telephone2.afficherDetails()
    telephone2.allumer()
    telephone2.appeler()
    println()

    // Objet 1 de class Ordinateur
    ordinateur1.executerProgramme()
    ordinateur1.performance()
    ordinateur1.afficherDetails()
    println()
    // Objet 2 de class Ordinateur
    ordinateur2.executerProgramme()
    ordinateur2.performance()
    ordinateur2.afficherDetails()
    println()

    // --- 5) -3) > 1
    // Calculer l'autonomie des objets telephpnes
    var autonomie1 = telephone1.calculerAutonomie(5000, 200)
    var autonomie2 = telephone2.calculerAutonomie(3150, 262)
    println()

    // --- 5) -3) > 2
    // Calculer la performmance des Objets ordinateurs
    var performmance1 = ordinateur1.performance()
    var performmance2 = ordinateur2.performance()
    println()

    // --- 5) -3) > 3
    // Calculer la meilleur autonomie
    when {
        autonomie1 > autonomie2 -> println("L'autonomie de Telephone ${telephone1.marque} ${telephone1.modele} est la meilleur !")
        autonomie2 > autonomie1 -> println("L'autonomie de Telephone ${telephone2.marque} ${telephone2.modele} est la meilleur !")
    }
    println()

    // --- 5) -3) > 4
    // Calculer la meilleur performmance
    when {
        performmance1 > performmance2 -> println("La performmance de Telephone ${ordinateur1.marque} ${ordinateur1.modele} est la meilleur !")
        performmance2 > performmance1 -> println("La performmance de Telephone ${ordinateur2.marque} ${ordinateur2.modele} est la meilleur !")
    }

}


// Terminal :


//   _________________________________________________________
// La marque : Samsung                                        |
// Le modele : A53 5G                                         |
// La capacité de Batterie : 5000 mAh                         |
// Consommation de Batterie : 200 mAh/h                       |
// L'appareil est allumé                                      |
// Appel en cours ...                                         |
//                                                            |
// La marque : Iphone                                         |
// Le modele : 17 Air                                         |
// La capacité de Batterie : 3150 mAh                         |
// Consommation de Batterie : 262 mAh/h                       |
// L'appareil est allumé                                      |
// Appel en cours ...                                         |
//                                                            |
// Programme en execution !                                   |
// Performmance d'ordinateur : 100.0                          |
// La marque : FUJITSU                                        |
// Le modele : lifebook S935                                  |
// La memoire RAM : 8 RAM                                     |
// Le Prix d'Ordinateur : 4500.0 DH                           |
//                                                            |
// Programme en execution !                                   |
// Performmance d'ordinateur : 200.0                          |
// La marque : hp                                             |
// Le modele : OmniBook                                       |
// La memoire RAM : 16 RAM                                    |
// Le Prix d'Ordinateur : 15000.0 DH                          |
//                                                            |
// Performmance d'ordinateur : 100.0                          |
// Performmance d'ordinateur : 200.0                          |
//                                                            |
// L'autonomie de Telephone Samsung A53 5G est la meilleur !  |
//                                                            |
// La performmance de Telephone hp OmniBook est la meilleur ! |
// ___________________________________________________________|

// Abderrafie (@ rfchatt)
