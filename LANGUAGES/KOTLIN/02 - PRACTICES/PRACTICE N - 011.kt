package TP6_KOTLIN

import java.util.Objects

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
        println("-- Les infos de Personne universitaire : --")
        println("Le nom: $nom, le prénom: $prenom, la date embauche: $dateEmbauche, le numero Identification: $numeroIdentification, le type: ${getTypeMembre()}.")
    }

}

// Partie 2 --

class Professeur (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    var grade: String,
    override var numeroIdentification: String,
    var heuresCours: Int) : PersonneUniveritaire (nom, prenom, dateEmbauche), Enseignant {

    init {
        require(heuresCours < 0) { "les heures de cours doit etre positif !" }
    }

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

class Chercheur (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    var domaineRecherche: String,
    var nombrePublication: Int,
    override var numeroIdentification: String,
    ) : PersonneUniveritaire (nom, prenom, dateEmbauche), Enseignant {

    init {
        require(nombrePublication < 0) { "Le nombre de publication doit etre positif !" }
    }

    override fun calculerSalaire () : Double {
        return 2500.0 + 100 * nombrePublication
    }

    override fun enseigner (matiere: String) {}

    override fun getTypeMembre(): String {
        return "Checheur"
    }

}

class Administratif (
    nom: String,
    prenom: String,
    dateEmbauche: String,
    var poste: String,
    override var numeroIdentification: String,
    var heuresSupplementaires: Int) : PersonneUniveritaire (nom, prenom, dateEmbauche) {
    
    init {
        require(heuresSupplementaires < 0) { "Les heures supplementaires doit etre positif !" }
    }

    override fun calculerSalaire(): Double {
        return 2000.0 + 20 * heuresSupplementaires
    }

    override fun getTypeMembre(): String {
        return "Personnel Administratif"
    }

}

// Partie 3 --

fun main () {

    var membresUniversite = mutableListOf(
        Professeur("Barae", "Samadi", "2023", "Sunior", "3", 20),
        Professeur("Lara", "Quqa", "2022", "Intern", "1", 15),

        Administratif("Abderrafie", "CHATE", "2019", "Mobile Developer", "4", 35),
        Administratif("Youssef", "Chahbi", "2017", "Figma Designer", "2", 27),

        Chercheur("Taha", "El Khayat", "2011", "IT", 23, "7"),
        Chercheur("Marwan", "Alaoui", "2018", "AI", 4, "5")
    )

    for (memebre in membresUniversite) {
        memebre.afficherInfo()
        println()
        memebre.getTypeMembre()
    }

    for (membre in membresUniversite) {
        if (membre is Enseignant) {
            println("${membre.nom} ${membre.prenom} est un enseignant !")
            membre.enseigner("IT")
            membre.preparerCours()
            println()
        }
    }

    println()
    for (membre in membresUniversite) {
        var masseSalaire = membre.calculerSalaire()
        println("La masse salaire totale de ${membre.nom} ${membre.prenom} = $masseSalaire DH")
    }

    var nbrProfesseurs = 0
    var nbrChercheurs = 0
    var nbrAdministrateurs = 0
    for (membre in membresUniversite) {
        when (membre) {
            is Professeur -> nbrProfesseurs++
            is Chercheur -> nbrChercheurs++
            is Administratif -> nbrAdministrateurs++
        }
    }

    println()
    println("-- Statistique des membres Universitaire par type --")
    println("Le nombre des Professeurs : $nbrProfesseurs")
    println("Le nombre des Chercheurs : $nbrChercheurs")
    println("Le nombre des Administrateurs : $nbrAdministrateurs")

}






// Terminal : _________________________________________________________________________________________________________________
//                                                                                                                             |
// -- Les infos de Personne universitaire : --                                                                                 |
// Le nom: Barae, le prénom: Samadi, la date embauche: 2023, le numero Identification: 3, le type: Professeur.                 |
//                                                                                                                             |
// -- Les infos de Personne universitaire : --                                                                                 |
// Le nom: Lara, le prénom: Quqa, la date embauche: 2022, le numero Identification: 1, le type: Professeur.                    |
//                                                                                                                             |
// -- Les infos de Personne universitaire : --                                                                                 |
// Le nom: Abderrafie, le prénom: CHATE, la date embauche: 2019, le numero Identification: 4, le type: Personnel Administratif.|
//                                                                                                                             |
// -- Les infos de Personne universitaire : --//                                                                               |
// Le nom: Youssef, le prénom: Chahbi, la date embauche: 2017, le numero Identification: 2, le type: Personnel Administratif.  |
//                                                                                                                             |
// -- Les infos de Personne universitaire : --                                                                                 |
// Le nom: Taha, le prénom: El Khayat, la date embauche: 2011, le numero Identification: 7, le type: Checheur.                 |
//                                                                                                                             |
// -- Les infos de Personne universitaire : --                                                                                 |
// Le nom: Marwan, le prénom: Alaoui, la date embauche: 2018, le numero Identification: 5, le type: Checheur.                  |
//                                                                                                                             |
// Barae Samadi est un enseignant !                                                                                            |
// Préparation des cours en cours !                                                                                            |
//                                                                                                                             |
// Lara Quqa est un enseignant !                                                                                               |
// Préparation des cours en cours !                                                                                            |
//                                                                                                                             |
// Taha El Khayat est un enseignant !                                                                                          |
// Préparation des cours en cours !                                                                                            |
//                                                                                                                             |
// Marwan Alaoui est un enseignant !                                                                                           |
// Préparation des cours en cours !                                                                                            |
//                                                                                                                             |
//                                                                                                                             |
// La masse salaire totale de Barae Samadi = 4000.0 DH                                                                         |
// La masse salaire totale de Lara Quqa = 3750.0 DH                                                                            |
// La masse salaire totale de Abderrafie CHATE = 2700.0 DH                                                                     |
// La masse salaire totale de Youssef Chahbi = 2540.0 DH                                                                       |
// La masse salaire totale de Taha El Khayat = 4800.0 DH                                                                       |
// La masse salaire totale de Marwan Alaoui = 2900.0 DH                                                                        |
//                                                                                                                             |
// -- Statistique des membres Universitaire par type --                                                                        |
// Le nombre des Professeurs : 2                                                                                               |
// Le nombre des Chercheurs : 2                                                                                                |
// Le nombre des Administrateurs : 2                                                                                           |
// ____________________________________________________________________________________________________________________________|
