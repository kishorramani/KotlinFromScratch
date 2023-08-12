package kishorramani.kotlinfromscratch.uexceptionhandling

//Exception:
//Exception - it's an abnormal condition, means your code successfully compile and you can execute it
//While executing code, any event which interrupt normal flow of your code execution is called exception

//Other words - any event which occurred run time is called exception

//Example - IndexOutOfBoundsException, NullPointerException, ArithmeticException,
//You can create your own custom exception
//3 main thing - message, stacktrace, optional cause

val a = 10
val b = 0

val names = listOf<String>("Ramani")

fun main() {
    //println(a / b)      //Exception in thread "main" java.lang.ArithmeticException: / by zero

    //println(names[1])      //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 1

    //---------------------------------------

    try {
        println("Hello")
        println(3 / 0)
        println("Hello1")
    } catch (e: ArithmeticException) {
        println("Inside catch block")
        println(e.message)
    } finally {
        //write important code
        println("Finally")
    }

    println("----------------------------------")

    //---------------------------------------

    val a = 10
    val b = 0
    val result = try {
        println("inside try block")
        a / b       //if this is execute then the result is some value a/b
    } catch (e: ArithmeticException) {
        println("inside catch block")
        0           //if we don't write 0 here then result is kotlin.Unit
    }
    println("Result is $result")
    println("----------------------------------")

    //---------------------------------------

    //vote("Kishor", 16)      //IllegalArgumentException - Younger than 18 cannot vote
    try {
        println("Hello before code")
        vote("Kishor", 16)      //Code execution stop after this code line but next code is execute successfully ("Hello after try catch block")
        println("Hello after code")
    } catch (e: IllegalVoterException) {
        println(e.message)
        println("printing (e: IllegalVoterException) block")
    } catch (e: Exception) {
        e.printStackTrace()
        println("printing (e: Exception) block")
    } finally {
        println("Finally")
    }
    println("Hello after try catch block")
}

fun vote(name: String, age: Int) {
    if (age < 18) {
        throw IllegalVoterException("Younger than 18 cannot vote")      //custom exception
        //throw IllegalArgumentException("Younger than 18 cannot vote")
    }
    println("$name voted")
}

//Create own exception class
/*
*
* Throwable class
* Exception class
* All other exception that are predefine
*
* */

class IllegalVoterException(message: String) : Exception(message)