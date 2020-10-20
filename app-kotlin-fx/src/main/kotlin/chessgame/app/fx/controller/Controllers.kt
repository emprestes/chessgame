package chessgame.app.fx.controller

import chessgame.app.fx.Controller
import chessgame.app.fx.view.PieceView
import chessgame.facade.BoardFacade
import chessgame.facade.mock.MockBoardFacade
import javafx.fxml.FXML
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage

abstract class AbstractController : Controller {

    override var stage: Stage? = null

    companion object {
        const val VIEW_PACKAGE = "/chessgame/app/fx/view/%s.fxml"
    }
}

class BoardController : AbstractController() {

    private val facade: BoardFacade = MockBoardFacade()

    @FXML
    lateinit var boardView: GridPane

    @FXML
    fun initialize() {
        initialize(facade.initBlackPieces())
        initialize(facade.initWhitePieces())
    }

    private fun initialize(pieces: Map<String, String>) =
        with(boardView) {
            with(pieces) {
                forEach { (key, value) -> children.stream()
                        .filter { view -> key == view.id }
                        .map { view -> view as Pane }
                        .map { pane -> pane.children }
                        .forEach { view -> view.add(PieceView.of(value)) }
                }
            }
        }

    companion object {
        const val VIEW_TITLE = "Chess Game"
        val VIEW_URL = String.format(VIEW_PACKAGE, "BoardView")
    }
}
