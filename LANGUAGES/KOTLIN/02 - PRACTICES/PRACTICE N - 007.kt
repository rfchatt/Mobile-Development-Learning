// TP 3 : Exercice 1

// file Ex1.kt

fun main () {

    var num1: Double;
    var num2: Double;

    fun ajouter (num1: Double, num2: Double) : Double {
        return num1 + num2;
    }
    fun diviser (num1: Double, num2: Double) : Double {
        return num1 / num2;
    }
    fun soustraire (num1: Double, num2: Double) : Double {
        return num1 - num2;
    }
    fun multiplier (num1: Double, num2: Double) : Double {
        return num1 * num2;
    }

    println()
    println("=== Exercise 1 | Calculator ===")
    println()

    print("Enter the 1st number : ")
    num1 = readln().toDouble()
    print("Enter the 2nd number : ")
    num2 = readln().toDouble()
    print(" Choose '+' , '-' , '/' or 'x' : ")
    var cl = readln()

    if (cl == "+") {
        var resultat = ajouter(num1, num2)
        println("Resultat = $resultat")
    }
    else if (cl == "/") {
        var resultat = diviser(num1, num2)
        println("Resultat = $resultat")
    }
    else if (cl == "-") {
        var resultat = soustraire(num1, num2)
        println("Resultat = $resultat")
    }
    else if (cl == "x") {
        var resultat = multiplier(num1, num2)
        println("Resultat = $resultat")
    }
    else {
        println("Problem! Veuillez réessayer")
    }

}

// ----------------------------------------------------------------------------

// File Ex2.kt

// Exercise 2

// Partie 1

var list = mutableListOf<String>("Abdel", "Med", "Joe", "Frank")

fun afficher () {
    println("List des Stagiaires : $list")
}

fun modifier (name: String) {
    print("Entrer le nom de Stagiaire que vous voulez Modifier : ")
    var n = readln()
    var index = list.indexOf(n)
    if (index != -1) {
        print("Entrer le nouveau Nom de Stagiaire $n : ")
        var newN = readln()
        list[index] = newN
        println("Stagiaire Modifiée avec Success !")
    } else {
        println("Nom de Statgiaire invalide !")
    }
}

fun supprimer (name: String) {
    print("Entrer le nom de Stagiaire que vous voulez Supprimer : ")
    var name = readln()
    if (name in list) {
        list.remove(name)
        println("Le Stagiaire $name Supprimé avec Success !")
    } else {
        println("Nom de Statgiaire invalide !")
    }
}

fun ajouter (name: String) {
    print("Entrer le Nom de nouveau Stagiaire que vous voulez Ajouter : ")
    var name = readln()
    list.add(name)
    println("Le Nouveau Stagiaire $name Ajouté avec Success!")
}

// Partie 2

var list_ = list.mapIndexed { index, name -> name to (index + 1) }.toMap()

fun main () {

    while (true) {

        println()
        println("=========== Gestionaire de Stagiaire ===========")
        println("Pour AFFICHER la liste des Stagiaires         [0]")
        println("Pour AFFICHER list des Stagiaires par Numeros [1]")
        println("Pour MODIFIER un Stagiaire taper              [2]")
        println("Pour SUPPRIMER un Stagiaire taper             [3]")
        println("Pour AJOUTER un Stagiaire taper               [4]")
        println()
        print("Entrer Ici ---> ")
        var choise = readln()


        when (choise) {
            "0" -> afficher()
            "1" -> println("Liste des Stagiaires par numeros $list_")
            "2" -> modifier(name = String())
            "3" -> supprimer(name = String())
            "4" -> ajouter(name = String())
            else -> println("Choix invalide !")
        }

    }
}

// ----------------------------------------------------------------------------

...
