package kishorramani.kotlinfromscratch.tcollectionlistsetmap

//Collection: List, Set, Map
//Collection is used to store multiple object as a single unit
//Mainly three type of collection
/* *
+------+--------------+---------------------+
|      |  Immutable   |       Mutable       |
+------+--------------+---------------------+
| List | listOf<T>()  | mutableListOf<T>()  |
| Set  | setOf<T>()   | mutableSetOf<T>()   |
| Map  | mapOf<K,V>() | mutableMapOf<K,V>() |
+------+--------------+---------------------+
* */
//We can create either immutable or mutable collection
//immutable - it's means collection is read only, you are not allow to perform write any functionality
//mutable - You allow to read and write functionalities

fun main() {
    //List - it's ordered collection function
    //Immutable list
    println("---------------------------")
    println("========== list ===========")
    println("---------------------------")

    println("----- Immutable list ------")
    val names = listOf(1, "kishor", "kishor1", "kishor2", "kishor3")        //type of this list is defined at the declaration - it's contain String and int value
    println(names[1])   //access the item as an array
    println(names[3])   //access the item as an array
    //println(names[5])   //Index 5 out of bounds for length 4

    println("-------for--------")
    //you can get all item using loop
    for (name in names) {
        println(name)
    }
    println("------foreach---------")
    //you can get all item using loop
    names.forEach {
        println(it)
    }
    println("-------repeat--------")
    //you can get all item using loop
    repeat(names.size) {
        println(names[it])
    }

    //this list is immutable so you can't add new item
    //names.add("new value")

    //-------------------------------------------

    //Mutable list
    println("-------Mutable list--------")
    val names1 = mutableListOf("kishor0")
    println("---add kishor1, kishor2 item---")
    names1.add("kishor1")       //Here, you can add new element
    names1.add("kishor2")
    names1.forEach {
        println(it)
    }

    //You can add element at specific position like this
    println("---add Kishor7 item at position 3---")
    names1.add(3, "kishor7")        // Here mutable list size is 3 means last element's index is 2 and we added element at position 3 means last index
    names1.forEach {
        println(it)
    }

    //but keep in mind that index can't be exceed current length of list
    //if size is 4 and you are adding element at 6th place then it's give error (error - Index: 6, Size: 4)
    //if i add this item at index 6 then we get Index: 6, Size: 4 error, we can't add item at this location
    //names1.add(6, "kishor7")

    println("---add Ramani item at position 1---")
    names1.add(1, "Ramani")     //here, "Ramani" element is added at location 1, and other element after location 1 is moved towards right
    names1.forEach {
        println(it)
    }

    println("---add kishor5 item---")
    names1.add("kishor5")       //this element is added at the end of list
    names1.forEach {
        println(it)
    }

    println("---- add other type item ------")
    //names1.add(3)       //It's not here

    println("---remove kishor5 item---")
    names1.remove("kishor5")        //if you are trying to remove other item like "Ramani1" then it's not give error
    names1.forEach {
        println(it)
    }

    //You can also remove item like this
    //You have to give index
    names1.removeAt(2)

    //You can also remove all element from list
    println("---remove all item---")
    names1.removeAll(names1)
    names1.forEach {
        println(it)
    }

    //-------------------------------------------
    //set:
    //set can't contain duplicate value
    //You can't access with index value
    println("---------------------------")
    println("=========== Set ===========")
    println("---------------------------")

    println("-----immutable setof-------")
    val names2 = setOf(1, "kishor0", "kishor1", "kishor2", "kishor2")
    //foreach
    println("----foreach----")
    names2.forEach {
        println(it)
    }

    //for loop
    println("----for loop----")
    for (name in names2) {
        println(name)
    }

    //accessing set using index
    //println(names2[2])  //you can't access set via index

    //add item in set
    //names2.add        //you can't add item in immutable set

    //---------------------------------

    println("------ mutable setof ------")

    val names3 = mutableSetOf("kishor", "kishor1", "kishor2", "kishor3", "kishor3")     //duplicate item are ignored
    val tempNames = setOf("Ramani1", "Ramani2")

    for (item in names3) {
        println(item)
    }

    println("---add kishor4 item---")
    names3.add("kishor4")
    names3.forEach {
        println(it)
    }

    println("---add set of collection item---")
    names3.addAll(tempNames)       //add set of collection

    names3.forEach {
        println(it)
    }

    println("---remove kishor item---")
    names3.remove("kishor")
    names3.forEach {
        println(it)
    }

    println("---removeIf - names3 contain kishor3---")
    names3.removeIf {
        it.contains("kishor3")          //if this list is combination of int and string then removeIf is not working
    }
    names3.forEach {
        println(it)
    }

    //names3.add(2)     //while declaring the names3, if the item are mix type of String and Int then we can add here.

    //names3.removeAt     //This method is not found
    println("---remove all item---")
    names3.removeAll(names3)
    names3.forEach {
        println(it)
    }

    //----------------------------------
    //Map:
    //You have to define 2 type for map
    //You have to define pair as a element
    //You cannot have duplicate keys but you can have duplicate values
    println("---------------------------")
    println("=========== map ===========")
    println("---------------------------")

    println("--------immutable map------")
    val students = mapOf(7 to "kishor7", 8 to "kishor8", 9 to "kishor9", 11 to "kishor11", 7 to "Ramani", 14 to "Ramani14")        //duplicate item with keys are replacing the old value
    println(students[8])        //access value using key (pass the key instead of index)
    println("----foreach----")
    students.forEach { t, u ->
        println("key: $t, value: $u")
    }

    //students.add
    //students.remove       //not working because it's immutable
    //----------------------------------------
    println("------Mutable map------")
    val students1 = mutableMapOf(7 to "kishor7", 8 to "kishor8", 9 to "kishor9", 11 to "kishor11", 11 to "Ramani", 14 to 14)
    students1.forEach { t, u ->
        println("key: $t, value: $u")
    }

    println("---remove element which's key is 7---")
    students1.remove(7)     //Here, we have to add key in parameter, not index of map element
    students1.forEach { t, u ->
        println("$t and $u")
    }

    println("---add element with '0' key and 'kishor0' value---")
    students1[0] = "kishor0"
    students1.forEach { t, u ->
        println("$t and $u")
    }

    println("---put new element (5, kishor5)---")
    //put new value in students1
    students1.put(5, "kishor")      //same as students1[5] = "kishor5"
    for (item in students1.entries) {
        println(item)
    }

    println("---replace index 14's element to Ramani14 ---")
    students1[14] = "Ramani14"          //replace int value to string value at index 14'e element
    students1.forEach { t, u ->
        println("$t to $u")
    }
}