import java.io.File
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileNameExtensionFilter

fun main(args: Array<String>) {
    Main(args)
}

class Main(args: Array<String>) {
    init {
        val path = if (args.isEmpty()) showGUI() else args[0]
        if (!File(path).canRead()) throw Exception("파일을 읽을 수 없습니다.")
        if (!path.lowercase().endsWith(".otl")) throw Exception("확장자를 확인해주세요.")


    }

    private fun showGUI(): String {
        val frame = JFrame()
        val extensions = arrayOf("otl")
        val chooser = JFileChooser()
        val filter = FileNameExtensionFilter(".otl", *extensions)

        frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        chooser.fileFilter = filter
        val open = chooser.showOpenDialog(frame.parent)
        return if (open == JFileChooser.OPEN_DIALOG)
            chooser.selectedFile.path
        else throw Exception("파일이 존재하지 않습니다.")
    }

    private fun pause() {
        try {
            println("\n=================================")
            println("종료 : Enter")
            System.`in`.read()
        } catch (ignored: java.lang.Exception) { }
    }
}