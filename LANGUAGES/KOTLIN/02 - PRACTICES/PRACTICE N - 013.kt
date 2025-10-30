package TP6_KOTLIN_GB_2

import kotlin.collections.List

// 1- Class Spectateur
class Spectateur (var nom: String, var age: Int, var email: String)

// 2- Class Film
open class Film (var titre: String, var duree: Int, nom: String, description: String) : Genre (nom, description), Affichable {

    var spectateurs = mutableListOf<Spectateur>()
    var listeEvaluations = mutableListOf<Double>()

    fun ajouterSpectateur (spectateur: Spectateur) {
        spectateurs.add(spectateur)
    }

    override fun AfficherDetails() {
        println("Les Détails de Film '$nom'")
        println("le titre : $titre")
        println("la durée : $duree H")
        println("le description : $description")
        println()
    }

}

// 3- Interface Affichable
interface Affichable {

    fun AfficherDetails () {}

}

// 4- Class FilmAction
abstract class FilmAction (titre: String, duree: Int, var niveauViolance: Int, nom: String, description: String) : Film (titre, duree, nom, description), Affichable {

    override fun AfficherDetails() {
        println("Les Details de film d'Action :")
        println("Le Titre : $titre")
        println("La Duree : $duree H")
        println("Le niveau de Violance : $niveauViolance")
        println()
    }

}

// 5- Class Billet
abstract class Billet (var numeroBillet: String)

class BilletVIP (numeroBillet: String) : Billet (numeroBillet) {

    var avantages = mutableListOf<String>()

}

// 6- Class Genre
open class Genre (var nom: String, var description: String)

// 7- Class Evaluation
class Evaluation (var note: Int, var commentaire: String) {

    fun ajouterEvaluation ( listeEvaluations: MutableList<Double>, note: Int) {
        listeEvaluations.add(note.toDouble())
    }

    fun calculerMoyenne (listeEvaluations: MutableList<Double>): Double {
        return listeEvaluations.average()
    }

}

// 8- Extension Functions
fun MutableList<Film>.filtrerParDuree (duree: Int): List<Film> {
    return this.filter { it.duree >= duree }
}

fun Film.nbrTotalSpects (spectateur: Spectateur): Int {
    return this.spectateurs.size
}

// 9- Class Seance
class Seance (var horaire: String, var salle: Int, var film: Film) {

    var placesDisponible: Int = 200

    fun gererPlacesDispos () {
        println("Les places disponibles : $placesDisponible")
    }

    fun reserverPlace () {
        if (placesDisponible > 0) {
            placesDisponible --
            println("Place réservée ! Places restantes : $placesDisponible")
        } else {
            println("Toutes les tickets sont vendus !")
        }
    }

}

// 10- Programme Principal :

fun main () {

    // * 1
    var spectateur1 = Spectateur("Abdo", 20, "chattabdrrafie@gmail.com")
    var spectateur2 = Spectateur("Joe", 36, "joe.admin@outlook.com")
    var spectateur3 = Spectateur("Mohamed", 25, "moh.mohamed@icloud.com")

    // * 2 - 3
    var film1 = Film("Action", 2, "Moroccan Dream", "moroccan film")
    var film2 = Film("Science", 3, "Hidrogyne X", "romantic film")
    var film3 = Film("Drame", 2, "Resident Evil 4", "film inspired from a video game")

    // * 4
    var billet1 = BilletVIP("7")
    var billet2 = BilletVIP("25")

    // * 5
    film1.ajouterSpectateur(spectateur1)
    film2.ajouterSpectateur(spectateur3)
    film3.ajouterSpectateur(spectateur2)

    // * 6
    var films = mutableListOf<Film>()
    films.add(film1)
    films.add(film2)
    films.add(film3)
    for (film in films) {
        film.AfficherDetails()
    }

    // * 7
    var evaluations = mutableListOf<Double>()
    var evaluation1 = Evaluation(20, "Tres Bon")
    var evaluation2 = Evaluation(15, "Bon")

    evaluation1.ajouterEvaluation(evaluations, 20)
    println("l'évaluation '${evaluation1.note }, ${evaluation1.commentaire}' ajouté avec success")

    evaluation2.ajouterEvaluation(evaluations, 15)
    println("l'évaluation '${evaluation2.note }, ${evaluation2.commentaire}' ajouté avec success")

    var moyenne = evaluation1.calculerMoyenne(evaluations)
    println("Le Moyenne des notes : $moyenne")

    // ...

}
