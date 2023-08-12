package kishorramani.kotlinfromscratch.kstandarddelegation

import kotlin.properties.Delegates

//Standard Delegates - by lazy, by observable [Delegates.observable], by vetoable [Delegates.vetoable]

//Kotlin standard library has some pre define delegates
//You don't need to create it
//Here, we will use lazy keyword
class StudentHeavy {
    init {
        println("StudentHeavy class Initialized")
    }
}

class Student {
    init {
        println("Student class Initialized")
    }

    //val studentHeavy = StudentHeavy()     //read below comment

    //We don't want that studentHeavy class initialized,
    //We want this instance to load lazy, that means we will initializing instance when needed
    //it's initialized when we will access that
    val studentHeavy by lazy {
        StudentHeavy()
    }

    //-------------------------------------------------

    //Whenever you want to observe the changes in variable then you can use observable delegated
    var marks: Int by Delegates.observable(50) { property, oldValue, newValue ->
        println("oldValue: $oldValue")
        println("newValue: $newValue")
    }

    //-------------------------------------------------
    //When we want to intercept the assignment, we can use the Delegated.vetoable delegates
    var age: Int by Delegates.vetoable(14) { property, oldValue, newValue ->
        println("oldValue: $oldValue")
        println("newValue: $newValue")
        newValue >= 14      //Whenever the newValue is grater then 14 then and only then it's assign new value to age otherwise it's return old value
    }
}

fun main() {
    //create object of student class
    //whenever we are create instance of student class, StudentHeavy class initialized too,
    //We don't want that studentHeavy class initialized
    val student = Student()

    //-------------------------------------------------
    println("-----------------------")

    student.studentHeavy    //this time, StudentHeavy initialized and init block will run one time

    student.studentHeavy
    student.studentHeavy    //if we are access StudentHeavy more time, then init block is not print more time

    //-------------------------------------------------
    println("-----------------------")

    //Whenever you want to observe the changes in variable then you can use observable delegated
    student.marks = 70  //output - oldValue: 50 newValue: 70
    student.marks = 94  //output - oldValue: 70 newValue: 94

    //-------------------------------------------------
    println("-----------------------")

    student.age = 13        //output - oldValue: 14 newValue: 13
    println("age: ${student.age}")    //14

    student.age = 12        //output - oldValue: 14 newValue: 12
    println("age: ${student.age}")    //14

    student.age = 15        //output - oldValue: 14 newValue: 15
    println("age: ${student.age}")    //15

    student.age = 18        //output - oldValue: 15 newValue: 18
    println("age: ${student.age}")    //18

    student.age = 12        //output - oldValue: 18 newValue: 12
    println("age: ${student.age}")   //18
}