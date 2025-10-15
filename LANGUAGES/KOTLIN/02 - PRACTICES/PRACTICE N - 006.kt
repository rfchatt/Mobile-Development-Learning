import kotlin.math.PI

// Exercise 1

class MaClass {

    // 1)
    var x: Int = 23;
    var y: Int = x + 5;

    fun affiche () {
        println("x : $x, y : $y")
    }
}

    // 2)
class Personne (nom: String, prenom: String, adresse: String, age: Int) {

    var _nom: String = nom
    var _prenom: String = prenom
    var _adresse: String = adresse
    var _age: Int = age

    fun setNom (nomModifier: String) {
        _nom = nomModifier;
    }
    fun setPrenom (prenomModifier: String) {
        _prenom = prenomModifier;
    }
    fun setAdresse (adresseModifier: String) {
        _adresse = adresseModifier;
    }
    fun setAge (ageModifier: Int) {
        _age = ageModifier;
    }

    fun affiche () {
        println("Le nom : $_nom, prenom : $_prenom, adresse : $_adresse, age : $_age")
    }

}

    // 3)
class Voiture (marque: String, modele: Int, couleur: String, kilometrage: Int) {

    var _marque = marque
    var _modele = modele
    var _couleur = couleur
    var _kilometrage = kilometrage

    fun setMarque (marqueModifier: String) {
        _marque = marqueModifier;
    }
    fun setModele (modeleModifier: Int) {
        _modele = modeleModifier;
    }
    fun setCouleur (couleurModifier: String) {
        _couleur = couleurModifier;
    }
    fun setKilometrage (kilometrageModifier: Int) {
        _kilometrage = kilometrageModifier;
    }

    fun affiche () {
        println("La marque : $_marque, Modele : $_modele, couleur : $_couleur, kilometrage : $_kilometrage")
    }

}

// Exercise 2

class Maison (adress: String, nbrEtage: Int, couleur: String, surface: Int) {

    var _adress = adress
    var _nbrEtage = nbrEtage
    var _couleur = couleur
    var _surface = surface

    fun setAdresse (adresseModifier: String) {
        _adress = adresseModifier
    }
    fun setEtage (etageModifier: Int) {
        _nbrEtage = etageModifier
    }
    fun setCouleur (couleurModifier: String) {
        _couleur = couleurModifier
    }
    fun setSurface (surfaceModifier: Int) {
        _surface = surfaceModifier
    }

    fun affiche () {
        println("L'Adresse : $_adress, Nbr d'étages : $_nbrEtage, Couleur : $_couleur, Surface : $_surface")
    }

}

// Exercise 3

// 1)
open class Forme (var nom: String) {

    open fun surface (): Double {
        return 0.0;
    }
    open fun perimetre (): Double {
        return 0.0;
    }
    open fun afficher_details () {
        println("Le nom : $nom, Surface : ${surface()}, Perimetre : ${perimetre()}")
    }
}
// 2) classe Carrée
class Carre (nom: String, var c: Double) : Forme (nom = nom) {
    override fun surface(): Double {
        return c * c
    }
    override fun perimetre(): Double {
        return 4 * c
    }
}
// 2) .. classe Rectangle
class Rectangle (nom: String,L: Double,l: Double) : Forme (nom = nom) {
    var _L = L
    var _l = l
    override fun surface(): Double {
        return _L * _l
    }
    override fun perimetre(): Double {
        return 2 * (_L + _l)
    }
}
// 2) .. classe Cercle
class Cercle (nom: String,r: Double) : Forme (nom = nom) {
    var _r = r
    override fun surface(): Double {
        return PI * _r * _r
    }
    override fun perimetre(): Double {
        return 2 * PI * _r
    }
}

// Exercise 4

// 1)

open class Vehicule (var marque: String, var modele: Int) {

    fun afficher_details () {
        println("La marque : $marque, Modele : $modele")
    }

    open fun se_deplacer () {
        print(" se déplacer en : ")
    }

}

class Avion1 (marque: String, modele: Int, ailes: Int, nbrRoues: Int) : Vehicule (marque = marque, modele = modele) {
    override fun se_deplacer() {
        print("$marque ")
        super.se_deplacer()
        println(" Volé.")
    }
}

class Voiture1 (marque: String, modele: Int, annee: Int, nbrRoues: Int) : Vehicule (marque = marque, modele = modele) {
    override fun se_deplacer() {
        print("$marque ")
        super.se_deplacer()
        println(" Roulé.")
    }
}

class Velo1 (marque: String, modele: Int, nbrRoues: Int) : Vehicule (marque = marque, modele = modele) {
    override fun se_deplacer() {
        print("$marque ")
        super.se_deplacer()
        println(" Roulé.")
    }
}


// -------------------------------


fun main () {

    var maclasse = MaClass()
    maclasse.affiche()

    println()   // Exercise 1

    var personne = Personne("Chate", "Abderrafie", "Tanger", 20)
    personne.affiche()
    personne.setNom("Chatt")
    personne.setPrenom("Abdo")
    personne.setAdresse("Gzenaya")
    personne.setAge(30)
    personne.affiche()

    println()

    var voiture = Voiture("Dacia Logan", 2019, "Noir", 89000)
    voiture.affiche()
    voiture.setMarque("Dacia Sandero")
    voiture.setModele(2023)
    voiture.setCouleur("Bleu")
    voiture.setKilometrage(44000)
    voiture.affiche()

    println()  // Exercise 2

    var maison = Maison("Boulvard", 1, "Blanch", 100)
    maison.affiche()
    maison.setAdresse("Rmillat")
    maison.setEtage(2)
    maison.setCouleur("Blanch")
    maison.setSurface(300)
    maison.affiche()

    println()  // Exercise 3

    var forme = Forme("Forme")
    forme.afficher_details()
    var rectangle = Rectangle("Rectangle", 30.0, 25.3)
    rectangle.afficher_details()
    var cercle = Cercle("Cercle", 9.0)
    cercle.afficher_details()

    println()  // Exercise 4

    var avion1 = Avion1("Boieng", 2018, 4, 7)
    avion1.afficher_details()
    avion1.se_deplacer()
    println()
    var voiture1 = Voiture1("Dacia", 2020, 2025, 4)
    voiture1.afficher_details()
    voiture1.se_deplacer()
    println()
    var velo = Velo1("Decathelon", 2025, 2)
    velo.afficher_details()
    velo.se_deplacer()
    println()
    var avions = listOf(
        Avion1("Boeing VC-25", 2001, 5, 7),
        Avion1("F-16", 2022, 5, 4),
        Avion1("F-35", 2024, 6, 3)
    )
    var voitures = listOf(
        Voiture1("Volswagen Golf 7.5 R", 2018, 2025, 4),
        Voiture1("Opel Corsa", 2023, 2025, 4),
        Voiture1("Mercedes Class A", 2015, 2024, 4)
    )
    var velos = listOf(
        Velo1("Decathelon S-1", 2020, 2024),
        Velo1("Sania", 2021, 2),
        Velo1("Honda N-Max", 2025, 2)
    )
    for (e in avions) {
        println(e.afficher_details())
        println(e.se_deplacer())
        println()
    }
    for (e in voitures) {
        println(e.afficher_details())
        println(e.se_deplacer())
        println()
    }
    for (e in velos) {
        println(e.afficher_details())
        println(e.se_deplacer())
        println()
    }

}
