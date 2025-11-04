package TP10_KOTLIN

import kotlin.concurrent.thread

// Exercice 1 :

fun main () {

    var thread = thread {

        for (i in 1..10) {
            println("Nombre : $i")
            Thread.sleep(1000)
        }
    }

    println("thread démarée ...")
    thread.join()
    println("thread Terminé !")

}

// Run

//thread démarée ...
//Nombre : 1
//Nombre : 2
//Nombre : 3
//Nombre : 4
//Nombre : 5
//Nombre : 6
//Nombre : 7
//Nombre : 8
//Nombre : 9
//Nombre : 10
//thread Terminé !


// --------------------------------------------------------------


package TP10_KOTLIN

import kotlin.concurrent.thread

// Exercice 2 :

fun main () {

    var thread = thread {

        for (i in 1..5) {
            println("Nombre : $i")
        }
    }

    println("thread demarée ...")
    thread.join()
    Thread.sleep(5000)
    thread.interrupt()
    println("thread a été arreté !")

}

// Run

//thread demarée ...
//Nombre : 1
//Nombre : 2
//Nombre : 3
//Nombre : 4
//Nombre : 5
//thread a été arreté !


// --------------------------------------------------------------


package TP10_KOTLIN

import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.random.nextLong

// Exercice 3 :

fun main () {

    var delai = Random.nextLong(500, 2000)

    var  thread1 = thread {
        for (i in 1..5) {
            println("Nombre : $i")
            Thread.sleep(delai)
        }
    }

    println("thread 1 demarée ...")
    thread1.join()
    thread1.interrupt()
    println("thread 1 Arreté !")

    var  thread2 = thread {
        for (i in 1..5) {
            println("Nombre : $i")
            Thread.sleep(delai)
        }
    }

    println("thread 2 demarée ...")
    thread2.join()
    thread2.interrupt()
    println("thread 2 Arreté !")

    var  thread3 = thread {
        for (i in 1..5) {
            println("Nombre : $i")
            Thread.sleep(delai)
        }
    }

    println("thread 3 demarée ...")
    thread3.join()
    thread3.interrupt()
    println("thread 3 Arreté !")

} 


// --------------------------------------------------------------


package TP10_KOTLIN

import java.util.concurrent.Callable
import java.util.concurrent.Executors

// Exercice 4 :

// to use Thread avec retour de vlaeur j'utilise 'Callable'.
//     - var executeur = Executors.newSingleThreadExecutor().
//     - var future = executeur.submit(threadRetourn).
//       ... 
//     - var resultat = future.get()



fun main () {

    var threadRetourn = Callable<Int> {

        Thread.sleep(3000)
        var somme = 0;
        for (i in 1..100) {
            somme += i
        }
        somme

    }

    var executeur = Executors.newSingleThreadExecutor()
    var future = executeur.submit(threadRetourn)

    println("Calcule en cours ...")
    var resultat = future.get()
    println("La somme : " + resultat)
    executeur.shutdown() // 5050

}


// --------------------------------------------------------------


package TP10_KOTLIN

import kotlin.concurrent.thread

// Exercice 5 :

fun main () {

    var counter: Int = 0
    var lock = Object()

    var thread1 = thread {
        for (i in 1..1000) {
            synchronized(lock) {
                counter++
            }
        }
        println("Compteur 1 Terminé !")

    }

    var thread2 = thread {

        for (i in 1..1000) {
            synchronized(lock) {
                counter--
            }
        }
        println("Compteur 2 Terminé !")

    }

    thread1.join()
    thread2.join()

    println(" Compteur final : $counter")


}
