package TP4_KOTLIN

// Exercise 1 ---

// class abstraite Form
abstract class Forme (var couleur: String) {

    abstract fun afficherInfo ();

}

// sous-class Cercle 
class Cercle (couleur: String, var rayon: Int) : Forme (couleur = couleur) {

    override fun afficherInfo() {
        println("Le couleur de cercle : $couleur, et le Rayon : $rayon")
    }
}

// sous-class Rectangle
class Rectangle (couleur: String, var largeur: Int, var hauteur: Int) : Forme (couleur = couleur) {


    override fun afficherInfo() {
         println("Le couleur de Rectangle : $couleur, largeur : $largeur et l'hauteur : $hauteur")
    }
}


// l'Execution
fun main () {

    var c = Cercle("Bleu", 5)
    c.afficherInfo()
    println()

    var r = Rectangle("Orange", 30, 25)
    r.afficherInfo()

}

// ----------------------------------------------------------------------

package TP4_KOTLIN

// Exercise 2 ---

abstract class Personne (var nom: String, var age: Int) {

    abstract fun afficherDetails ();

}

class Eleve (nom: String, age: Int, var niveau: String) : Personne (nom = nom, age = age) {

    override fun afficherDetails() {
         println("Le nom d'éléve : $nom, l'áge : $age et le niveau : $niveau")
    }

}

class Employe (nom: String, age: Int, var poste: String) : Personne (nom = nom, age = age) {

    override fun afficherDetails() {
         println("Le nom de l'emploiyé : $nom, l'áge : $age, et le poste : $poste")
    }

}


// l'Execution
fun main () {

    println()
    var e1 = Eleve("Abderrafie", 20, "TS")
    var e2 = Eleve("Anass", 18, "Bac")
    e1.afficherDetails()
    e2.afficherDetails()

    println()
    var em1 = Employe("Oussama", 27, "Ingénieur")
    var em2 = Employe("Yassin", 25, "Technicien électricité")
    em1.afficherDetails()
    em2.afficherDetails()

}

// ----------------------------------------------------------------------

package TP4_KOTLIN

// Exercise 3 ---

abstract class Vehicule (var marque: String) {

    init {
        println("Création de l'objet '$marque' effectué avec succès !")
    }

    abstract fun afficherInfo ();

}

class Voiture (marque: String, var nombrePortes: Int) : Vehicule (marque = marque) {

    override fun afficherInfo() {
        println("La marque de Voiture : $marque, et le nombre des portes : $nombrePortes")
    }

}

class Camion (marque: String, var capaciteCharge: Int) : Vehicule (marque = marque) {

    override fun afficherInfo() {
        println("La marque de Camion : $marque, et la capacite de charge : $capaciteCharge Kg")
    }

}


// L'execution
fun main () {

    println()
    var v1 = Voiture("Mercedes", 5)
    var v2 = Voiture("Renault", 6)
    v1.afficherInfo()
    v2.afficherInfo()

    println()
    var c1 = Camion("Volvo", 1000)
    var c2 = Camion("Mercedes", 1200)
    c1.afficherInfo()
    c2.afficherInfo()

}

// ----------------------------------------------------------------------


package TP4_KOTLIN

// Exercise 4 ---

abstract class Appareil (var marque: String, var allume: Boolean = false) {

    abstract val typeAppareil: String

    fun allumer() {
        allume = true
        println("L'appareil est allumé !")
    }

    init {
        println("L'appareil '$marque' créer avec succéss !") 
    }

}

class Telephone (marque: String, allume: Boolean = false, var numeroDeTelephone: String) : Appareil (marque = marque, allume = allume) {

    override val typeAppareil: String = "Téléphone"

    init {
        println("l'objet '$marque' de Telephone créer avec succéss !")
    }

}

class Ordinateur (marque: String, allume: Boolean = false, var systemDexploitation: String) : Appareil (marque = marque, allume = allume) {

    override val typeAppareil: String = "Ordinateur"

    init {
        println("l'objet '$marque' d'Ordinateur créer avec succéss !")
    }

}



// L'execution
fun main () {

    val appareils = mutableListOf<Appareil>();

    println()
    var t1 = Telephone("Samsung", true, "0607078589")
    appareils.add(t1)
    println("La marque: ${t1.marque},le type: ${t1.typeAppareil}, Allumé : ${t1.allume}, numero de téléphone: ${t1.numeroDeTelephone}")
    t1.allumer()

    println()
    var t2 = Telephone("Iphone", false, "0606060606")
    appareils.add(t2)
    println("La marque: ${t2.marque},le type: ${t2.typeAppareil}, Allumé : ${t2.allume}, numero de téléphone: ${t2.numeroDeTelephone}")

    println()
    var o1 = Ordinateur("hp", true, "Windows")
    appareils.add(o1)
    println("La marque: ${o1.marque},le type: ${o1.typeAppareil}, Allumé : ${o1.allume}, Systeme d'Exploitation: ${o1.systemDexploitation}")
    o1.allumer()

    println()
    var o2 = Ordinateur("Macbook", false, "macOs")
    appareils.add(o2)
    println("La marque: ${o2.marque},le type: ${o2.typeAppareil}, Allumé : ${o2.allume}, Systeme d'Exploitation: ${o2.systemDexploitation}")

    println()
    // comparaison des marques des téléphones
    var tel1 = t1.marque.lowercase()
    var tel2 = t2.marque.lowercase()

    println()
    if (tel1 == tel2) {
        println("Les Marques ${t1.marque} et ${t2.marque} sont identiques !")
    } else {
        println("Les Marques ${t1.marque} et ${t2.marque} ne sont pas identiques !")
    }

    // modification de numeroDeTelephone
    println()
    t1.numeroDeTelephone = "0772282545"
    println("Le nouveau numero de téléphone : ${t1.numeroDeTelephone}")

    // modification de systemDexploitation
    println()
    o1.systemDexploitation = "Linux"
    println("le nouveau Systeme d'Exploitation : ${o1.systemDexploitation}")



    // compter appareils allumes
    var appareilAllume = appareils.count {it.allume}
    println()
    println("Le nombre des Appareils allumés : $appareilAllume")

}
