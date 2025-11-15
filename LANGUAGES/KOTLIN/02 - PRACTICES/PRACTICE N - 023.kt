// TP 15 KOTLIN - COROUINES

// ------------------------------------------------------------------------------

// Exercice 1 :

package TP15_KOTLIN

import kotlinx.coroutines.*

fun main() {

    // GlobalScope :
    GlobalScope.launch {
        println("Nom de Coroutine 1 : ${Thread.currentThread().name}")
        delay(500)
        println("Fin de Coroutine 1 !")
    }

    // CoroutineScope :
    val job = CoroutineScope(Dispatchers.Default)
    job.launch {
        println("Nom de Coroutine 2 : ${Thread.currentThread().name}")
        delay(1000)
        println("Fin de Coroutine 2 !")
    }

    // runBlocking :
    runBlocking {
        println("Nom de Coroutine 3 : ${Thread.currentThread().name}")
        delay(2000)
        println("Fin de runBlocking !")
    }

    Thread.sleep(2500)

}

// Run : 

// Nom de Coroutine 1 : DefaultDispatcher-worker-1
// Nom de Coroutine 2 : DefaultDispatcher-worker-2
// Nom de Coroutine 3 : main
// Fin de Coroutine 1 !
// Fin de Coroutine 2 !
// Fin de runBlocking !


// ------------------------------------------------------------------------------


package TP13_KOTLIN

import kotlinx.coroutines.*

// Exercice 2 :

fun main () = runBlocking {

    var fichier = "Course_1.pdf"
    var num1 = 7
    var num2 = 9

    println("=== Début du Programme ===")

    var telecharger = launch(Dispatchers.IO) {
        println("Le fichier [$fichier] en cours de téléchargement ...")
        delay(3000)
        println("[$fichier] est téléchargée avec success !")
    }

    var calcule = launch(Dispatchers.Default) {
        println("Début des calcules ...")
        delay(1500)
        println("[$num1] + [$num2] = ${num1 + num2}")
        println("[$num1] x [$num2] = ${num1 * num2}")
        println("[$num1] - [$num2] = ${num1 - num2}")
        var division = if (num2 != 0) num1 / num2 else Double.NaN
        println("[$num1] / [$num2] = $division")
        delay(1000)
        println("Fin des calcules.")
    }

    var interfaceU = launch(Dispatchers.Unconfined) {
        println("l'interface de l'utilisateur, Mise a jour ...")
        delay(2500)
        println("Fin de Mise a jour de l'interface !")
    }

    joinAll(telecharger, calcule, interfaceU)

    println("=== Fin de tout les coroutines ! ===")

}


// Run :

// === Début du Programme ===
// Le fichier [Course_1.pdf] en cours de téléchargement ...
// l'interface de l'utilisateur, Mise a jour ...
// Début des calcules ...
// [7] + [9] = 16
// [7] x [9] = 63
// [7] - [9] = -2
// [7] / [9] = 0
// Fin de Mise a jour de l'interface !
// Fin des calcules.
// [Course_1.pdf] est téléchargée avec success !
// === Fin de tout les coroutines ! ===


// ------------------------------------------------------------------------------
