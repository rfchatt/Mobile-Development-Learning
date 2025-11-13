// TP 12 KOTLIN - COROUTINES

// Exercice 1 : 

import kotlinx.coroutines.*

fun main() {

   GlobalScope.launch {

       println("Bonjour depuis une coroutine !")

       delay(500)
       println("coroutine a terminé.")
   }

   println("Programme principal")

   Thread.sleep(1000)

   println("Fin du programme principal")
}

// Exercice 2 :

import kotlinx.coroutines.*

fun main () {

   GlobalScope.launch {
       println("Démarrage")
       delay(2000)
       println("Fin de la coroutine")
   }

   Thread.sleep(3000)

}

// Exercice 3 :

import kotlinx.coroutines.*

fun main () {

   GlobalScope.launch {
       delay(1000)
       println("Tache 1 Terminée")
   }

   GlobalScope.launch {
       delay(2000)
       println("Tache 2 Terminée")
   }

   GlobalScope.launch {
       delay(3000)
       println("Tache 3 Terminée")
   }

   Thread.sleep(4000)

}

// Exercice 4 :

import kotlinx.coroutines.*

fun main () = runBlocking {

   var job = launch {
       for (i in 1..5) {
           println("Nombre : $i")
           delay(500)
       }
   }
   job.join()

}

// Exercice 5 :

import kotlinx.coroutines.*

fun main () = runBlocking {

    var somme = 0

    var job = launch {

        for (i in 1..5) {
            somme += i
        }
        delay(1000)
        println("La somme des nombres : $somme")

    }

    job.join()

}

