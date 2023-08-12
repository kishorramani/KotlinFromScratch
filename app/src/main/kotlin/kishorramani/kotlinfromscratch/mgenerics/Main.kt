package kishorramani.kotlinfromscratch.mgenerics

//Generics:
//Below function is only use for Int values and array<Int>
class ArrayUtil(private val array: Array<Int>) {
    //found the element and it's index from an given array
    fun findElement(element: Int, foundElement: (index: Int, element: Int?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                foundElement(i, array[i])
                return
            }
        }
        foundElement(-1, null)
        return
    }
}

//We will define typed 'T'
//We have to define type when creating instance of a class
//You can define any number of types likes ArrayUtils3<T, X, Y>
class ArrayUtil1<T>(private val array: Array<T>) {
    fun findElement(element: T, foundElement: (index: Int, element: T?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                foundElement(i, array[i])
                return
            }
        }
        foundElement(-1, null)
        return
    }
}

//You can also define function like below
fun <T> findElement(array: Array<T>, element: T, foundElement: (index: Int, element: T?) -> Unit) {
    for (i in array.indices) {
        if (array[i] == element) {
            foundElement(i, array[i])
            return
        }
    }
    foundElement(-1, null)
    return
}

//here, we define 2 generics type
//x can be anything and y can be anything
fun <x, y> justForTesting(param1: x, param2: y) {
    println("param1: $param1, param2: $param2")
}

fun main() {
    val arrayUtil = ArrayUtil(arrayOf(1, 2, 3, 4, 5))
    arrayUtil.findElement(3) { index, element ->
        println("index: $index")
        println("Element: $element")
    }
    //above code works only for int array type, this is not work for other data types
    //To fix this problem, we have generics

    //------------------------------------

    val arrayUtil1 = ArrayUtil1<Int>(arrayOf(1, 2, 3, 4, 5, 6))
    val arrayUtil2 = ArrayUtil1<String>(arrayOf("1", "2", "3", "4", "5", "6"))

    println("------")
    arrayUtil1.findElement(4) { index, element ->
        println("index: $index")
        println("element: $element")
    }

    println("------")
    arrayUtil2.findElement("2") { index, element ->
        println("index: $index")
        println("element: $element")
    }

    //--------------------------------------
    println("------")
    findElement(arrayOf(1, 2, 3, 4, 5, 6), 6) { index, element ->
        println("index: $index")
        println("element: $element")
    }

    //--------------------------------------
    println("------")
    justForTesting("kishor", 27)
}