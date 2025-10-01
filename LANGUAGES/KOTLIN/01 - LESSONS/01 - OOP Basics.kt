// OOP => Object Oriented Programming

// OOP based in :
// * Encapsulation --> C’est le fait de rassembler les attributs et les fonctions dans une même classe, 
//                 On contrôle l’accès aux données avec des modificateurs (private, public…), pour protéger l’objet
// * Abstraction --> C’est le fait de montrer seulement ce qui est important et de cacher la complexité 
//                 (ex. classe abstraite, interface).
// * Héritage --> C’est la possibilité de créer une nouvelle classe en se basant sur une classe existante. 
//                 La classe enfant (dérivée) hérite des propriétés et méthodes de la classe parent..
// * Polymorphisme --> C’est la capacité pour une même méthode d’avoir des comportements différents selon 
//                 l’objet qui l’utilise. Même appel, mais résultat adapté selon le type réel de l’objet.

// --------------------------------------------------------------------

// Class 
class smartDevice {
  // code ici
}

// --------------------------------------------------------------------

// Instance 
// instance --> est un objet d'une class 
val phoneDevice = smartDevice() 

// --------------------------------------------------------------------

// Propriétés & Méthodes de la class 
class smartDevice {
  // Propriété
  val nom = "Samsung_A53_5G"

  // Méthode
  fun turn_On() {
    println("$nom est allumée !")
  }
  
}

// --------------------------------------------------------------------

// Constucteur (constructor)

// [type 1] Contructeur primaire
class smartDevice(val nom: String, val stockage: Int) {
  
}

// [type 2] Constructeur Secondaire
class smartDevice {
  val nom: String
  val stockage: Int
  // ..
  constructor(nom: String, stockage: Int) {
    this.nom = nom
    this.stockage = stockage
  }
}

// --------------------------------------------------------------------

// L'Héritage 

// open --> mot clé permit de class parent d'etre héritée par la sous-class
open class smartDevice(name = deviceName, category = deviceCategory) {
  
}
// ex : 
class smartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
}

// --------------------------------------------------------------------

// Modificateur de visibilité 

// [4 types] : public - private - protected - internal


// [public] => Accessible partout 
class smartDevice {
    public var deviceStatut = "online"
}
var smartPhoneDevice = smartDevice()
println(smartPhoneDevice.deviceStatut) // online ✔️


// [private] => Accessible uniquement dans la classe
class smartDevice {
  private var deviceStatut = "offline"
}
var smartPhoneDevice = smartDevice() 
println(smartPhoneDevice.deviceStatut) // ERREUR : inaccessible proprieté ✖️


// [protected] => Accessible dans la classe et ses sous-classes (Héritier) 
open class smartDevice {
    protected var deviceStatut = "online"
    protected fun allumerDevice() {
        println("Device Allumée !")
    }
}
class smartPhoneDevice : smartDevice() {
    fun afficher() {
        println(deviceStatut) // "online" ✔️| accessible dans la sous-classe
        allumerDevice() // "Device Allumée" ✔️| accessible dans la sous-classe
    }
}


// [internal] => Accessible dans la même Module
// Module : un ensemble de fichiers Kotlin compilés ensemble (projet, librairie..)
internal class smartDevide {
  internal var deviceStatut = "offline"
}
var smartPhoneDevice = smartDevice() // Accessible seulement dans le même module


// --------------------------------------------------------------------

// ReadWriteProperty & ReadOnlyProperty 

// --------------------------------------------------------------------
