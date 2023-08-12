package kishorramani.kotlinfromscratch.rextensionfunction

//Extension function:
//Adding new functionality to existing class is called extension function

//If you want to add some more functionality or function to existing class, You can do it easily if you own the class
//but if you don't own the class and you want to add some functionality then extension function will be used

//syntax - classname.CustomFunctionName
fun String.getAllWords(): List<String> {
    //this - refer string class
    return this.split(" ")
}

fun main() {
    val a: String = "Hello, How are you friend"
    //Here, We don't own the String class, We don't add the new function to this file
    //In this situation, if we want to add some functionality then, we can create new class which inherit the sting class to this class and there we can add new function
    //We can add function to existing classes without deriving new classes or without following new design pattern

    //If we want to add new function to the String class create extension function
    val words = a.getAllWords()     //Here, you can see that getAllWords() function is not part of String class
    println(words)      //words return list of words
}

