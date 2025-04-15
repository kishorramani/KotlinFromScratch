package kishorramani.learnkotlin

import java.util.Locale

fun main() {
//L1: Simple Hello world
    println("------------- L1 - Simple Hello world ----------------")
    println("Hello world")

//L2: variable and Data Type
    println("------------- L2: variable and Data Type ----------------")

    var x: Int = 3  //assign value with var     //kotlin is smart enough, we don't have to declare Int type
    println("The value of x is $x")

    //assign new value
    x = 10
    println("The value of x is now $x")

    val y: Int = 3  //assign value with val
    println("The value of y is $y")

    //y = 7   //We can't change value of y

    val wholeNumber = 1
    val bigNumber = 1L
    val preciseDecimal = 7.12
    val decimal = 7.12f
    val isConditionTrue = true
    val isThisLetter = 'K'

//L3: Arithmetic Operation
    println("------------- L3: Arithmetic Operation ----------------")

    val a = 12 * 7
    println("12 * 7 - Value of a is $a")

    val b = 12 / 7
    println("12 / 7 - Value of b is $b")

    val c = 12f / 7f
    println("12f / 7f - Value of c is $c")

    val d = 10 % 6
    println("10 % 6 - Value of d is $d")

//L4: Logical and Comparison Operator
    println("------------- L4: Logical and Comparison Operator ----------------")

    val areYouProgrammer = true
    val areYouAboveAdult = true
    val areYouAnAdultProgrammer = areYouProgrammer && areYouAboveAdult
    println("Are You An Adult Programmer: $areYouAnAdultProgrammer")

    val areYouProgrammer1 = true
    val areYouAboveAdult1 = false
    val areYouAnAdultProgrammer1 = areYouProgrammer1 || areYouAboveAdult1
    println("Are You An Adult Programmer1: $areYouAnAdultProgrammer1")

    val areYouProgrammer2 = true
    val areYouAboveAdult2 = true
    val areYouAnAdultProgrammer2 = (areYouProgrammer2 == areYouAboveAdult2)
    val areYouAnAdultProgrammer22 = (areYouProgrammer2 != areYouAboveAdult2)

    println("Are You An Adult Programmer2: $areYouAnAdultProgrammer2")
    println("Are You An Adult Programmer22: $areYouAnAdultProgrammer22")

    val areYouProgrammer3 = true
    val areYouAboveAdult3 = true
    val areYouAnAdultProgrammer3 = !(areYouProgrammer3 != areYouAboveAdult3)
    println("Are You An Adult Programmer3: $areYouAnAdultProgrammer3")

//L5: String
    println("------------- L5: String ----------------")

    val string = "Are you a Kotlin Developer?"
    println(string)
    println(string.uppercase(Locale.getDefault()))

//L6: If condition
    println("------------- L6: If condition ----------------")

    val e = 1 + 2
    if (e == 2) {
        println("e's value is 2")
    } else if (e == 3) {
        println("e's value is 3")
    } else {
        println("e's value is not 2 or 3")
    }

    val f = if (e == 2) 2 else 3    //if is also used to assign value to variable
    println("value of f: $f")

//L7: Null value - Kotlin is null safe value
    println("------------- L7: Null value - Kotlin is null safe value ----------------")
    var g: Int? = null
    println("g's value is : $g")

    g = 7
    println("g's value is : $g")

    /*val number11 = readLine()       //it's use to get input from user
    val number22 = readLine()

    val result = number11!!.toInt() + number22!!.toInt()
    println(result)

    val number3 = readLine() ?: "0"
    val number4 = readLine() ?: "0"

    val result2 = number3.toInt() + number4.toInt()
    println(result2)*/

    //this is used to take value from user as string, it's same as readline()
    //var name = Scanner(System.`in`).nextLine()
    //println(name)

    //this is used to take value from user as int
    //var age = Scanner(System.`in`).nextInt()
    //println(age)

//L8: Lists
    println("------------- L8: Lists ----------------")

    val vegetableList = listOf<String>("VegetableA", "VegetableB")
    println(vegetableList)
    println(vegetableList[0])
    //println(vegetableList[4])   //Index 4 out of bounds for length 2

    val shoppingList = mutableListOf("item1", "item2")
    shoppingList.add("item3")
    println(shoppingList)

//L9: While loop
    println("------------- L9: While loop ----------------")
    val shoppingList1 = mutableListOf("item1", "item2")

    var counter = 0
    while (counter < shoppingList1.size) {
        println(shoppingList1[counter])
        counter++
    }

//L10: For loop
    println("------------- L10: for loop ----------------")
    val shoppingList2 = mutableListOf("item1", "item2", "item3")

    for (item in shoppingList2) {
        println("shopping list item: $item")
    }

    for (i in 1..5) {
        println(i)
    }

//L11: When
    println("------------- L11: when ----------------")
    val h = 1 + 2
    when (h) {
        2 -> {
            println("h's value is 2")
        }

        3 -> {
            println("h's value is 3")
        }

        else -> {
            println("h's value is not 2 or 3")
        }
    }

    val i = 1 + 8
    when (i) {
        in 1..2 -> println("i is between 1 and 2")
        in 3..15 -> println("i is between 3 and 15")
        else -> {
            println("i is not in the range of 1 to 15")
        }
    }

//L12 - Function
    println("------------- L12 - Function ----------------")
    print10Number()

    val number = isEven(15)
    println("isEven: $number")

    val number1 = isEvenWithDefaultParameter()      //if we don't pass the parameter then it's take a default parameter
    println("isEvenWithDefaultParameter: $number1")

//L13 - Extension function
    println("------------- L13 - Extension function ----------------")
    val j = 13
    println("j is odd: ${j.isOdd()}")

    val k = 13
    println("k is even ${k.isEven1()}")

//L14: Classes
    println("------------- L14: Classes ----------------")
    val car = Vehicle("Car")

//L15: Inheritance
    println("------------- L15: Inheritance ----------------")
    val cat = Cat()
    cat.meow()
    cat.legCount()  //You can access parents class method

    val dog = Dog()
    dog.bark()
    dog.myName()

    val kangaroo = Kangaroo()
    kangaroo.sound()

    //In general nothing is just Animal, Every Animal is specific.
    val animal = Animal("Animal")       //So Let's make Animal class to abstract class

//L16: Abstraction
    println("------------- L16: Abstraction ----------------")

    //val animal2 = Animal2("Animal")     //Cannot create an instance of an abstract class
    val cat2 = Cat2()
    cat2.makeSound()

    val dog2 = Dog2()
    dog2.makeSound()

    val kangaroo2 = Kangaroo2()
    kangaroo2.makeSound()

//L17: Anonymous class
    //A class that have no name is known as anonymous inner class.
    //It should be used if you have to override method of class or interface. Java Anonymous inner class can be created by two ways:
    //1: Class (may be abstract or concrete).
    //2: Interface
    println("------------- L17: Anonymous class ----------------")
    val bear = object : Animal2("Camembear") {
        override fun makeSound() {
            println("ROOOAR")
        }
    }
    bear.makeSound()

//L18: Try catch
    println("------------- L18: Try catch ----------------")
//    val numberValue = readLine() ?: "0"
//    println(numberValue.toInt())

//    val numberValue1 = 9
    val numberValue1 = "Hello"
    val parsedNumber = try {
        numberValue1.toInt()
    } catch (e: Exception) {
        //e.printStackTrace()       //comment this line to run this code, we will send 0 if we get error in try catch
        0
    }
    println("parseNumber is : $parsedNumber")

//L19: Lambda Functions
//Lambda is a function which has no name.
//Lambda is defined with a curly braces {} which takes variable as a parameter (if any) and body of function.
//The body of function is written after variable (if any) followed by -> operator.
    println("------------- L19: Lambda Functions ----------------")
    addNumber(10, 15) {
        println(it)
    }

//L20: Polymorphism - Function Overloading
    println("------------- L20: Polymorphism - Function Overloading ----------------")

    add(4f, 5f)
    add(3, 6)
    add(3.4, 6.3)
    add(3, 5, 7)

    //Polymorphism - Function Overloading
}

