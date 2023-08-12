package kishorramani.kotlinfromscratch.jdelegatingproperty

import java.util.Locale
import kotlin.reflect.KProperty

//delegating property
class Student {
    //here set property is used more than one time, think about the more variable like this,
    //so we will delegating this responsibility to other object
    //for this delegation pattern is useful
    /*var firstName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().toUpperCase()
            }
        }

    var lastName: String? = null
        set(value) {
            if (value != null && value.length > 5) {
                field = value.trim().toUpperCase()
            }
        }*/

    //delegating property using by keyword
    //The syntax is: val/var <property name>: <Type> by <expression>
    //Here, set and get value of this property delegating to to the NameDelegate()'s setValue and getValue method
    var firstName: String? by NameDelegate()

    //delegating property using by keyword
    var lastName: String? by NameDelegate()

    //to print class by it's name, we have to create toString() method
    override fun toString(): String {
        return "$firstName $lastName"
    }
}

//in above class, there are repeating code and we can reduce by delegating property
//so here we create Delegation class
class NameDelegate {
    private var formattedValue: String? = null

    operator fun setValue(
        thisRef: Any?,              //calling object
        property: KProperty<*>,     //property - type is KProperty
        value: String?              //value
    ) {
        //println("$value value has been assigned to '${property.name}' property in $thisRef calling object.")
        if (value != null && value.length > 5) {
            formattedValue = value.trim().uppercase(Locale.getDefault())
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        //println("$thisRef calling object, thank you for delegating '${property.name}' property to me!")
        return formattedValue
    }
}

fun main() {
    val student = Student()
    student.firstName = "Kishor"
    student.lastName = "Ramani"
    println(student)        //output - KISHOR RAMANI

    student.firstName = "Kish"
    student.lastName = "Rama"
    println(student)        //output - KISHOR RAMANI - ask Belal Khan regarding this output in youtube comment
}