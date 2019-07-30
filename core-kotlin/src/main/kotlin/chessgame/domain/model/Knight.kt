package chessgame.domain.model

import java.util.Optional.of
import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Collectors.toSet

class Knight(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color) {

    override fun getAvailablePositions(): Set<BoardPosition> = listOf(
            getPosition(position!!.nextColumn(), Function { it.nextRow() }, Predicate { it.nonLastRow() }),
            getPosition(position!!.nextColumn(), Function { it.previousRow() }, Predicate { it.nonFirstRow() }),
            getPosition(position!!.nextRow(), Function { it.nextColumn() }, Predicate { it.nonLastColumn() }),
            getPosition(position!!.nextRow(), Function { it.previousColumn() }, Predicate { it.nonFirstColumn() }),
            getPosition(position!!.previousRow(), Function { it.nextColumn() }, Predicate { it.nonLastColumn() }),
            getPosition(position!!.previousRow(), Function { it.previousColumn() }, Predicate { it.nonFirstColumn() }),
            getPosition(position!!.previousColumn(), Function { it.nextRow() }, Predicate { it.nonLastRow() }),
            getPosition(position!!.previousColumn(), Function { it.previousRow() }, Predicate { it.nonFirstRow() }))
            .stream()
            .filter { position!!.nonEquals(it) }
            .filter { isEmptyBoardPosition(it) }
            .collect(toSet())

    private fun getPosition(position: BoardPosition,
                            moveItFunction: Function<BoardPosition, BoardPosition>,
                            readyToMovePredicate: Predicate<BoardPosition>): BoardPosition =
            getPosition(position, 2, moveItFunction, readyToMovePredicate)

    private fun getPosition(actualPosition: BoardPosition, move: Int,
                            moveItFunction: Function<BoardPosition, BoardPosition>,
                            readyToMovePredicate: Predicate<BoardPosition>): BoardPosition = of(
            of(actualPosition)
                    .filter { position!!.nonEquals(it) }
                    .filter(readyToMovePredicate)
                    .filter { move > 0 }
                    .map(moveItFunction)
                    .map { getPosition(it, move - 1, moveItFunction, readyToMovePredicate) }
                    .orElse(actualPosition))
            .filter { actualPosition.nonEquals(it) || move == 0 }
            .orElse(position)
}