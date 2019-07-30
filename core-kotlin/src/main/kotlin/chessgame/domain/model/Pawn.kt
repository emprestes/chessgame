package chessgame.domain.model

import chessgame.domain.Promotion
import chessgame.domain.SpecialMovement
import chessgame.domain.model.PieceColor.BLACK
import chessgame.domain.model.PieceColor.WHITE
import java.util.*
import java.util.function.Function
import kotlin.collections.LinkedHashSet

class Pawn(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color), SpecialMovement, Promotion {

    companion object {
        private val MAP: Map<PieceColor, Function<BoardPosition?, BoardPosition>> = mapOf(
                WHITE to Function { it!!.nextRow() },
                BLACK to Function { it!!.previousRow() })
    }

    override fun getAvailablePositions(): Set<BoardPosition> {
        val availablePositions = LinkedHashSet<BoardPosition>()

        for ((color, moveItFunction) in MAP) {
            Optional.of(this)
                    .filter { color == it.color }
                    .map { it.position }
                    .map(moveItFunction)
                    .filter { isEmptyBoardPosition(it) }
                    .filter { availablePositions.add(it) }
                    .filter { isInitialPosition() }
                    .map(moveItFunction)
                    .filter { isEmptyBoardPosition(it) }
                    .filter { availablePositions.add(it) }
        }

        return availablePositions
    }
}