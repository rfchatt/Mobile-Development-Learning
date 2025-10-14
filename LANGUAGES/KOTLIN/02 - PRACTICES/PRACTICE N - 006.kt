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


// -------------------------------

fun main () {

    var maclasse = MaClass()
    maclasse.affiche()

    println()

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

    println()

    var maison = Maison("Boulvard", 1, "Blanch", 100)
    maison.affiche()
    maison.setAdresse("Rmillat")
    maison.setEtage(2)
    maison.setCouleur("Blanch")
    maison.setSurface(300)
    maison.affiche()

}
