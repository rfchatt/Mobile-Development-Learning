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


package TP13_KOTLIN

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Exercice 3 :

fun main () = runBlocking {

    println("== Début de l'Application ==")

    var calcule = async {
        println("calcule démaré..")
        delay(2000)
        var result = 7 * 7
        println("Fin de calcule.")
        result
    }

    var appelResau = async {
        println("Appel réseau démaré..")
        delay(1500)
        var donnees = "Stagiaire : 'Abderrafie', Age : '20', ville : 'Tanger'."
        println("Fin d'Appel réseau.")
        donnees
    }

    var temps = measureTimeMillis {
        var result1 = calcule.await()
        var result2 = appelResau.await()
        println("Résultat de Calcul : $result1")
        println("Résultat d'Appel réseau : $result2")
    }

    println("Temps Total d'exécution : ${temps} s")
    println("== Fin de l'Application ==")

}

// Run :

// == Début de l'Application ==
// calcule démaré..
// Appel réseau démaré..
// Fin d'Appel réseau.
// Fin de calcule.
// Résultat de Calcul : 49
// Résultat d'Appel réseau : Stagiaire : 'Abderrafie', Age : '20', ville : 'Tanger'.
// Temps Total d'exécution : 2031 s
// == Fin de l'Application ==


// ------------------------------------------------------------------------------


package TP13_KOTLIN

import kotlinx.coroutines.*

// Exercice 4 :

fun main () = runBlocking {

    println("== Début de l'Application 4 ==")

    var job1 = launch {
        repeat(5) { i ->
            println("Coroutine 1 - étape $i")
            delay(1000)
        }
        println("coroutine 1 Terminé")
    }

    var job2 = launch {
        repeat(3) { j ->
            println("Coroutine 1 - étape $j")
            delay(1000)
        }
        println("coroutine 2 Terminé")
    }

    println("Coroutine 1 Actif ? : ${job1.isActive}")
    println("Coroutine 2 Actif ? : ${job2.isActive}")

    println("Annulation de Coroutine 1 ..")
    job1.cancel()
    println("vérificatio de coroutine 1 aprés l'Annulation : ${job1.isActive}")

    println("Attente de la fin de coroutine 2..")
    job2.join()
    println("Coroutine 2, Terminé")

    println("== Fin de l'Application ==")

}

// Run :

// == Début de l'Application 4 ==
// Coroutine 1 Actif ? : true
// Coroutine 2 Actif ? : true
// Annulation de Coroutine 1 ..
// vérificatio de coroutine 1 aprés l'Annulation : false
// Attente de la fin de coroutine 2..
// Coroutine 1 - étape 0
// Coroutine 1 - étape 1
// Coroutine 1 - étape 2
// coroutine 2 Terminé
// Coroutine 2, Terminé
// == Fin de l'Application ==


// ------------------------------------------------------------------------------


package TP13_KOTLIN

import kotlinx.coroutines.*

// Exercice 5 :

fun main () = runBlocking {

    println("== Début de l'Application 5 ==")

    var scope = CoroutineScope(Job() + Dispatchers.Default)

    var job1 = scope.launch{
        repeat(6) { i ->
            println("job 1 étape : $i")
            delay(500)
        }
    }

    var job2 = scope.launch{
        repeat(3) { j ->
            println("job 2 étape : $j")
            delay(1000)
        }
    }

    delay(2000)

    println("-- Annulation de Scope --")
    scope.cancel()
    println("Scope Annulé !")

    delay(1000)
    println("== Fin de l'Application. ==")

}

// Run : 

// == Début de l'Application 5 ==
// job 1 étape : 0
// job 2 étape : 0
// job 1 étape : 1
// job 2 étape : 1
// job 1 étape : 2
// job 1 étape : 3
// -- Annulation de Scope --
// job 2 étape : 2
// Scope Annulé !
// == Fin de l'Application. ==


// ------------------------------------------------------------------------------


