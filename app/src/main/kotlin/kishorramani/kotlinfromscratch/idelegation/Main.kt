package kishorramani.kotlinfromscratch.idelegation

//Delegation - It's object orientated design pattern, kotlin supports it natively
//Delegation means delegating the responsibility to other objects
//Controls the allocation of power/authority from an instance to another for any object
//It's good alternative to implementation inheritance

/*class MediaFile(
    private val downloader: Downloader,
    private val player: Player
) : Downloader, Player {
    //Here, we are delegating the responsibility to downloader and player object
    //this things kotlin support natively
    //remove this code body and write "Downloader by downloader, Player by player"
    //here just by keyword is used
    override fun download() {
        downloader.download()
    }

    override fun play() {
        player.play()
    }
}*/

//above code is boilerplate code, we can write code like below
//kotlin support delegation pattern using this "by" keyword natively
//We do not need to write all above code
class MediaFile(
    private val downloader: Downloader,
    private val player: Player
) : Downloader by downloader, Player by player

//You can also override the method of interface, If you can't override the method then FileDownloader and FilePlayer's method is called
class MediaFile1(
    private val downloader: Downloader,
    private val player: Player
) : Downloader by downloader, Player by player {
    /*override val message: String
        get() = "Message from derived"*/

    //You can also write below line like above
    override val message = "Message from derived"

    override fun download() {
        println("Download from derived class")
    }

    override fun play() {
        println("Play from derived class")
    }
}

class FileDownloader(private val file: String) : Downloader {
    override val message = "BaseImpl: x = $file"

    override fun download() {
        println("$file downloaded")
    }
}

class FilePlayer(private val file: String) : Player {
    override fun play() {
        println("$file playing")
    }
}

fun main() {
    val file: String = "File.mkv"

    /*val fileDownloader = FileDownloader(file)
    fileDownloader.download()

    val filePlayer = FilePlayer(file)
    filePlayer.play()*/

    //val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file))
    val mediaFile = MediaFile1(FileDownloader(file), FilePlayer(file))
    mediaFile.download()
    mediaFile.play()
    println(mediaFile.message)

    println("----------------------")

    val fileDownloader = FileDownloader(file)
    fileDownloader.download()
    println(fileDownloader.message)
}

//-------------------------------------------

interface Downloader {
    val message: String
    fun download()
}

//-------------------------------------------

interface Player {
    fun play()
}