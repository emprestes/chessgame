package chessgame.app.swing.controller

import chessgame.app.swing.Controller
import chessgame.app.swing.view.BoardView
import chessgame.facade.BoardFacade
import chessgame.facade.mock.MockBoardFacade
import java.awt.Dimension

class BoardController(
        override val view: BoardView = BoardView(COLS_LABEL, ROWS_LABEL),
        override val size: Dimension= Dimension(500, 500),
        override val title: String = "Chess Game",
        override val labelWest: Array<String> = ROWS_LABEL,
        override val labelEast: Array<String> = ROWS_LABEL,
        override val labelNorth: Array<String> = COLS_LABEL,
        override val labelSouth: Array<String> = COLS_LABEL
) : Controller {

    private val facade: BoardFacade = MockBoardFacade()

    override fun initMatch() {
        with(facade) {
            initPieces(initBlackPieces())
            initPieces(initWhitePieces())
        }
    }

    private fun initPieces(pieces: Map<String, String>) {
        pieces.forEach { (pos, piece) -> view.add(pos, piece) }
    }

    companion object {
        private val COLS_LABEL = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
        private val ROWS_LABEL = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    }
}
