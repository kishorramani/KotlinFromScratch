package kishorramani.kotlinfromscratch.aclassandobject

//Class and Object
fun main() {
    //Create an object of class
    val box1 = Box()    //We can use val or var to create class - Create class class(Box)'s instance box1
    val box2 = Box()
    val box3 = Box()

    box1.height = 7     //Class is define using val - Here, We are changing class's property not box1 class
    println("Length: ${box1.length}")
    println("Width: ${box1.width}")
    println("Height: ${box1.height}")

    box1.open()     //Access the function using class's instance
    box1.fillContents()
    box1.close()

    //box1 = box2     //Here we need to make box1 as var
}

class Box {
    //property
    var length: Int = 10    //Use var or val
    var width: Int = 20
    var height: Int = 5

    //behaviour
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