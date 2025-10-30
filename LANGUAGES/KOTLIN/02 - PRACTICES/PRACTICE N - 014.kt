package TP7_KOTLIN

import jdk.dynalink.Operation

// TP 7 - KOTLIN 
 
// Exercise 1 -- 

sealed class Payment {

    class CashPayment (var amount: Int) : Payment () {}

    class CardPayment (var cardNumber: Int, var amount: Int) : Payment () {}

    class DigitalPayment (var amount: Int) : Payment () {}

}

fun typePayment (payment: Payment) {

    when (payment) {
    is Payment.CashPayment -> println("Payment Par Cash !, montant : ${payment.amount} DH")
    is Payment.CardPayment -> println("Payment Par Carte !, numero : [${payment.cardNumber}]")
    is Payment.DigitalPayment -> println("Digital Payment !, montant : ${payment.amount}")
    }

}

// Exercise 2 --

sealed class OperationResult {

    class Success (var data: Double, var errorMessage: String) : OperationResult () {}

    class Failure (var data: Double, var errorMessage: String) : OperationResult () {}

    class Loading (var data: Double, var errorMessage: String) : OperationResult () {}

}

fun gererOperation (operation: OperationResult) {

    when (operation) {
        is OperationResult.Success -> println("Opération success !  Data : ${operation.data}% , Message : ${operation.errorMessage}")
        is OperationResult.Failure -> println("Opération Failed !  Data : ${operation.data}% , Message : ${operation.errorMessage}")
        is OperationResult.Loading -> println("Opération Loading !  Data : ${operation.data}% , Message : ${operation.errorMessage}")
    }

}

// Exercise 3 --

data class User (var id: Int, var name: String, var email: String)

fun filtrerDomains (users: List<User>, domaine: String) {
    var usersFiltres = users.filter { it.email.endsWith(domaine) }

    for (user in usersFiltres) {
        println("Les utlisateurs de domaine : '${domaine}'")
        println("${user.name} qu'a l'ID [${user.id}] á le domaine d'émail : ${user.email}")
    }
}

// Exercise 4

data class Product (var name: String, var price: Double, var quantity: Int) {

    fun calculerPrixTotal () : Double {
        return price * quantity
    }

    fun AfficherDetails () {
        println("-- Détails des Produits --")
        println("Le nom : $name")
        println("Le prix : $price DH")
        println("La quantité : $quantity piece")
        println("Le prix Total : ${calculerPrixTotal()} DH")
        println()
    }
}

// Exercise 5 --

class Box (var size: Double) {

    inner class Item (var name: String) {

        fun AfficherDetails () {
            println("Les détails de Box et d'Item : ")
            println("Le size de Box : $size cm")
            println("Le nom d'Item :  $name")
        }

    }

}

// Exercise 6 --

class Library (var libraryName: String) {

    inner class Book (var title: String, var author: String) {

        fun AfficherDetails () {
            println("--- les Détails ---")
            println("Bibliothéque >> ")
            println("Le Nom : $libraryName")
            println("Livre >> ")
            println("Le Titre : $title")
            println("L'Auteur : $author")
        }

    }

}

// Exercise 7 --

enum class OrderStatus (var description: String) {

    PENDING("Pending Order !"),
    SHIPPED("Shipped Order !"),
    DELIVERED("Delivered Order !"),
    CANCELLED("Canceled Order !")

}

class Order (var status: OrderStatus) {

    fun changerStatus (nouveauStatus: OrderStatus) {

        when (status) {

            OrderStatus.PENDING -> {
                if (nouveauStatus == OrderStatus.CANCELLED || nouveauStatus == OrderStatus.SHIPPED) {
                    println("Status de l'order changé de $status a $nouveauStatus")
                }
            }
            OrderStatus.SHIPPED -> {
                if (nouveauStatus == OrderStatus.DELIVERED) {
                    println("Status de l'order changé de $status a $nouveauStatus")
                }
            }
            OrderStatus.DELIVERED, OrderStatus.CANCELLED -> {
                println("Impossible de modifier le Status $status")
            }

        }

    }

}

// Exercise 8 --

enum class DayOfWeek () {

    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE

}

fun describeDay (day: DayOfWeek) {

    when (day) {

        DayOfWeek.LUNDI -> {
            println("c'est le début de la semaine !")
        }
        DayOfWeek.MARDI -> {
            println("c'est le 2eme jour de la semaine !")
        }
        DayOfWeek.MERCREDI, DayOfWeek.JEUDI -> {
            println("c'est le milieu de la semaine !")
        }
        DayOfWeek.VENDREDI -> {
            println("c'est presque le week-end !")
        }
        DayOfWeek.SAMEDI, DayOfWeek.DIMANCHE -> {
            println("c'est le week-end !")
        }

    }

}




// --- Programme Principal ---

fun main () {

    // Ex 1 --

    var cashP = Payment.CashPayment(200)
    typePayment(cashP)

    var cardP = Payment.CardPayment(1122334455, 655)
    typePayment(cardP)

    var digitP = Payment.DigitalPayment(399)
    typePayment(digitP)

    // --- - ---

    // Ex 2 --

    var opS = OperationResult.Success(100.0, "Operation finished")
    gererOperation(opS)

    var opF = OperationResult.Failure(0.0, "Error of Operation")

    var opL = OperationResult.Loading(55.0, "Operation loading")
    gererOperation(opL)

    // --- - ---

    // Ex 3 --

    var users = listOf<User>(
        User(1, "Abderrafie", "chattabdrrafie@gmail.com"),
        User(3, "Chate", "chate@outlook.com"),
        User(5, "Barae", "barae.chatt@icloud.com")
    )

    filtrerDomains(users, "@gmail.com")


    // Ex 4 --

    var product1 = Product("Milk", 4.0, 10)
    product1.calculerPrixTotal()
    product1.AfficherDetails()

    var product2 = Product("chocolat", 10.0, 23)
    product2.calculerPrixTotal()
    product2.AfficherDetails()

    // Ex 5 --

    var box = Box(75.5)
    var item = box.Item("Carre")
    item.AfficherDetails()

    // Ex 6 --

    var library = Library("Library Istanbul")
    var book = library.Book("and we have a meeting in Halal", "Ahmed Atta")
    book.AfficherDetails()

    // Ex 7 --

    var order1 = Order(OrderStatus.PENDING)
    order1.changerStatus(OrderStatus.SHIPPED)

    var order2 = Order(OrderStatus.DELIVERED)
    order2.changerStatus(OrderStatus.CANCELLED)

    // Ex 8 --

    var day1 = describeDay(DayOfWeek.LUNDI)  // c'est le début de la semaine !
    println(day1.hashCode())    // 1283928880

    var day2 = describeDay(DayOfWeek.MARDI)  // c'est le 2eme jour de la semaine !
    println(day2.equals(day1))  // true

    var day3 = describeDay(DayOfWeek.MERCREDI)  // c'est le milieu de la semaine !
    var day4 = describeDay(DayOfWeek.JEUDI)  // c'est le milieu de la semaine !
    var day5 = describeDay(DayOfWeek.VENDREDI)  // c'est le milieu de la semaine !
    var day6 = describeDay(DayOfWeek.SAMEDI) // c'est le week-end !
    var day7 = describeDay(DayOfWeek.DIMANCHE)  // c'est le week-end !

    
}


