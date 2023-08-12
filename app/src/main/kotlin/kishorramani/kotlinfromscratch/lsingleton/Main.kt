package kishorramani.kotlinfromscratch.lsingleton

//Singleton:
//Singleton pattern means only a single object
//When we want to have a single instance of class then we will use this
//Most common use case is that we have an object that is expensive to create and we will use that very frequently
//In this case, we have to make only a single instance which is shared through the application

class Manager private constructor() {

    //static is not used in kotlin, here companion object is used
    //to make class singleton we have to use companion object
    companion object {
        private var instance: Manager? = null

        //Without synchronized keyword code is not thread safe,
        //if 2 class access this object same time then might be it's create duplicate object
        //To make thread safe we have to use synchronized
        /*fun getInstance() = synchronized(this) {
            if (instance == null) {
                instance = Manager()
            }
            instance
        }*/

        //We also can use invoke operator
        operator fun invoke() = synchronized(this) {
            if (instance == null) {
                instance = Manager()
            }
            instance
        }
    }
}

//We only need to use 'object' keyword, We don't have to create constructor
//This is thread safe
//kotlin simplifies the singleton pattern, we just need to use object keyword, it's a same as class but it's not have constructor
//here we can't make constructor like GeneralManager() this
object GeneralManager {
    //init block called only once
    init {
        println("General Manager object initialized")
    }
}

fun main() {
    //it's private so we can't access
    //val m = Manager()
//    println(Manager.getInstance())
//    println(Manager.getInstance())
//    println(Manager.getInstance())
//    println(Manager.getInstance())

    //if we use invoke operator then we don't have to write getInstance
    println(Manager.invoke())
    println(Manager())
    println(Manager())      //Here, we don't have to write invoke() function

    //----------------------------
    println("----------------------")

    //Above code is boiler plate code
    //kotlin provide too much easy solution for creating singleton class
    //refer object class GeneralManager
    println(GeneralManager)
    println(GeneralManager)
    println(GeneralManager)
    println(GeneralManager)
}