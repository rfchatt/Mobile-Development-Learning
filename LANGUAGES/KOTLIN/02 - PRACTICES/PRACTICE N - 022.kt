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


// -----------------------------------------------------------


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


// -----------------------------------------------------------


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


// -----------------------------------------------------------


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


// -----------------------------------------------------------


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


// -----------------------------------------------------------


// Exercice 6 :

fun main () {

    runBlocking {

        var job1 = launch(Dispatchers.Default) {
            println("cette thread nomée : [${Thread.currentThread().name }}] (Default).")
        }
        var job2 = launch(Dispatchers.IO) {
            println("cette thread nomée : [${Thread.currentThread().name }}] (IO).")
        }
        var job3 = launch(Dispatchers.Unconfined) {
            println("cette thread nomée : [${Thread.currentThread().name }}] (Unconfined).")
        }

        job1.join()
        job2.join()
        job3.join()

    }

}

// Run :

// cette thread nomée : [DefaultDispatcher-worker-1}] (Default).
// cette thread nomée : [DefaultDispatcher-worker-1}] (IO).
// cette thread nomée : [main}] (Unconfined).


// -----------------------------------------------------------

