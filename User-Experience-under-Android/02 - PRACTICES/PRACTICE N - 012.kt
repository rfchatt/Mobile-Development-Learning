package com.example.test_tps

import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.* // Provides 'is', 'nullValue', 'notNullValue', 'closeTo'

class ProductManagerTest {

    @Test
    fun `test ajout de produits valides`() {
        val manager = ProductManager()
        manager.addProduct("Laptop", 1200.0)
        
        // Use notNullValue() instead of assertNotNull
        assertThat(manager.getProductPrice("Laptop"), `is`(notNullValue()))
        assertThat(manager.getProductPrice("Laptop"), `is`(1200.0))
    }

    @Test
    fun `test ajout produit prix negatif ne doit pas etre ajoute`() {
        val manager = ProductManager()
        manager.addProduct("Clavier", -15.0)
        
        // Use nullValue() instead of assertNull
        assertThat(manager.getProductPrice("Clavier"), `is`(nullValue()))
    }

    @Test
    fun `test suppression produit existant`() {
        val manager = ProductManager()
        manager.addProduct("Souris", 25.0)
        manager.removeProduct("Souris")
        
        assertThat(manager.getProductPrice("Souris"), `is`(nullValue()))
    }

    @Test
    fun `test recherche prix produit`() {
        val manager = ProductManager()
        manager.addProduct("Ecran", 200.0)
        
        assertThat(manager.getProductPrice("Ecran"), `is`(200.0))
        assertThat(manager.getProductPrice("Inexistant"), `is`(nullValue()))
    }

    @Test
    fun `test calcul prix total`() {
        val manager = ProductManager()
        manager.addProduct("A", 10.0)
        manager.addProduct("B", 20.5)
        manager.addProduct("C", 5.5)
        
        // For Doubles, closeTo is safer than exact equality
        assertThat(manager.calculateTotalPrice(), `is`(closeTo(36.0, 0.001)))
    }
}
