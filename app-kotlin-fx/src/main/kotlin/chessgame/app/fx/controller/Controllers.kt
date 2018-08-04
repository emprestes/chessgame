package chessgame.app.fx.controller

import chessgame.app.fx.Controller
import javafx.fxml.FXML
import javafx.scene.layout.GridPane
import javafx.stage.Stage

abstract class AbstractController : Controller {

    override var stage: Stage? = null

    companion object {
        const val VIEW_PACKAGE = "/chessgame/app/fx/view/%s.fxml"
    }
}

class BoardController : AbstractController() {

    @FXML
    private var boardView: GridPane? = null

    companion object {

        const val VIEW_TITLE = "Chess Game"

        val VIEW_URL = String.format(VIEW_PACKAGE, "BoardView")
    }
}