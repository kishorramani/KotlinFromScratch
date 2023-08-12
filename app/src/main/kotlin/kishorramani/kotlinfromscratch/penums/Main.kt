package kishorramani.kotlinfromscratch.penums

//Enum:
//Whenever we want to represent group of constant, we can use enum
//All this constant inside enum are objects
enum class Color {
    RED, GREEN, BLUE
}

//you can also pass constructor with enum
enum class Color1(val colorName: String, val colorValue: Int) {
    RED("Red", 10),
    GREEN("Green", 20),
    BLUE("Blue", 30)
}

//You can also implement/inherit interface with enum
interface DoColor {
    fun doColor()
}

enum class Color2(val colorName: String, val colorValue: Int) : DoColor {
    //Everything inside enum is object so here we have to override interface method
    //If we don't override doColor method then it's give an error
    RED("Red", 10) {
        override fun doColor() {
            println("Colored with Red")
        }
    },
    GREEN("Green", 20) {
        override fun doColor() {
            println("Colored with Green")
        }
    },
    BLUE("Blue", 30) {
        override fun doColor() {
            println("Colored with Blue")
        }
    }
}
//Also keep in mind that you cannot inherit abstract class or open class with enum
//You can only use interfaces with your enum

fun main() {
    //Get all values of color enum
    //values function gives the all value's array like Array<Color>
    Color.values().forEach {
        println(it)
    }

    println("------------")

    val color = Color.GREEN
    when (color) {
        Color.RED -> println("Red")
        Color.GREEN -> println("Green")
        Color.BLUE -> println("Blue")
    }

    println("------------")
    //access color name and value like this
    println(Color1.GREEN.colorName)
    println(Color1.GREEN.colorValue)

    println("-------------")
    Color2.RED.doColor()
}