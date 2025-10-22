package TP6_KOTLIN

// TP 6

// Partie 1 --

interface MembreUniversite {

    var numeroIdentification: String
    fun afficherInfo ()
    fun getTypeMembre () : String {
        return "Membre Université"
    }

}

interface Enseignant {

    fun enseigner (matiere: String)

    val matiersEnseinees: List<String>
        get() = listOf("Mathématiques", "Informatique", "Physique")

    fun preparerCours () {
        println("Préparation des cours en cours !")
    }

}

abstract class PersonneUniveritaire (var nom: String, var prenom: String, var dateEmbauche: String) : MembreUniversite {

    abstract fun calculerSalaire () : Double

    override fun afficherInfo () {
        println("-- Les infos de Personne universitaire --")
        println("Le nom $nom, prénom $prenom, et date embauche $dateEmbauche, numero Identification $numeroIdentification, type: ${getTypeMembre()}")
    }

}

// Partie 2 --

class Professeur (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    override var numeroIdentification: String,
    var grade: String,
    var heuresCours: Int) : PersonneUniveritaire (nom, prenom, dateEmbauche), Enseignant {

    override fun calculerSalaire () : Double {
        return 3000.0 + 50 * heuresCours
    }

    override fun enseigner (matiere: String) {
        var matiersEnseineesV1 = matiersEnseinees.toMutableList()
        matiersEnseineesV1.add(matiere)
    }

    override fun getTypeMembre(): String {
        return "Professeur"
    }

}

abstract class Checheur (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    var domaineRecherche: String,
    var nombrePublication: Int,

    ) : PersonneUniveritaire (nom, prenom, dateEmbauche), Enseignant {

    override fun calculerSalaire () : Double {
        return 2500.0 + 100 * nombrePublication
    }

    override fun enseigner (matiere: String) {}

    override fun getTypeMembre(): String {
        return "Checheur"
    }

}

abstract class Administratif (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    var poste: String,
    var heuresSupplementaires: Int) : PersonneUniveritaire (nom, prenom, dateEmbauche) {

    override fun calculerSalaire(): Double {
        return 2000.0 + 20 * heuresSupplementaires
    }

    override fun getTypeMembre(): String {
        return "Personnel Administratif"
    }

}

