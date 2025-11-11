package TP13_KOTLIN

// Exercice 1 : -- callback simple

fun direBojour (callback: () -> Unit) {

    println("Bonjour 😊!")
    callback() // l'appel de callback ❕

}

fun main () {

    direBojour {
        println("le callback été executé .")
    }

}

// Run :

// Bonjour 😊!
// le callback été executé .


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 2 : -- callback avec paramétre

fun afficherMessage (message: String, callback: (String) -> Unit) {
    
    callback(message.uppercase())

}

fun main () {

    var message = "You can do it 👍!"

    afficherMessage (message) { msg ->
        println(msg)
        println("callback a été exécuté.")
    }

}

// Run :

// YOU CAN DO IT 👍!
// callback a été avec success.


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 3 : -- callback simulant un téléchargement

fun telechargerFichier (nom: String, callback: (String, Double) -> Unit) {

    Thread {
        Thread.sleep(3000)
        var taille = 87.9
        callback(nom, taille)
    }.start()

}


fun main () {

    var fileName = "TP-13.pdf"

    println("Téléchargement démarée ...")

    telechargerFichier(fileName) { nom_fichier, taille_fichier ->
        println("Le fichier [$nom_fichier] de $taille_fichier ko est téléchargé !")
    }

}

// Run :

// Téléchargement démarée ... (3 seconds)
// Le fichier [TP-13.pdf] de 87.9 ko est téléchargé !


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 4 : -- callback dans une liste

fun traiterfichiers (files: List<String>, callback: (String) -> Unit) {

    for (file in files) {
        callback(file)
    }
//    callback(files)

}

fun main () {

    var listeFiles = mutableListOf<String>("doc1.pdf", "image1.png", "video1.mp4")

    traiterfichiers(listeFiles) { fileName ->
        println("Traitement du fichier [$fileName]")
    }

}

// Run :

// Traitement du fichier [doc1.pdf]
// Traitement du fichier [image1.png]
// Traitement du fichier [video1.mp4]


// -----------------------------------------------------------


package TP13_KOTLIN

//Exercice 5 : -- callback avec condition

fun verifierTaille (nom: String, taille: Double, callback: (String, Double) -> Unit) {

    callback(nom, taille)

}

fun main () {

    var fichier1 = "EFM-REGIONAL.pdf"
    var taille1 = 380.0

    verifierTaille(fichier1, taille1) { fileName, fileTaille ->
        if (fileTaille < 300.0) {
            println("Le fichier [$fileName] est OK !")
        } else {
            println("Le fichier [$fileName] est trop lourd !")
        }
    }

    var fichier2 = "CC3-KOTLIN.pdf"
    var taille2 = 170.0

    verifierTaille(fichier2, taille2) { fileName, fileTaille ->
        if (fileTaille < 300.0) {
            println("Le fichier [$fileName] est OK !")
        } else {
            println("Le fichier [$fileName] est trop lourd !")
        }
    }

}


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 6 : -- Téléchargement paralléles simulés

fun telechargerFichierAsync (nom: String, callback: (String) -> Unit) {

    Thread {
        Thread.sleep(3000)
        callback(nom)
    }.start()

}

fun main () {

    var files = mutableListOf<String>("image-whatsApp.png", "cours-callbacks.pdf", "cv.pdf")

    println("Téléchargement en cours ...")

    for (file in files) {
        telechargerFichierAsync(file) { nm ->
            println("Le fichier [$nm] a été télécharger.")
        }
    }


}


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 7 : -- callback qui modifie une variable

fun incrementer (entier: Int, callback: (Int) -> Unit) {

    var n_incrementee = entier + 1
    callback(n_incrementee)

}

fun main () {

    var n = 7
    var resultat = 0

    println("Avant : n = $n, resultat : $resultat")

    incrementer(n) { n_incrementee ->
        resultat = n_incrementee
    }

    println("Aprés : n = $n, resultat : $resultat")

}

// Run :

// Avant : n = 7, resultat : 0
// Aprés : n = 7, resultat : 8


// -----------------------------------------------------------


package TP13_KOTLIN

// Exercice 8 : -- callback avec plusieurs paramétres et calcul

fun calculerStatistique (entiers: List<Int>, callback: (Int, Int, Double) -> Unit) {

    callback(entiers.min(), entiers.max(), entiers.average())

}

fun main () {

    var nombres = mutableListOf<Int>(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

    calculerStatistique(nombres) { min, max, moyenne ->
        println("Le Minimum des nombres = $min")
        println("Le Maximum des nombres = $max")
        println("Le Moyenne des nombres = $moyenne")
    }

}

// Run :

// Le Minimum des nombres = 10
// Le Maximum des nombres = 100
// Le Moyenne des nombres = 55.0


// Thanks for your reading to my code ;) 
