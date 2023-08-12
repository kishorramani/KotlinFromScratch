package kishorramani.kotlinfromscratch.einheritance

//Inheritance
//Inheritance is -
//Deriving or creating another class from existing class;
//This derived class will inherit property of the parent class;
//that will allow us to use existing implementation of parent class;
//So mainly it's use for code reusability
fun main() {
    //First, BaseCoffeeMachine's init block is called then PremiumCoffeeMachine's init block is called
    val coffeeMachine = PremiumCoffeeMachine(10000.0, "BROWN")
    coffeeMachine.makeCappuccino()
    coffeeMachine.makeCoffee()
    coffeeMachine.makeCoffee1()
}

//All the classes are final by default so it's not allow to inherit default class (final class) so we have to make a open explicitly
//Make class open to use as a inheritance
open class BaseCoffeeMachine(
    private val price: Double,
    private val color: String
) {
    init {
        println("BaseCoffeeMachine's init block")
    }

    fun makeCoffee() {
        println("Here is your coffee ☕")
    }

    open fun makeCoffee1() {
        println("Here is your coffee1 from super class ☕")
    }
}

//Make BaseCoffeeMachine to open to inherit (final class is not inherit)
class PremiumCoffeeMachine(private val price: Double, private val color: String) : BaseCoffeeMachine(price, color) {
    init {
        println("PremiumCoffeeMachine's init block")
    }

    fun makeCappuccino() {
        println("Here is your cappuccino ☕")
    }

    //it's base class's method,
    //We have to use override keyword to override method of super class
    //Also we have to make super class method's open
    override fun makeCoffee1() {
        //super.makeCoffee1()     //if you want to call the super class's method then use this code
        println("Here is your coffee1 from sub class ☕")
    }
}