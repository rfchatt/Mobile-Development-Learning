// TP 12 EX - 3

// -------- | ProductManager | --------

class ProductManager {
    private val products = mutableMapOf<String, Double>()

    fun addProduct(name: String, price: Double) {
        if (price > 0) {
            products[name] = price
        } else {
            println("Erreur : Le prix pour $name doit être positif.")
        }
    }

    fun removeProduct(name: String) {
        products.remove(name)
    }

    fun getProductPrice(name: String): Double? {
        return products[name]
    }

    fun calculateTotalPrice(): Double {
        return products.values.sum()
    }
}

// -------- | ProductManagerTest | --------

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertNotNull

class ProductManagerTest {

    @Test
    fun `test ajout de produits valides`() {
        val manager = ProductManager()
        manager.addProduct("Laptop", 1200.0)
        
        assertNotNull(manager.getProductPrice("Laptop"))
        assertEquals(1200.0, manager.getProductPrice("Laptop"))
    }

    @Test
    fun `test ajout produit prix negatif ne doit pas etre ajoute`() {
        val manager = ProductManager()
        manager.addProduct("Clavier", -15.0)
        
        // Le produit ne doit pas exister dans la liste
        assertNull(manager.getProductPrice("Clavier"))
    }

    @Test
    fun `test suppression produit existant`() {
        val manager = ProductManager()
        manager.addProduct("Souris", 25.0)
        manager.removeProduct("Souris")
        
        assertNull(manager.getProductPrice("Souris"))
    }

    @Test
    fun `test recherche prix produit`() {
        val manager = ProductManager()
        manager.addProduct("Ecran", 200.0)
        
        assertEquals(200.0, manager.getProductPrice("Ecran"))
        assertNull(manager.getProductPrice("Inexistant"))
    }

    @Test
    fun `test calcul prix total`() {
        val manager = ProductManager()
        manager.addProduct("A", 10.0)
        manager.addProduct("B", 20.5)
        manager.addProduct("C", 5.5)
        
        // Somme attendue : 36.0
        assertEquals(36.0, manager.calculateTotalPrice())
    }
}
