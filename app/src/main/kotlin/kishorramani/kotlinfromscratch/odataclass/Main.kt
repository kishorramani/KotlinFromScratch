package kishorramani.kotlinfromscratch.odataclass

//data class, ComponentN property
//we don't have to write class for pojo class in java
//We don't have to write constructor, toString(), hashCode(), equals() function
//data class cannot use with open, abstract, inner keyword

//You can inherit another class to your data class (Write : after class constructor and you will get suggestion for inheritance)
//But you cannot inherit data class to your data class
data class Person(
    val id: Int,
    val fname: String,
    val lname: String,
    val country: String
) {
    //This function body is optional
    //All below override is also optional
    /*override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }*/

    //You can define any function in data class's body
    fun getName(): String {
        return "$fname $lname"
    }

    //You can also write above function like below
    fun getName1() = "$fname $lname"
}

fun main() {
    val person = Person(1, "Kishor", "Ramani", "India")
    println(person.toString())
    println(person.hashCode())

    val person1 = Person(1, "Kishor", "Patel", "India")
    println(person == person1)
    println(person1.hashCode())

    //get custom property in function
    println(person.getName())

    println("---------------")

    //ComponentN property
    //It's generate component function according to number of property in person class
    println(person.component1())    //id
    println(person.component2())    //fname
    println(person.component3())    //lname
    println(person.component4())    //country

    println("--------------")

    val (id, fname, lname, country) = person     //destructuring declaration
    println(id)
    println(fname)
    println(lname)
    println(country)
}