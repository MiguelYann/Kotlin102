package functions

import java.util.stream.Collectors

fun main() {

    /**
     * Default Parameter Values and Named Arguments
     */
    printMessage("Hello Kotlin")
    printMessageWith("Defaut method parameters in kt")
    printMessageWith(
        prefix = "WARN",
        message = "name parameters"
    ) // Useful when you have more params and you don't know the position of

    println("Sum is:  ${sum(1, 2)}")
    println("Multiplicative is:  ${multiply(1, 2)}")


    /**
     * Infix Functions
     */

    println(repeatSentence("toto", 2))

    println(2 times "toto")

    val pair = "Food" to "Juice" // Give a Pair type of 2 values
    val salary = Pair("Passport", 25)
    val collect = pair.toList().stream().map { it.plus("s") }.collect(Collectors.toList())
    println(collect)


    val miguel = Person(name = "Miguel")
    val yann = Person(name = "Yann")

    miguel sayHi yann
    yann wanToSay "Kotlin it's awesome"
}


/**
 * Function that return nothing , Unit it(s optional
 */
fun printMessage(message: String): Unit {
    println(message)
}


/**
 * Add optional parameter with default value
 */
fun printMessageWith(message: String, prefix: String = "INFO") {
    printMessage("|$prefix|$message")
}


/**
 * function can return value of type
 */
fun sum(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber;
}


/**
 * A body function can be an expression, and return it's implicit with type
 */
fun multiply(i: Int, j: Int) = i * j;


/**
 * Older case, to repeat string
 */
fun repeatSentence(sentence: String, times: Int) = sentence.repeat(times)

/**
 * Same but refacto with infix function, you add a method to Int object
 */
infix fun Int.times(sentence: String) = sentence.repeat(this)


/**
 * Infix also works on custom object
 */
class Person(private val name: String) {
    infix fun sayHi(other: Person) = println("Hi ${other.name}")
    infix fun wanToSay(something: String) = println("$name: '$something'")
}