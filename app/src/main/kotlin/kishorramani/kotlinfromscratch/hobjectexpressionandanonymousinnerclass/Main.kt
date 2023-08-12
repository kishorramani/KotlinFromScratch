package kishorramani.kotlinfromscratch.hobjectexpressionandanonymousinnerclass

//Object Expression and Anonymous Inner Class
class App : DownloadListener {
    override fun onDownloadStarted() {
        println("Download started")
    }

    override fun onDownloadCompleted(file: String) {
        println("$file Downloaded")
    }

    override fun onProgressUpdate(progress: Int) {
        println("$progress% download")
    }
}

fun main() {
    val downloadListener = App()
    val downloader = Downloader()
    downloader.downloadListener = downloadListener

    downloader.downloadFile("FileName.mp3")

    //----------------------------------------------------------------------

    //object expression and anonymous inner class - we don't need to create new class here (App class)
    val downloader2 = Downloader()
    downloader2.downloadListener = object : DownloadListener {
        override fun onDownloadStarted() {
            println("Download started")
        }

        override fun onDownloadCompleted(file: String) {
            println("$file Downloaded")
        }

        override fun onProgressUpdate(progress: Int) {
            println("$progress% download")
        }
    }
}

interface DownloadListener {
    fun onDownloadStarted()
    fun onDownloadCompleted(file: String)
    fun onProgressUpdate(progress: Int)
}

class Downloader {
    var downloadListener: DownloadListener? = null

    fun downloadFile(file: String) {
        downloadListener?.onDownloadStarted()

        for (i in 1..10) {
            downloadListener?.onProgressUpdate(i * 10)
            Thread.sleep(600)
        }
        downloadListener?.onDownloadCompleted(file)
    }
}