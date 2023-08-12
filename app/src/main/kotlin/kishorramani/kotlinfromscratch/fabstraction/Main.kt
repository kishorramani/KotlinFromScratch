package kishorramani.kotlinfromscratch.fabstraction

//Abstraction
//Abstract - It's a keyword; just defining member and function without the actual implementation
//abstract keyword is used
//You cannot create instance of abstract class [You can create instance of open class]

//When you should abstract class?
//Whenever you have to define common set of rules for multiple classes,
//You can make a common abstract parent class; You can derived your child classes using common base class
fun main() {
    val coffeeMachine = PremiumCoffeeMachine(10000.0, "BROWN")
    val coffee = coffeeMachine.makeCoffee("CAPPUCCINO")
    val info = coffeeMachine.machineInfo()
    println(coffee)
    println(info)

    println("-----------------")
    val simpleCoffeeMachine = CoffeeMachine(2000.0, "BLACK")
    val coffee1 = simpleCoffeeMachine.makeCoffee("Milk CAPPUCCINO")
    val info1 = simpleCoffeeMachine.machineInfo()
    println(coffee1)
    println(info1)
}

//You cannot create instance of abstract class [You can create instance of open class]
abstract class BaseCoffeeMachine(
    private val price: Double,
    private val color: String
) {
    //For abstract member, you don't need to define value
    //Remember - You can only use abstract keyword for members or functions inside an abstract class only
    //To define abstract member or function, your class has to be abstract class
    abstract val brand: String

    abstract fun makeCoffee(type: String): String

    init {
        println("BaseCoffeeMachine's init block")
    }

    //open - If this is open, you can override this function in chile class
    //not open - You can't override this function in child class
    open fun machineInfo(): String {
        return "Coffee Machine Details:\n" +
                "Price: $price\n" +
                "Color: $color\n"
    }
}

class CoffeeMachine(
    price: Double,
    color: String
) : BaseCoffeeMachine(price, color) {

    init {
        println("CoffeeMachine's init block")
    }

    override val brand: String
        get() = "Brand Y"

    override fun makeCoffee(type: String): String {
        //It's a simple coffee machine so it's take time to make coffee
        Thread.sleep(4000)
        return "Your $type is Ready ☕"
    }
}

class PremiumCoffeeMachine(
    price: Double,
    color: String
) : BaseCoffeeMachine(price, color) {

    init {
        println("PremiumCoffeeMachine's init block")
    }

    override val brand: String
        get() = "Brand Premium"

    override fun makeCoffee(type: String): String {
        return "Your $type is Ready ☕"
    }

    /*override fun machineInfo(): String {
        return super.machineInfo()
    }*/

    override fun machineInfo(): String {
        println("machine info from premiumCoffeeMachine class")
        return super.machineInfo()
    }
}