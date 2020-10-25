package chessgame.app

import chessgame.app.swing.Application
import chessgame.app.swing.Application.Companion.launch
import chessgame.app.swing.controller.BoardController
import chessgame.app.swing.view.LabelView.Companion.createCols
import chessgame.app.swing.view.LabelView.Companion.createRows
import java.awt.BorderLayout.*
import javax.swing.JFrame

class Chess: Application() {

    override fun start(view: JFrame) =
        with(view) {
            with(BoardController()) {
                add(createRows(labelWest), WEST)
                add(createRows(labelEast), EAST)
                add(this.view, CENTER)
                add(createCols(labelNorth), NORTH)
                add(createCols(labelSouth), SOUTH)

                initMatch()

                view.title = title
                view.size = size
            }

            isVisible = true
        }
}

fun main() {
    launch(Chess::class.java)
}