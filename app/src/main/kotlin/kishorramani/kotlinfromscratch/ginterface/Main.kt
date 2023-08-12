package kishorramani.kotlinfromscratch.ginterface

//Interface
//Interface - Similar to abstract class
//There is difference between interface and abstract class
//Interface contain abstract members and abstract function, it also can contain function with implementation

//What's the need of interface - it's exactly like as abstract class
fun main() {
    val audioDownloader = Audio("Audio1.mp3")
    val videoDownloader = Video("Video1.mkv")

    audioDownloader.download()
    audioDownloader.downloaderInfo()
    audioDownloader.play()
    audioDownloader.playerInfo()

    println("--------------------")

    videoDownloader.download()
    videoDownloader.downloaderInfo()
    videoDownloader.play()
    videoDownloader.playerInfo()
}

//---------------------------------------------------

//In abstract class you can have init block and Constructor
//In interface - You cannot have init block and Constructor
interface Downloader {
    //There is no problem with function with function body
    fun downloaderInfo() {
        println("Downloader V1")
    }

    //abstract fun download() - By default all function without function body in interface class are abstract, so it's redundant
    //So abstract keyword is optional
    fun download()
}

//---------------------------------------------------

//In abstract class you can have init block and Constructor
//In interface - You cannot have init block and Constructor
interface Player {
    fun playerInfo() {
        println("Player V1")
    }

    //abstract fun play() - By default all function without function body in interface class are abstract, so it's redundant
    //So abstract keyword is optional
    fun play()
}

//---------------------------------------------------

class Audio(private val name: String) : Downloader, Player {
    override fun download() {
        println("Downloading Audio $name")
    }

    override fun play() {
        println("Playing Audio $name")
    }
}

//---------------------------------------------------

//Whenever we extend interface class, we don't need (), because there is no constructor
//Whenever we extend abstract class, we need () parenthesis after class name, because there is default constructor or secondary constructor

//If we extend another abstract class then it's give error like - Only one class may appear in a supertype list
//Kotlin does not support multiple inheritance - To solve the problem interface comes into picture

//You can also extend any class - Example ABS class but there is already one AbstractSample1 so "you can't extend multiple class"
/*class Video1(private val name: String) : ABS(), Downloader, Player, AbstractSample1(200.0, "sample") {}*/

class Video(private val name: String) : Downloader, Player, AbstractSample1(200.0, "sample Color")/*, AbstractSample2(100.0, "RED")*/ /*, ABS()*/ {
    override fun download() {
        println("Downloading Video $name")
    }

    override fun play() {
        println("Playing Video $name")
    }

    //Abstract class's member and function
    override val brand: String
        get() = TODO("Not yet implemented")

    //Abstract class's member and function
    override fun makeCoffee(type: String): String {
        TODO("Not yet implemented")
    }
}

open class ABS {

}

//----------------------------------------------------

abstract class AbstractSample1(
    private val price: Double,
    private val color: String
) {
    abstract val brand: String

    abstract fun makeCoffee(type: String): String

    open fun machineInfo(): String {
        return "Coffee Machine Details:\n" +
                "Price: $price\n" +
                "Color: $color\n"
    }

    init {
        println("This is init block from AbstractSample1")
    }
}

//----------------------------------------------------

abstract class AbstractSample2(
    private val price: Double,
    private val color: String
) {
    abstract val brand: String

    abstract fun makeCoffee(type: String): String

    open fun machineInfo(): String {
        return "Coffee Machine Details:\n" +
                "Price: $price\n" +
                "Color: $color\n"
    }
}
