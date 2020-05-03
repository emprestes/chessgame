package chessgame.app.fx.util

import chessgame.app.fx.api.Controller
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.net.URL


class FXMLHelper {

    companion object {
        @Throws(Exception::class)
        fun createScene(stage: Stage?, viewTitle: String, view: String, vararg styles: String) =
                createScene(stage, viewTitle, getResource(view), getResources(*styles))

        @Throws(Exception::class)
        private fun createScene(stage: Stage?, viewTitle: String, view: URL, styles: Array<URL?>) =
                Scene(createView(stage, viewTitle, view, styles))

        @Throws(Exception::class)
        private fun <V : Parent> createView(stage: Stage?, viewTitle: String, view: URL, styles: Array<URL?>): V {
            val fxml = FXMLLoader(view)
            val root: V = fxml.load()
            val controller: Controller? = fxml.getController<Controller>()

            styles.forEach { style -> root.stylesheets.add(style?.toExternalForm()) }

            stage?.title = viewTitle

            controller?.stage = stage

            return root
        }

        private fun getResource(r: String): URL = FXMLHelper::class.java.getResource(r)

        private fun getResources(vararg r: String): Array<URL?> = r.map(FXMLHelper::class.java::getResource).toTypedArray()
    }
}