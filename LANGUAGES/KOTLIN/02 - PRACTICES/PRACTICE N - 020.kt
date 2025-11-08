package TP12_KT_GLOBAL_3

// TP 12 KOTLIN-TP-GLOBAL 3

// Exercice 1 : -- SEALED class

sealed class GameCharacter () {

    class Warrior (var strength: Double, var armor: Int) : GameCharacter ()

    class Mage (var mana: String, var spell: String) : GameCharacter ()

    class Archer (var agility: Int, var range: Int) : GameCharacter ()

    fun describeCharacter (character: GameCharacter) {

        when (character) {
            is Warrior -> {
                println("-- Warrior --")
                println("Strength : ${character.strength}")
                println("Armor : ${character.armor}")
            }
            is Mage -> {
                println("-- Mage --")
                println("Mana : ${character.mana}")
                println("Spell : ${character.spell}")
            }
            is Archer -> {
                println("-- Archer --")
                println("Agility : ${character.agility}")
                println("Range : ${character.range}")
            }
        }

    }
}


fun main () {

    var warrior1 = GameCharacter.Warrior(200.0, 2)
    warrior1.describeCharacter(warrior1)

}

//  Run : 

// -- Warrior --
// Strength : 200.0
// Armor : 2


// --------------------------------------------------------------------------


// Exercice 2 : -- SEALED class

sealed class WeatherCondition () {

    class Sunny () : WeatherCondition ()

    class Rainy () : WeatherCondition ()

    class Snowy () : WeatherCondition ()

    fun weatherAdvice (condition: WeatherCondition) {

        when (condition) {
            is Sunny -> { println("Portez des lunettes de Soleil 😎.") }
            is Rainy -> { println("N'oublie pas ton parapluie ⛈☂.") }
            is Snowy -> { println("Il neige, où est ta veste ? ❄.") }
        }

    }
}


fun main () {

    var condition1 = WeatherCondition.Sunny()
    condition1.weatherAdvice(condition1)

}

// Run :

// Portez des lunettes de Soleil 😎.


// --------------------------------------------------------------------------


// Exercice 3 : -- DATA class

data class  Developer (var id: Int, var name: String, var language: String, var projects: Int)

fun main () {

    // 1 :
    var developers = mutableListOf<Developer>(
        Developer(1, "Abderrafie", "Kotlin", 5),
        Developer(2, "Ahmed", "JavaScript", 3),
        Developer(2, "Anass", "Kotlin", 4),
        Developer(3, "Soulaiman", "C++", 1)
    )

    // 2 :
    // println(developers.toString())
    println("-- La liste des développeurs --")
    developers.forEach {
        println("ID: ${it.id}, Nom: ${it.name}, Language: ${it.language}, Projects : ${it.projects} ")
    }

    // 3 :
    var topDeveloper = developers.maxByOrNull { it.projects }
    for (developer in developers) {
        if (developer == topDeveloper) {
            println("le Top des Developpeurs par nombre des Projects est : ${developer.name}.")
        }
    }

    // 4 :
    var developersV2 = developers.map { it.copy(projects = it.projects+1) }
    println("-- La version mise a jour du liste des développeurs --")
    developersV2.forEach {
        println("ID: ${it.id}, Nom: ${it.name}, Language: ${it.language}, Projets : ${it.projects} ")
    }

    // 5 :
    println("hash Code de 1er Liste : ${developers.hashCode()}")
    println("hash Code de 2eme Liste : ${developersV2.hashCode()}")

    // 6 :
    println("-- Développeurs qui utilisent 'KOTLIN' --")
    for (developer in developers) {
        if (developer.language == "Kotlin") {
            println("Le développeur : ${developer.name}")
        }
    }

    // 7 :
    println("-- Les développeurs qui ont plus de 3 Projets --")
    for (developer in developers) {
        if (developer.projects > 3) {
            println("Le développeur : ${developer.name} -> ${developer.projects} projet.")
        }
    }

    // 8 :
    // déja codés !

}

// Run :

// -- La liste des développeurs --
// ID: 1, Nom: Abderrafie, Language: Kotlin, Projects : 5 
// ID: 2, Nom: Ahmed, Language: JavaScript, Projects : 3 
// ID: 2, Nom: Anass, Language: Kotlin, Projects : 4 
// ID: 3, Nom: Soulaiman, Language: C++, Projects : 1 

// le Top des Developpeurs par nombre des Projects est : Abderrafie.

// -- La version mise a jour du liste des développeurs --
// ID: 1, Nom: Abderrafie, Language: Kotlin, Projets : 6 
// ID: 2, Nom: Ahmed, Language: JavaScript, Projets : 4 
// ID: 2, Nom: Anass, Language: Kotlin, Projets : 5 
// ID: 3, Nom: Soulaiman, Language: C++, Projets : 2 

// hash Code de 1er Liste : -697136423
// hash Code de 2eme Liste : -697105639

// -- Développeurs qui utilisent 'KOTLIN' --
// Le développeur : Abderrafie
// Le développeur : Anass

// -- Les développeurs qui ont plus de 3 Projets --
// Le développeur : Abderrafie -> 5 projet.
// Le développeur : Anass -> 4 projet.


// --------------------------------------------------------------------------


// Exercice 4 : -- INNER class

class Server (var serverName: String, var ipAdress: String) {

    inner class User (var username: String, var role: String) {

        fun connecte () {
            println("L'utlisateur {$username} {role : $role} est connecté au serveur {$serverName} {$ipAdress}")
        }

    }

    var users = mutableListOf<User>()
    fun compter (role: String) {
        var counting = users.count { it.role == role }
        println("Le nombre des utilisateurs qui ont le role '$role' est : $counting utilisateur.")
    }

}

fun main () {

    var server1 = Server("S-1", "192.168.1.7")

    var user1 = server1.User("Abderrafie", "Mobile developer")
    var user2 = server1.User("Rayan", "admin")
    var user3 = server1.User("Lara", "Mobile developer")

    user1.connecte()
    user2.connecte()
    user3.connecte()

    server1.users.add(user1)
    server1.users.add(user2)
    server1.users.add(user3)

    server1.compter("Mobile developer")

}

// Run :

// L'utlisateur {Abderrafie} {role : Mobile developer} est connecté au serveur {S-1} {192.168.1.7}
// L'utlisateur {Rayan} {role : admin} est connecté au serveur {S-1} {192.168.1.7}
// L'utlisateur {Lara} {role : Mobile developer} est connecté au serveur {S-1} {192.168.1.7}
// Le nombre des utilisateurs qui ont le role 'Mobile developer' est : 2 utilisateur.


// --------------------------------------------------------------------------



