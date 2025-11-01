// TP8 KOTLIN – POO

// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 1

sealed class Vehicule {

    // 1. ---
    class Car (var brand: String, var model: Int, var seats: Int) : Vehicule () {}

    class MotorBike (var brand: String, var cc: Int) : Vehicule () {}

    class Truck (var brand: String, var capacity: Double) : Vehicule () {}

}

// 2. ---
fun displayVehicleInfo (vehicule: Vehicule) {

    when (vehicule) {
        is Vehicule.Car -> {
            println("-- les Infos de Voiture : ")
            println("Brand : ${vehicule.brand}, Model : ${vehicule.model}, Seats ${vehicule.seats}")
            println()
        }
        is Vehicule.MotorBike -> {
            println("-- Les Infos de Motor Bike")
            println("Brand : ${vehicule.brand}, CC : ${vehicule.cc} cc")
            println()
        }
        is Vehicule.Truck -> {
            println("-- Les Infos de Truck : ")
            println("Brand : ${vehicule.brand}, Capacity : ${vehicule.capacity} Kg")
            println()
        }
        else -> println("Erreur veuillez ressaiez !")
    }

}

// 3. ---
fun main () {

    var vehicules = mutableListOf<Vehicule>()

    var car = Vehicule.Car("Dacia", 2020, 5)
    var motorbike = Vehicule.MotorBike("Nmax", 155)
    var truck = Vehicule.Truck("Volvo", 2000.0)

    vehicules.add(car)
    vehicules.add(motorbike)
    vehicules.add(truck)

    for (vehicule in vehicules) {
        displayVehicleInfo(vehicule)
    }

}

// Terminal


//-- les Infos de Voiture :
//Brand : Dacia, Model : 2020, Seats 5

//-- Les Infos de Motor Bike
//Brand : Nmax, CC : 155 cc

//-- Les Infos de Truck :
//Brand : Volvo, Capacity : 2000.0 Kg

// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 2

sealed class RequestStatus {

    // 1. ---
    class Success (var message: String) : RequestStatus () {}

    class Error (var code: Int, var details: String) : RequestStatus () {}

    class Loading () : RequestStatus () {}

}

// 2. ---
fun handleStatus (status: RequestStatus) {

    when (status) {
        is RequestStatus.Success -> {
            println("SUCCESS ! Message : ${status.message}")
            println()
        }
        is RequestStatus.Error -> {
            println("ERREUR ! Code : ${status.code}, Details : ${status.details}")
            println()
        }
        is RequestStatus.Loading -> {
            println("Loading...")
            println()
        }
        else -> println("Erreur veuillez ressaiez !")
    }

}

// 3. ---
fun main () {

    var status = mutableListOf<RequestStatus>()

    var etatSucess = RequestStatus.Success("succès de l'exécution.")
    var etatErreur = RequestStatus.Error(404, "Not Found !")
    var etatLoader = RequestStatus.Loading()

    status.add(etatSucess)
    status.add(etatErreur)
    status.add(etatLoader)

    for (etat in status) {
        handleStatus(etat)
    }

}

// Terminal :


//SUCCESS ! Message : succès de l'exécution.
//
//ERREUR ! Code : 404, Details : Not Found !
//
//Loading...


// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 3

data class Product (var name: String, var price: Double, var category: String)

fun main () {

    // 1. ---
    var products = mutableListOf<Product>()

    var product1 = Product("Ballon", 70.0, "Sport")
    var product2 = Product("IP TV", 200.0, "Informatique")
    var product3 = Product("AirPods", 230.0, "Informatique")

    products.add(product1)
    products.add(product2)
    products.add(product3)

    var productsInformatiques = mutableListOf<Product>()

    // 2. ---
    fun filtrerInfosProducts () {
        for (product in products) {
            if (product.category == "Informatique") {
                productsInformatiques.add(product)
                println("Produit : [${product.name}] => price : ${product.price} DH")
            }
        }
    }
    println("Les Produits Informatique : ")
    filtrerInfosProducts()

    // 3. ---
    var moyenPrix = (productsInformatiques.map { it.price }.average())
    // 4. ---
    println("Le Moyen Prix des Produit Filtrés : $moyenPrix DH")

}

// Terminal


