package kishorramani.kotlinfromscratch.qsealedclass

//Sealed class
//Whenever we want to define "limited set of classes", then we can use sealed class

//When we fetch some data form network - network call has mainly in 2 situation: success or failure [this is fix number of class]

//Define sealed class is like define abstract class

//It's use with data class - : Data() use while using data class

//Sealed class cannot instantiated directly, but we will instantiated other class that are extended or inherited sealed class
sealed class Data {
    //Create other classes which represent state
    //Inherit sealed class Data(), you cannot inherit sealed class Data from other file Main.kt
    data class Success(val data: String) : Data()

    //Inherit sealed class Data(), you cannot inherit sealed class Data from other file main.kt
    data class Error(val error: String) : Data()

    //define one more thing - object loading, Now compiler knows the all the possible condition (success, error, loading) for this sealed class, no need to write else condition
    object Loading : Data()
}

fun getData(): Data {
    return Data.Success((100..1000).random().toString())
//    return Data.Error((100..1000).random().toString())
//    return Data.Loading
}

//Inherit sealed class Data(), you cannot inherit sealed class Data from other file main.kt
//data class Error(val error: String) : Data()

fun main() {
    val data = getData()
    when (data) {
        is Data.Success -> {
            println("Success: $data")
        }
        is Data.Error -> {
            println("Error: $data")
        }
        Data.Loading -> {
            println("Loading: $data")
        }
    }
    //Here, we don't have to write else block
    //Sealed class use for limited set of values
}