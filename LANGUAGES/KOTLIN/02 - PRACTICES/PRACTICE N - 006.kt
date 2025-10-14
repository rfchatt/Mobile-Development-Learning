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

    var _marque: String = marque
    var _modele: Int = modele
    var _couleur: String = couleur
    var _kilometrage: Int = kilometrage

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



// -------------------------------

fun main () {

    println("== Exercise 1 ==")

    var maclasse = MaClass()
    maclasse.affiche()

    var personne = Personne("Chate", "Abderrafie", "Tanger", 20)
    personne.affiche()

    var voiture = Voiture("Dacia", 2020, "Noir", 123000)
    voiture.affiche()

}