//Les Produits Informatique :
//Produit : [IP TV] => price : 200.0 DH
//Produit : [AirPods] => price : 230.0 DH
//Le Moyen Prix des Produit Filtrés : 215.0 DH


// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 4

data class Employee (var id: Int, var name: String, var salary: Double) {

    fun increaseSalary(percent: Double) {

        var increasedSalary = salary + (salary * percent/100)
        println("Le salaire aprés +${percent}% : $increasedSalary DH")

    }

    fun displayInfo () {
        println("Les informations de l'Employee : ")
        println("l'Id : $id")
        println("Le nom : $name")
        println("Le Salaire : $salary DH")
    }

}

fun main () {

    var employee = Employee(1, "Abderrafie", 7000.0)
    employee.displayInfo()
    employee.increaseSalary(10.0)

}

// Terminal :


//Les informations de l'Employee :
//l'Id : 1
//Le nom : Abderrafie
//Le Salaire : 7000.0 DH
//Le salaire aprés +10.0% : 7700.0 DH


// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 5

class House (var adress: String) {

    // 1. ---
    inner class Room (var name: String, var area: String) {

        // 2. ---
        fun printDetails () {

            println("L'adress de la maison : ${adress}")
            println("Le nom de piece : $name")
            println("L'erea de piece : $area")
            println()

        }

    }

}

fun main () {

    var house = House("Gzennaia")
    var room1 = house.Room("Salle a manger", "rez-de-chaussée")
    var room2 = house.Room("Sallon", "1er Etage")

    room1.printDetails()
    room2.printDetails()

}

// Terminal


//L'adress de la maison : Gzennaia
//Le nom de piece : Salle a manger
//L'erea de piece : rez-de-chaussée

//L'adress de la maison : Gzennaia
//Le nom de piece : Sallon
//L'erea de piece : 1er Etage


// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exrcice 6

class Library (var libraryName: String) {

    inner class Book (var title: String, var author: String) {

        fun displayBookInfo () {
            println("Bibliotheque ")
            println("Le nom : $libraryName")
            println("Le Livre ")
            println("Le titre : $title")
            println("L'Auteur : $author")
            println()
        }

    }

}

fun main () {

    var library = Library("Library Al Aqsa")
    var book1 = library.Book("and we have a meeting in Halal", "Ahmad Atta")
    var book2 = library.Book("don't be sad", "al Qarnee")

    book1.displayBookInfo()
    book2.displayBookInfo()

}

// Terminal 


//Bibliotheque
//Le nom : Library Al Aqsa
//Le Livre
//Le titre : and we have a meeting in Halal
//L'Auteur : Ahmad Atta

//Bibliotheque
//Le nom : Library Al Aqsa
//Le Livre
//Le titre : don't be sad
//L'Auteur : al Qarnee


// -----------------------------------------------------------------------------------

package TP8_KOTLIN

// Exercice 7

enum class OrderStatus {

    PENDING, IN_PROGRESS, DELIVERED, CANCELLED

}

// 1. ---
class Order (var orderId: Int, var status: OrderStatus) {

    // 2. ---
    fun updateStatus (statusUpdated: OrderStatus) {

        when (status) {
            OrderStatus.PENDING -> {
                if (statusUpdated == OrderStatus.CANCELLED || statusUpdated == OrderStatus.IN_PROGRESS)
                    println("le status de l'ordre change de '${status}' a '${statusUpdated}'")
            }
            OrderStatus.IN_PROGRESS -> {
                if (statusUpdated == OrderStatus.DELIVERED) {
                    println("le statut de l'ordre change de '${status}' a '${statusUpdated}'")
                }
            }
            OrderStatus.DELIVERED, OrderStatus.CANCELLED -> {
                println("Impossible de changer le statut de l'ordre !")
            }
        }

    }

}

//3. ---
fun main () {

    var order1 = Order(1, OrderStatus.PENDING)
    order1.updateStatus(OrderStatus.IN_PROGRESS)

    var order2 = Order(1, OrderStatus.DELIVERED)
    order2.updateStatus(OrderStatus.IN_PROGRESS)

}

// Terminal

//le status de l'ordre change de 'PENDING' a 'IN_PROGRESS'
//Impossible de changer le statut de l'ordre !


// -----------------------------------------------------------------------------------
