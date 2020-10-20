package chessgame.app.fx.view

import javafx.geometry.Pos.CENTER
import javafx.scene.control.Label
import javafx.scene.text.Font.font

class PieceView: Label() {
    companion object {
        fun of(symbol: String): PieceView {
            val view = PieceView()

            with (view) {
                isNeedsLayout = true
                layoutX = 1.0
                layoutY = 2.0
                prefWidth = 60.0
                prefHeight = 60.0
                alignment = CENTER
                font = font(48.0)
                isMnemonicParsing = true
                isWrapText = true
                text = symbol
            }

            return view
        }
    }
}