package TP5_KOTLIN

// Exercise 1 ---

interface Vehicule {

    fun start ()
    fun stop ()

}

class Car () : Vehicule {

    override fun start() {
         println("the Car is Start !")
    }

    override fun stop() {
        println("the Car is stop !")
    }

}

class Bike () : Vehicule {

    override fun start() {
        println("the Bike is Start !")
    }

    override fun stop() {
        println("the Bike is Stop !")
    }

}

fun main () {

    var c = Car()
    c.start()
    c.stop()

    println()

    var b = Bike()
    b.start()
    b.stop()

}

// ------------------------------------------------------

package TP5_KOTLIN

// Exercise 2

interface Animal {

    var name: String
    fun makeSound ()

}

class Dog (override var name: String) : Animal {

    override fun makeSound() {
         println("The dog is barking !")
    }

}

class Cat (override var name: String ) : Animal {

    override fun makeSound() {
        println("The cat meows !")
    }
}

fun main () {

    var d = Dog("Charlie")
    d.makeSound()

    println()
    var c = Cat("Noni")
    c.makeSound()

}

// ------------------------------------------------------

package TP5_KOTLIN

// Exercise 3

// 1- interface Animal
interface AnimaL {

    var nom: String
    fun parler ()

    // 2- méthode seDéplacer()
    fun seDeplacer () {
        println("l'Animal $nom se déplacer")
    }

}

// 3- interface Volant
interface Volant {

    fun voler ()

}

// 4- class Oiseau
class Oiseau (override var nom: String) : AnimaL, Volant {

    override fun parler() {
        println("l'oiseau chante !")
    }

    override fun seDeplacer() {
        super.seDeplacer()
    }

    override fun voler() {
        println("L'oiseau voler")
    }

}

// 5- class Chien
class Chien (override var nom: String) : AnimaL {

    override fun parler() {
         println("Le chien aboie !")
    }

    override fun seDeplacer() {
        println("Le chien se déplacer")
    }

}

// class Poisson
class Poisson (override var nom: String) : AnimaL {

    override fun seDeplacer() {
         super.seDeplacer()
    }

    override fun parler() {

    }

}


// L'execution
fun main () {

    var o = Oiseau("koki")
    o.parler()
    o.seDeplacer()
    o.voler()

    println()
    var c = Chien("Rock")
    c.parler()
    c.seDeplacer()

    println()
    var p = Poisson("tuna")
    p.seDeplacer()
    p.parler()

}

