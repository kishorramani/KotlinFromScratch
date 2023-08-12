package kishorramani.kotlinfromscratch.cvisibilitymodifier

//Visibility Modifiers
fun main() {
    val box1 = Box()
    val box2 = Box()
    val box3 = Box()

    box1.height = 7
    println("Height: ${box1.height}")
    println("Length: ${box1.length}")
    println("Width: ${box1.width}")
    println("Volume: ${box1.volume}")

//    box1.boxName = "My"       //it's private
    println("Name: ${box1.boxName}")

    box1.open()
    box1.fillContents()
}

//4 type of access modifier
//all function and variable are public by default
class Box {
    /*
    * public: Default, can be accessed everywhere
    * internal: Available everywhere in the same module
    * private: Available only inside the containing file or class
    * protected: Same as private but available inside subclasses or child classes
    * */

    var length: Int = 10
    var width: Int = 20
    var height: Int = 5

    val volume
        get() = length * width * height     //get function is public because the volume is public. If volume is private then get method is also private

    var boxName: String = "Box Name"
        private set(value) {        //It's private so you can't access outside of class
            if (value.length < 3) {
                println("Name cannot be less than 3 characters")
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
}