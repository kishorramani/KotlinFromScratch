
/*
fun main() {
    val user1 = User()
    val user2 = User("Vishal", 25)
}

class User(var name: String = "", var age: Int = 0) {
    fun showValue() {
        println("Name is $name and age is $age")
    }
}*/


import java.util.Scanner

/**
 * L7: Null value - Kotlin is null safe value
 */
fun main() {
    var g: Int? = null
    println("g's value is : $g")

    g = 7
    println("g's value is : $g")

    val number11 = readLine()       //it's use to get input from user
    val number22 = readLine()

    val result = number11!!.toInt() + number22!!.toInt()
    println(result)

    val number3 = readLine() ?: "0"
    val number4 = readLine() ?: "0"

    val result2 = number3.toInt() + number4.toInt()
    println(result2)

    //this is used to take value from user as string, it's same as readline()
    var name = Scanner(System.`in`).nextLine()
    println(name)

    //this is used to take value from user as int
    var age = Scanner(System.`in`).nextInt()
    println(age)
}