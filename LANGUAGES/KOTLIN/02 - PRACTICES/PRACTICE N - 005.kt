// TP 1

fun main() {
  
    // Exercise 1 :

    // 1)
    val nom: String? = "Abderrafie";
    var estEtudiant: Boolean? = true;
    var age: Int? = 20;
    var taille: Double? = 1.75;
    val notes = listOf(15.0, 17.0, 19.75, 20.0, 20.0)

    // 2)
    println("-- Exercise 1 --")
    println("Le nom : $nom")
    println("Est Étudiant : $estEtudiant")
    println("L'Age : $age")
    println("La Taille : $taille m")
    println("Les notes : $notes")

    // 3)
    val moyenne: Double = notes.average()
    val maxNote: Double = notes.max()
    val minNote: Double = notes.min()
    println("Le moyenne : $moyenne")
    println("Max note : $maxNote")
    println("Min Note : $minNote")
    if (moyenne >= 10.0) {
        println("réussir")
    } else {
        println("répéter")
    }

    // --------------------------------

    // Exercise 2 :
    // 1)
    fun evaluerNote (note: Int) : String {
        return when (note) {
            in 0..9 -> "Echec"
            10, 11 -> "Passable"
            12, 13 -> "Assez Bien"
            14, 15 -> "Bien"
            in 16..20 -> "Tres Bien"
            else -> "Note invalide"
        }
    }

    // 2)
    fun calculerMoyenne (notes: List<Int>) : Double {
        if (notes.isEmpty()) {
            return 0.0;
        }
        return notes.average()
    }

    // 3)
    fun afficherResultats (notes: List<Int>) {
        if (notes.isEmpty()) {
            println("Aucune note a afficher")
            return
        }
        for (note in notes) {
            println("La note : $note, Evaluation : ${evaluerNote(note)}")
        }
    }

    println("-- Exercise 2-- ")
    val notesT = listOf(8, 13, 15, 17, 20, -3)
    println("L'Évaluation des notes: ")
    notesT.forEach { note ->
        println("Note : $note, Evaluation : ${evaluerNote(note)}")
    }
    println("Affichage de resultats :")
    afficherResultats(notesT)
    afficherResultats(listOf())
    println("Moyenne : ${calculerMoyenne(listOf())}")

    // ----------------------------------

    // Exercise 3

    println("-- Exercise 3 --")
    // 1)
    val livres = listOf("Politics Lows", "Science Of Community Ep 1", "A-Z", "Be A Man", "Self Development", "Arabs Culture", "Art Of Silence", "Do it now", "Casa", "African Guy")
    println("List : ${livres}")

    // 2)
    fun rechercherLivres(livres: List<String>, motCle: String): Boolean {
        return motCle in livres
    }
    println("Mot Clé Exists in List ? : ${rechercherLivres(livres, "Be A Man")}")

    // 3)
    var lengthMax : Int = 0;
    var lengthMin : Int = 100;
    var nombreTotal : Int = livres.size
    fun statistiquesLivres () {
        for (livre in livres) {
            if (lengthMax < livre.length) {
                lengthMax = livre.length
            }
            if (lengthMin > livre.length) {
                lengthMin = livre.length
            }
        }
        println("Livre le plus Long : $lengthMax")
        println("Livre le plus court : $lengthMin")
        println("nombre Total des Livres : $nombreTotal")
    }
    println(statistiquesLivres())

    // 4)
    var court = mutableListOf<String>();
    var moyen = mutableListOf<String>();
    var long = mutableListOf<String>();
    fun livresParLongueur () {
        for (livre in livres) {
            if (livre.length < 15) {
                court.add(livre)
            }
            if (livre.length >= 15 && livre.length <= 20) {
                moyen.add(livre)
            }
            if (livre.length > 20) {
                long.add(livre)
            }
        }
    }
    livresParLongueur()
    println("Libres court (<15 car) : $court")
    println("Libres moyen (>= 15 et <= 20 car) : $moyen")
    println("Libres court (>20 car) : $long")

}

