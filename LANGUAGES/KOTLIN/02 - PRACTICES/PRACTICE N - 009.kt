package TP4_KOTLIN

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
    println("La marque: ${t1.marque},le type: ${t1.typeAppareil}, Allumé (true/false): ${t1.allume}, numero de téléphone: ${t1.numeroDeTelephone}")
    t1.allumer()

    println()
    var t2 = Telephone("Iphone", false, "0606060606")
    println("La marque: ${t2.marque},le type: ${t2.typeAppareil}, Allumé (true/false): ${t2.allume}, numero de téléphone: ${t2.numeroDeTelephone}")
    t2.allumer()

    println()
    var o1 = Ordinateur("hp", true, "Windows")
    println("La marque: ${o1.marque},le type: ${o1.typeAppareil}, Allumé (true/false): ${o1.allume}, Systeme d'Exploitation: ${o1.systemDexploitation}")
    o1.allumer()

    println()
    var o2 = Ordinateur("Macbook", false, "macOs")
    println("La marque: ${o2.marque},le type: ${o2.typeAppareil}, Allumé (true/false): ${o2.allume}, Systeme d'Exploitation: ${o2.systemDexploitation}")
    o2.allumer()

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
    println("Le nombre des Appareils allumés : $appareilAllume")

}
