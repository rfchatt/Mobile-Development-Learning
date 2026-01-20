// TP 12 EX - 1

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

// -------- | classTests | --------

package com.example.tp_tests

import org.junit.Test
import org.junit.Assert.*

class classTests {
    val m = MathUtils()

    @Test
    fun tester_Add () {
        val result = m.add(1, 2)
        assertEquals(3, result)
    }

    @Test
    fun tester_Substract () {
        val result = m.subtract(5, 2)
        assertEquals(3, result)
    }

    @Test
    fun tester_divide () {
        val result = m.divide(1, 2)
        assertEquals(0.5, result, 0.001)
    }

    @Test
    fun tester_divide_0 () {
        assertThrows(ArithmeticException::class.java) {
            m.divide(1, 0)
        }
    }

    @Test
    fun tester_isEven () {
        assertTrue(m.isEven(2))
        assertFalse(m.isEven(1))
    }

}

