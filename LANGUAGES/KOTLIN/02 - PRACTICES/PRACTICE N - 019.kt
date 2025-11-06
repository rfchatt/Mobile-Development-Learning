package CC2_KOTLIN

// Préparation pour le CC2 de KOTLIN

// Partie 1 : Classes Avancées

// 1 : (4 pts) -- ENUM class
enum class Jours () {
    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE;
}

fun daysOfWork (jour: Jours) {

    when (jour) {
        Jours.LUNDI, Jours.MARDI, Jours.MERCREDI, Jours.JEUDI, Jours.VENDREDI -> println("c'est le Jour de Travail ..")
        Jours.SAMEDI, Jours.DIMANCHE -> println("c'est le Week-End 🎉!")
    }

}

// -----

// 2 : (4 pts) -- DATA class
data class Product (var nom: String, var prix: Double, var category: String) {}

fun afficherDetails (product: Product) {
    println("Produit : [${product.nom}]")
    println("Prix : ${product.prix} DH")
    println("Category : ${product.category}")
}

// -----

// 3 : (4 pts) -- SEALED class
sealed class Gender (var nom: String) {

    class Man (nom: String) : Gender (nom)
    class Woman (nom: String) : Gender (nom)

}
fun selectGender (gender: Gender) {
    when (gender) {
        is Gender.Man -> println("${gender.nom} est un Homme !")
        is Gender.Woman -> println("${gender.nom} est une Femme !")
    }
}
// SEALED class : est une type des class qui fermé lors qu'ont parle de l'Héritage..
// c'est a dire, nous selectionnons et contrôlons les sous-classes qui sont hérite de la 'sealed' class

// -----

// 4 : (4 pts) -- NESTED class vs INNER class

// Class imbriquée (Nested)
class UE () {
    var capital: String = "Brussels"
    class UK () {
        fun afficher () {
            println("UK is not a part of UE, and can't access to 'capital' .")
        }
    }
}

// Class Interne (Inner)
class Country () {
    var nomC: String = "Morocco"
    inner class City () {
        var nomc = "Tangier"
        fun afficher () {
            println("$nomc a city in $nomC ")
        }
    }
}

// La difference entre une classe imbriquée (Nested) et une classe Interne (Inner) c'est que..
// la 1er n'a pas l'access aux attributes de class Mére, et la 2eme a une access aux attributes
// par le mot clé inner !

// -----

// 5 : (4 pts) -- SEALED class
sealed class Forme () {

    class Cercle () : Forme () {
        fun afficher () {
            println("Cercle !")
        }
    }
    class Carre () : Forme () {
        fun afficher () {
            println("Carrée !")
        }
    }
    class Rectangle () : Forme () {
        fun afficher () {
            println("Rectangle !")
        }
    }

}

// -----

fun main () {

    // 1 :
    daysOfWork(Jours.VENDREDI) // c'est le Jour de Travail ..

    // 2 :
    var product1 = Product("Lait", 4.0, "Bio")
    afficherDetails(product1)

    // 3 :
    selectGender(Gender.Man("Abderrafie"))

    // 4 :
    UE.UK().afficher()
    Country().City().afficher()

    // 5 :
    Forme.Cercle().afficher()
    Forme.Carre().afficher()
    Forme.Rectangle().afficher()

}

