package kishorramani.kotlinfromscratch.dprimarysecondaryconstructorandinitblock

//Primary, Secondary Constructor and Init Block
fun main() {
    //Notice that value of length, width, height is assign first then -> init block is execute then -> Secondary constructor body is called
    val box0 = Box()    //Here, property length, width, height's value is assign using secondary constructor not primary constructor's default value
    println("--------------------")
    val box1 = Box("Black")     //Here, property length, width, height's value is assign using second secondary constructor
    println("--------------------")
    val box2 = Box(
        length = 5,
        width = 5,
        height = 5
    )

    println("--------------------")
    println("Box0's volume : ${box0.volume}")
    println("Box1's volume : ${box1.volume}")
    println("Box2's volume : ${box2.volume}")
}


//constructor keyword is optional because we don't define any public or private or protected access modifier here
/*class Box private constructor(    //here constructor is private so you can't create class's object using constructor
    var length: Int = 0,
    var width: Int = 0,
    var height: Int = 0
)*/

//primary constructor
class Box(
    var length: Int = 0,
    var width: Int = 0,
    var height: Int = 0
) {
    init {
        println("First primary constructor initialization then Init Block is called")
        println("length: $length")
    }

    init {
        println("Second Init Block")
    }

    //You can define any number of init block
    init {
        println("Third Init Block")
    }

    //In java, we can create different constructor or overload constructor with different different argument
    //In Kotlin, we can assign default value (like var length: Int = 0) to primary constructor so we don't need to create secondary constructor
    constructor() : this(2, 2, 2) {
        println("Secondary constructor called")
    }

    constructor(color: String = "Red") : this(3, 3, 3) {
        println("Second Secondary constructor called")
    }

    val volume
        get() = length * width * height

    fun fillContents() {
        println("Box is Filled")
    }

    fun open() {
        println("Box Opened")
    }
}