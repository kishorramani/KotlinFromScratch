package kishorramani.kotlinfromscratch.sscopefunctionletrunwithapplyalso

/*
Kotlin Scope Functions: let, run, with, apply, also
+----------+----------------+----------------+
| Function | Context Object |  Return Value  |
+----------+----------------+----------------+
| let      | it             | lambda result  |
| run      | this           | lambda result  |
| with     | this           | lambda result  |
| apply    | this           | context object |
| also     | it             | context object |
+----------+----------------+----------------+
*/

//let and also used with "it"
//run, with, apply used with "this"

class Square(
    private val width: Int,
    private val height: Int,
    var color: String? = null,
    private var text: String? = null
) {
    fun fillColor(color: String) {
        this.color = color
        println("$color color filled")
    }

    fun addText(text: String) {
        this.text = text
        println("\"$text\" text added")
    }

    override fun toString(): String {
        return "Square(width= $width, height= $height, color= $color, text= $text)"
    }
}

fun main() {
    //let - return value is lambda result, context object is 'it'
    //You can change new name instead of 'it'
    //last statement inside the scope is return value, if you don't write anything means it's returning unit
    println("--------let--------")
    var square = Square(10, 20).let {
        it.fillColor("RED")
        it.addText("Hey")
        it
    }
    println(square)

    val mySquare = Square(15, 20, "GREEN", "Keep smiling").let {
        println("---------------------")
        println("This is for testing")
        it
    }
    println(mySquare)
    println("---------------------")

    //this let function is also use for null safety, to check value is null or not
    val square1: Square? = null         //square coming from somewhere and it's null
    square1.let { square == it }       //if square1 is null then square can't assign with new value
    //above code is same as below code
    /*if (square1 != null) {
        square = square1
    }*/
    println("square1: $square1")
    println("square: $square")

    //---------------------------------

    println("--------run--------")
    //run - return value is lambda result, context object is 'this'
    val square2 = Square(20, 90).run {
        this.addText("Hi")      //Here, this is optional, check below function
        fillColor("Green")
        this
    }
    println(square2.toString())
    println(square2.color)

    println("---------------------")
    val mySquare1 = Square(20, 25, "Purple", "Hey, HRU").run {
        addText("Keep smiling")
        fillColor("Black")
        println("color is : $color")
        //this    //if this is not written then kotlin.Unit is return value
    }
    println(mySquare1.toString())
    //println(mySquare1.class)      //mySquare1 is kotlin.Unit that's why you can't access the color property of Square class

    //---------------------------------

    println("--------with--------")
    //syntax: with(className) { }
    //with - return value is lambda result, context object is 'this'
    val square3 = Square(1, 2)
    //if you have 10 and more function in square3 then you have to call that function like below
    //square3.f1()
    //square3.f2()
    //square3.f3()
    //square3.f4()
    //square3.f5()
    //but using with you don't have to write square3 every time
    val squareData = with(square3) {
        this.fillColor("Black")         //this is optional
        square3.addText("This is black color")
        this
    }
    println(square3.toString())
    println("squareData: $squareData")

    //---------------------------------

    println("------apply----------")
    //apply - return value is context object, context object is 'this'
    val square4 = Square(4, 7).apply {
        fillColor("White")      //we don't want to write this
        addText("This is white color")
        //We don't have to write return value because it's return object itself
    }
    println(square4.toString())

    println("---------------------")
    val mySquare2 = Square(10, 15, "White", "hi").apply {
        this.color = "Black"        //this value is override
        addText("Hello")
    }       //here apply return the object itself means mySquare2 is object of Square class itself
    println(mySquare2)
    //---------------------------------

    println("------also----------")
    //also - return value is context object, context object is 'it'
    val square5 = Square(14, 7).also {
        it.fillColor("Silver")
        it.addText("This is silver color")      //here, we have to use it, if not use then it's give an error
    }
    println(square5.toString())
}