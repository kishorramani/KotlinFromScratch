package kishorramani.kotlinfromscratch.nnestedclass

//Nested class:
//We cannot access the property and function of inner class from the instance of outer class [if inner keyword is not used], We can use that with outer class's name [Box.Content]
//[if inner keyword is used] We can access inner class's property and function by using parent's class reference, We can't access MyContent using class name directly
class Box(val width: Int, val length: Int, val height: Int) {

    class Content(val content: String) {
        //here, we can't access outer class property (width, length, height) in inner class
        /*fun printBoxInfo() {
            println("$width, $length, $height")
        }*/

        fun printContent() {
            println(content)
        }
    }

    //After using inner keyword in nested class, you can access outer class's property
    inner class MyContent(private val myContent: String) {
        //here, we can't access outer class property (width, length, height) in inner class
        fun printBoxInfo() {
            println("$width, $length, $height")
        }

        fun printMyContent() {
            println(myContent)
        }
    }
}

fun main() {
    //Here, we create content class's instance using Box class
    val content = Box.Content("Some content")
    content.printContent()

    println("--------------")
    //Let's try to access content class method using Box class's instance
    val box = Box(10, 5, 15)
    //val content1 = box.content("Some content")  //not working, we cannot access the content from the instance of box, we can directly use the content from Box class

    println("--------------")
    //If we add inner keyword in inner class then you can access outer class's property in inner class
    //refer Content1 class
    val box1 = Box(5, 8, 7)
    val myContent = box1.MyContent("My content")
    myContent.printBoxInfo()
    myContent.printMyContent()

    //val mycontent1 = Box.MyContent("")      //We can't access MyContent using class name directly
}