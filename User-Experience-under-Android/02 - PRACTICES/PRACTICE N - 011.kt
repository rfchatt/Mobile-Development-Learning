// TP 12 EX - 2 (Hamcrest)

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

import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

class PasswordTest {

    @Test
    fun testValidPassword() {
        assertThat(validerMotDePasse("MonCode123"), `is`(True)) // <-
    }

    @Test
    fun testInvalidPasswords() {
        assertThat("Trop court", validerMotDePasse("abc1234"), `is`(false)) // <-
    }

}
