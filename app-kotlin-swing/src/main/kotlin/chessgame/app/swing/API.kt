package chessgame.app.swing

import java.awt.Dimension
import java.awt.LayoutManager
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants.EXIT_ON_CLOSE


abstract class Application {

    companion object {
        fun launch(classs: Class<out Application>) {
            SwingUtilities.invokeLater {
                try {
                    val view = JFrame()
                    val constructor = classs.getConstructor()
                    val app = constructor.newInstance()
                    app.start(view)
                    view.setLocationRelativeTo(null)
                    view.isResizable = false
                    view.defaultCloseOperation = EXIT_ON_CLOSE
                } catch (cause: Exception) {
                    throw RuntimeException(cause)
                }
            }
        }
    }

    @Throws(Exception::class)
    abstract fun start(view: JFrame)
}

interface Controller {

    val view: View
    val title: String
    val size: Dimension
    val labelWest: Array<String>
    val labelEast: Array<String>
    val labelNorth: Array<String>
    val labelSouth: Array<String>

    fun initMatch()
}

abstract class View(layout: LayoutManager): JPanel(layout)
