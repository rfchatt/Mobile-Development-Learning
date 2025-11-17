package TP16_KOTLIN

// TP 16 | Lateinit, By lazy, Try-catch

// Exercice 1 : --

class Vehicule () {

    lateinit var name: String

    val description: String by lazy {
        println("Description ...")
        "Nom : $name"
    }

}



fun main() {

    var obj = Vehicule()

    println("--- Avant l'Initialisation ---")
    // println(obj.description)     // Erreur

    println("-- l'Initialisation --")
    obj.name = "Dacia"

    println("-- Aprés Initialisation --")
    println(obj.description)

}

// Run : 

//--- Avant l'Initialisation ---
//-- l'Initialisation --
//-- Aprés Initialisation --
//Description ...
//Nom : Dacia


// -----------------------------------------------------------------------


package TP16_KOTLIN

// Exercice 2 : --

var num1 = 37
var num2 = 19

val addition by lazy {
    num1 + num2
}

val soustraction by lazy {
    num1 - num2
}

val multiplication by lazy {
    num1 * num2
}

val division by lazy {
    num1 / num2
}

fun main() {

    println("Addition de [$num1] (+) [$num2] = $addition")
    println("Soustraction [$num1] (-) [$num2] = $soustraction")
    println("Multiplication [$num1] (x) [$num2] = $multiplication")
    println("Division [$num1] (/) [$num2] = $division")

}

// Run :

//Addition de [37] (+) [19] = 56
//Soustraction [37] (-) [19] = 18
//Multiplication [37] (x) [19] = 703
//Division [37] (/) [19] = 1


// -----------------------------------------------------------------------


package TP16_KOTLIN

// Exercice 3 : --

open class Configuration () {

    init {
        println("Configuration en cours..")
        Thread.sleep(2000)
    }

    var databasURL = "mysql://localhost:3306/rfchatt"

    fun afficherConf () {
        println("Configuration compléte : ")
        println(" - Base de données : $databasURL")
    }

}

class App {

    val config by lazy {
        println("Début de chargement..")
        Configuration()
    }

    fun start() {
        println("Application démarée !")
        println("Configuration pas encours chargée..")
    }

}

fun main () {

    var app = App()

    app.start()

    app.config.afficherConf()

}

// Run :

// Application démarée !
// Configuration pas encours chargée..
// Début de chargement..
// Configuration en cours..
// Configuration compléte :
// - Base de données : mysql://localhost:3306/rfchatt


// -----------------------------------------------------------------------


package TP16_KOTLIN

// Exercice 4 : --

class UtilisateurService () {

    fun chargerUtilisateurs () {
        println("Utilisateurs chargés")
    }

}

class Application () {

    lateinit var utilisateurService: UtilisateurService

    fun initialiser () {
        println("Service initialisé")
        utilisateurService = UtilisateurService()
    }

    fun utiliser () {
        utilisateurService.chargerUtilisateurs()
    }

}



fun main() {

    val app = Application()

    app.initialiser()

    app.utiliser()

}

// Run : 

// Service initialisé
// Utilisateurs chargés


// -----------------------------------------------------------------------


package TP14_KOTLIN

// Exercice 5 : --

class monClass : Runnable {

    override fun run () {
        for (l in 'A'..'Z') {
            println(l)
            Thread.sleep(500)
        }
    }

}

fun main () {

    var obj = Thread(monClass())
    obj.start()

}

// Run :

// A + (delai de 500ms)
// B
// C
// D
// E
// F
// G
// H
// I
// J
// K
// L
// M
// N
// O
// P
// Q
// R
// S
// T
// U
// V
// W
// X
// Y
// Z


// -----------------------------------------------------------------------
