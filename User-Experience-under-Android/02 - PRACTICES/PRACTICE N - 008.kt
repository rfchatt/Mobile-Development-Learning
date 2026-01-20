// TP 12 EX - 2

// -------- | validerMotDePasse | --------

package com.example.test_tps

fun validerMotDePasse (mdp: String): Boolean {

    val _8length = mdp.length >= 8
    val _1mauscule = mdp.any { it.isUpperCase() }
    val _1digit = mdp.any { it.isDigit() }

    return _8length && _1mauscule && _1digit

}

// -------- | PasswordTest | --------

package com.example.test_tps

import kotlin.test.Test
import kotlin.test.*

class PasswordTest {

    @Test
    fun testValidPassword() {
        assertTrue(validerMotDePasse("MonCode123"))
    }

    @Test
    fun testInvalidPasswords() {
        assertFalse(validerMotDePasse("abc1234"), "Trop court")
    }

}
