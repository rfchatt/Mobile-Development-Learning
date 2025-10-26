package TP6_KT_GLOBAL

import java.time.LocalDate

// TP 6 - KOTLIN - OOP - TP GLOBAL

// 1- Class Personne --
class Personne (nom: String, age: Int, email: String) {

    var nom: String = nom
        get () = field
        set (n) {
            require(n.isNotBlank() || n.length < 2) { "Le nom doit être égal ou supérieur à deux lettres !" }
            field = n
        }

    var age: Int = age
        get () = field
        set (a) {
            require(a > 0) { "L'age doit être positif !" }
            field = a
        }

    var email: String = email
        get () = field
        set (e) {
            require(e.isNotBlank()) { "l'email ne doit par être vide !" }
            e.trim().lowercase()
            field = e
        }

    init {
        this.nom = nom
        this.age = age
        this.email = email
    }

}

// 2- Class Evenement --
open class Evenement (titre: String, date: String, lieu: String, var categorie: Categorie) {

    var participants = mutableListOf<Personne>()

    var notes = mutableListOf<Note>()

    var titre: String = titre
        get () = field
        set (t) {
            require(t.isNotBlank() || t.length < 2) { "Le titre doit être égal ou supérieur à deux lettres !" }
            field = t
        }

    var date: String = date
        get () = field
        set (d) {
            require(d > LocalDate.now().toString() || d < "1969") { "La date doit être correcte !" }
            field = d
        }

    var lieu: String = lieu
        get () = field
        set (l) {
            require(l.isNotBlank() || l.length < 2) { "Le lieu doit être égal ou supérieur à deux lettres !" }
            field = l
        }

    init {
        this.titre = titre
        this.date = date
        this.lieu = lieu
    }

    fun ajouterParticipant (participant: Personne) {
        participants.add(participant)
    }

    // 7- Systeme de Notation --
    fun ajouterNote (valeur: Int, commentaire: String) {
        var note = Note(valeur, commentaire)
        notes.add(note)
    } // ..
    fun calclerMoyenne () : Double {
        var somme = notes.sumOf { it.valeur }
        return (somme / notes.size).toDouble()
    }


}

// 3- Interface Affichable --
interface Affichable {

    fun afficherDetails ()

}

// 4- Class EvenementSportif --
class EvenementSportif (titre: String, date: String, lieu: String, var typeSport: String, categorie: Categorie) : Evenement (titre, date, lieu, categorie), Affichable {

    override fun afficherDetails() {
        println()
        println("== Affichage des Evenement Sportif ==")
        println("Le titre : $titre")
        println("La date : $date")
        println("Le lieu : $lieu")
        println("Le type de Sport : $typeSport")
        println("Catégorie : ${categorie.nom}")
    }

}

// 5- Class Abstraite Participant --
abstract class Participant (var numeroIdentification: String) {

}
class ParticipantVIP (numeroIdentification: String, var niveauVIP: Int) : Participant (numeroIdentification) {

}

// 6- Gestion des Catégories --
open class Categorie (nom: String, description: String) {

    var nom = nom
        get () = field
        set (n) {
            require(n.isNotBlank() || n.length < 2) { "Le nom doit être égal ou supérieur à deux lettres ! " }
            field = n
        }

    var description = description
        get () = field
        set (d) {
            require(d.isNotBlank() || d.length < 10) { "Le description doit être égal ou supérieur à 10 lettres ! " }
            field = d
        }

    init {
        this.nom = nom
        this.description = description
    }

}

// 7- Systéme de Notation --
class Note ( valeur: Int, commentaire: String) {

    var valeur = valeur
        get () = field
        set (v) {
            require((v in 0..20)) { "La valeur doit étre entre 0 et 20" }
            field = v
        }

    var commentaire = commentaire
        get () = field
        set (c) {
            require(c.isNotBlank() || c.length < 5) { "Le commentaire doit être égal ou supérieur à 5 lettres ! " }
            field = c
        }

    init {
        this.valeur = valeur
        this.commentaire = commentaire
    }

}

// 8- Fonction d'extension
fun MutableList<Personne>.filtrerAges(age: Int): List<Personne> {
    return this.filter { it.age == age }
}

fun Evenement.nbrTtParticipants( participant: Participant): Int {
    return this.participants.size
}

// 9- Class Calendrier
class Calendrier {

    var evenements = mutableListOf<Evenement>()

    fun ajouterEvenement (nvEve: Evenement) {
        evenements.add(nvEve)
    }

    fun listerTtEvenements () {
        println("== l'affichage de tout les événements ==")
        println(evenements)
    }

}

// Programme Principale
fun main () {

    var p1 = Personne("Abderrafie", 20, "chattabdrrafie@gmail.com")
    var p2 = Personne("Ahmed", 35, "ahmedtangerois@gmail.com")
    var p3 = Personne("Rachid", 56, "taoussirachid@gmail.com")

    var ev1 = Evenement("Haccathon", "2026-01-01", "Techno Park-Tanger", Categorie("Haccathon", "événement pour les devs"))
    var ev2 = Evenement("coocking Evenement", "2025-12-25", "Space El Fena-Marrakesh", Categorie("Coocking", "événement pour les Chefs"))

    var evSp1 = EvenementSportif("World Cup", "2026-07-21", "America", "football", Categorie("World Cup", "Final Match"))
    var evSp2 = EvenementSportif("Chess Final", "2025-11-11", "Canada", "Chess", Categorie("Chess Final", "Magnuss VS Rfchatt"))

    ev1.ajouterParticipant(p1)
    ev2.ajouterParticipant(p2)
    evSp1.ajouterParticipant(p3)
    evSp2.ajouterParticipant(p1)

    ev1.ajouterNote(18, "Tres Populaire")
    ev2.ajouterNote(15, "Populaire")
    evSp1.ajouterNote(20, "Tres Connus et populaire")
    evSp2.ajouterNote(17, "Tres Connus")

    var personnes = mutableListOf<Personne>()
    personnes.filtrerAges(20)



    println("=== L'affichage de Programme Principal ===")
    println()

    var evs = mutableListOf<Evenement>()
    evs.add(ev1)
    evs.add(ev2)

    for (ev in evs) {
        println("Le Titre : ${ev.titre}")
        println("La Date : ${ev.date}")
        println("Le Lieu : ${ev.lieu}")
        println("Le Description : ${ev.categorie.description}")
        println()
    }

    println(evSp1.afficherDetails())
    println(evSp2.afficherDetails())

}