//--------------------functions------------------------

//function
fun print10Number() {
    for (i in 1..10) {
        println(i)
    }
}

fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

fun isEvenWithDefaultParameter(number: Int = 0): Boolean {
    return number % 2 == 0
}

//Extension function
fun Int.isOdd(): Boolean {
    return this % 2 == 1
}

fun Int.isEven1(): Boolean {
    return this % 2 == 0
}

fun sort(s: Array<String>, n: Int) {
    for (i in 1 until n) {
        val temp = s[i]

        // Insert s[j] at its correct position
        var j = i - 1
        while (j >= 0 && temp.length < s[j].length) {
            s[j + 1] = s[j]
            j--
        }
        s[j + 1] = temp
    }
}

//L19: Lambda function
fun addNumber(a: Int, b: Int, mylambda: (Int) -> Unit ){   //high level function lambda as parameter
    val add = a + b
    mylambda(add) // println(add)
}

//Polymorphism - Function Overloading
fun add(a: Int, b: Int) {
    println(a + b)
}

fun add(a: Int, b: Int, c: Int) {
    println(a + b + c)
}

fun add(a: Float, b: Float) {
    println(a + b)
}

fun add(d: Double, d1: Double) {
    println(d + d1)
}

//L14: class
class Vehicle(name: String) {

    //This init block is executed whenever we create instance of class
    init {
        println("Hello, my name is $name")
    }
}

//L15: Inheritance
//Here, we declare legCount with val that means that we can access legCount in sub class
open class Animal(name: String, val legCount: Int = 4) {
    init {
        println("Hello, I am $name and I have $legCount legs")
    }

    fun legCount() {
        println("I have $legCount legs")
    }

    fun myName() {
//        println("My name is $name")     //name gives error because it's not initialize
        println("I am animal")
    }
}

//To inherit Animal class, make Animal class open
class Cat : Animal("Cat") {
    init {
        println("Print from Cat class")
    }

    fun meow() {
        println("MEOW MEOW!!")
    }
}

class Dog : Animal("Dog") {
    init {
        println("Print from Dog class")
    }

    fun bark() {
        println("WUFF WUFF!!")
    }
}

class Kangaroo : Animal("Kangaroo", 2) {
    init {
        println("Print from Kangaroo class")
        println("Hey, I have $legCount legs")
    }

    fun sound() {
        println("Hiss Hiss!!")
    }
}

//L16: Abstraction
//Here, we declare legCount with val that means that we can access legCount in sub class
abstract class Animal2(name: String, val legCount: Int = 4) {
    init {
        println("Hello, I am $name and I have $legCount legs")
    }

    abstract fun makeSound()
}

//To inherit abstract Animal class, we have to implement abstract method like makeSound method
class Cat2 : Animal2("Cat") {
    override fun makeSound() {
        println("MEOW MEOW!!")
    }
}

class Dog2 : Animal2("Dog") {
    override fun makeSound() {
        println("WUFF WUFF!!")
    }
}

class Kangaroo2 : Animal2("Kangaroo", 2) {
    override fun makeSound() {
        println("Hiss Hiss!!")
    }
}