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

// --- Programme Principal ---

fun main () {

    var cashP = Payment.CashPayment(200)
    typePayment(cashP)

    var cardP = Payment.CardPayment(1122334455, 655)
    typePayment(cardP)

    var digitP = Payment.DigitalPayment(399)
    typePayment(digitP)

    // -- - ---

    var opS = OperationResult.Success(100.0, "Operation finished")
    gererOperation(opS)

    var opF = OperationResult.Failure(0.0, "Error of Operation")

    var opL = OperationResult.Loading(55.0, "Operation loading")
    gererOperation(opL)

}

//  A suivre InshaAllah
