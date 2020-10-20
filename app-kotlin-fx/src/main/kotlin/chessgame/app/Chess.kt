package chessgame.app

import chessgame.app.fx.controller.BoardController.Companion.VIEW_TITLE
import chessgame.app.fx.controller.BoardController.Companion.VIEW_URL
import chessgame.app.fx.view.FXMLHelper.Companion.createScene
import javafx.application.Application
import javafx.application.Application.launch
import javafx.stage.Stage

class Chess : Application() {

    override fun start(primaryStage: Stage?) {
        primaryStage?.let {
            it.scene = createScene(it, VIEW_TITLE, VIEW_URL)
            it.isResizable = false
            it.show()
        }
    }
}

fun main(args: Array<String>) {
    launch(Chess::class.java, *args)
}
