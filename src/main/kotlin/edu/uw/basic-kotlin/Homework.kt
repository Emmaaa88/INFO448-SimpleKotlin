package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
    fun whenFn(input: Any): String {
        return when (input) {
            is String -> {
                when (input) {
                    "Hello" -> "world"
                    "Howdy" -> "Say what?"
                    "Bonjour" -> "Say what?"
                    else -> "I don't understand"
                }
            }
            is Int -> {
                when (input) {
                    0 -> "zero"
                    1 -> "one"
                    in 2..10 -> "low number"
                    else -> "a number"
                }
            }
            else -> "I don't understand"
        }
    }

// write an "add" function that takes two Ints, returns an Int, and adds the values
    fun add(a: Int, b: Int): Int{
        return a + b
    }

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
    fun sub(a: Int, b: Int): Int{
        return a - b
    }

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
    fun mathOp(a: Int, b: Int, operation: (Int, Int) -> Int): Int{
        return operation(a, b)
    }
// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, val age: Int) {
    val debugString: String
        get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(val amount: Int, val currency: String) {
    init {
        require(amount >= 0)
        require(currency in setOf("USD", "EUR", "CAN", "GBP"))
    }

    fun convert(convertCurremcy: String): Money {
        val convertMethod = when {
            currency == "USD" && convertCurremcy == "GBP" -> amount / 2
            currency == "USD" && convertCurremcy == "EUR" -> amount * 3 / 2
            currency == "USD" && convertCurremcy == "CAN" -> amount * 5 / 4

            currency == "GBP" && convertCurremcy == "EUR" -> amount * 3
            currency == "GBP" && convertCurremcy == "CAN" -> amount * 5 / 2
            currency == "GBP" && convertCurremcy == "USD" -> amount * 2

            currency == "EUR" && convertCurremcy == "USD" -> amount * 2 / 3
            currency == "EUR" && convertCurremcy == "GBP" -> amount / 3
            currency == "EUR" && convertCurremcy == "CAN" -> amount * 5 / 6

            currency == "CAN" && convertCurremcy == "USD" -> amount * 4 / 5
            currency == "CAN" && convertCurremcy == "EUR" -> amount * 6 / 5
            currency == "CAN" && convertCurremcy == "GBP" -> amount * 2 / 5
            else -> amount
        }
        return Money(convertMethod, convertCurremcy)
    }

    operator fun plus(anotherCurr: Money): Money {
        if (currency == anotherCurr.currency) {
            return Money((amount + anotherCurr.amount), currency)
        } else {
            return Money((amount + anotherCurr.convert(currency).amount), currency)
        }
    }
}