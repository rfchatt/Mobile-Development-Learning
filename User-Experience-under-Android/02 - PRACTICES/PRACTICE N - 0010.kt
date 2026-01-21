// TP 12 EX - 1 ( using `Hamcrest` )

// JUnit => Frame work for Testing functions..
// Hamcrest => Library that used with JUnit, for better errors messages, and easier fun 
    // on Hamcrest.. we can replace (assertEquals) of `JUnit` by (assertThat).. 

// -------- | MathUtils | --------

package com.example.tp_tests

class MathUtils {

    fun add (a: Int, b: Int) : Int {
        return a + b
    }

    fun subtract (a: Int, b: Int) : Int {
        return a - b
    }

    fun divide (a: Int, b: Int) : Double {
        if (b == 0) throw ArithmeticException("Impossible")
        return a.toDouble() / b
    }

    fun isEven(n: Int): Boolean {
        return n % 2 == 0
    }

}

// -------- | MathUtils | --------

package com.example.tp_tests

import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat // The main assertion method
import org.hamcrest.Matchers.* // Imports 'is', 'equalTo', 'closeTo', etc.
import org.junit.Assert.assertThrows      // We keep this from JUnit for exceptions

class classTests {
    val m = MathUtils()

    @Test
    fun tester_Add() {
        val result = m.add(1, 2)
        // Read as: Assert that result is equal to 3
        assertThat(result, `is`(equalTo(3)))
    }

    @Test
    fun tester_Substract() {
        val result = m.subtract(5, 2)
        // Shorthand version:
        assertThat(result, `is`(3))
    }

    @Test
    fun tester_divide() {
        val result = m.divide(1, 2)
        // Hamcrest has a specific matcher for floating point precision
        assertThat(result, `is`(closeTo(0.5, 0.001)))
    }

    @Test
    fun tester_divide_0() {
        // Hamcrest doesn't usually handle "throwing" (JUnit's assertThrows is better here)
        assertThrows(ArithmeticException::class.java) {
            m.divide(1, 0)
        }
    }

    @Test
    fun tester_isEven() {
        // Instead of assertTrue/False, we use descriptive matchers
        assertThat(m.isEven(2), `is`(true))
        assertThat(m.isEven(1), `is`(not(true))) 
    }
}
