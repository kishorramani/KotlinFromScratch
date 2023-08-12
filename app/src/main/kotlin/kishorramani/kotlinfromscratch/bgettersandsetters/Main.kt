package kishorramani.kotlinfromscratch.bgettersandsetters

//Getters and Setters
fun main() {
    val box1 = Box()
    val box2 = Box()
    val box3 = Box()

    box1.height = 7
    println("Height: ${box1.height}")
    println("Length: ${box1.length}")
    println("Width: ${box1.width}")
    println("Volume: ${box1.volume}")

    box1.boxName = "Box1"
    println("Name: ${box1.boxName}")

    box2.boxName = "bo"
    println("Name of box2 class is: ${box2.boxName}")

    box1.open()
    box1.fillContents()
    box1.close()
}

//Kotlin provide default getter and setter for class's property,
//but if you want to provide custom value of any property
//then you have to define your own getters and setters for property
class Box {
    //property
    var length: Int = 10    //Use var or val
    var width: Int = 20
    var height: Int = 5

    //Define getters and setters Syntax
    var x: Int = 0
        get() = 10
        set(value) {
            field = value
        }

    //define custom getters for volume
    val volume
        get() = length * width * height


    //define setters
    var boxName: String = "Default Box"
        set(value) {
            if (value.length < 3) {
                println("Box name can't be less than 3 character")
            } else {
                field = value
            }
        }

    fun fillContents() {
        println("Box is Filled")
    }

    fun open() {
        println("Box Opened")
    }

    fun close() {
        println("Box Closed")
    }
}