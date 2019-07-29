package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.Promotion
import chessgame.domain.SpecialMovement
import java.util.*
import java.util.Objects.isNull
import java.util.function.Function
import kotlin.collections.LinkedHashSet

enum class PieceColor {
    BLACK, WHITE
}

abstract class AbstractPiece(
        override val board: Board,
        override val color: PieceColor) : Piece {

    private var initialPosition: BoardPosition? = null

    override var position: BoardPosition? = null

    override fun getAvailablePositions(): Set<BoardPosition> = Collections.emptySet()

    private fun collectDiagonalLeft(position: BoardPosition?): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        collectDiagonalLeftUp(position, availablePositions)
        collectDiagonalLeftDowns(position, availablePositions)

        return availablePositions
    }

    private fun collectDiagonalLeftUp(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.diagonalLeftUp() })
    }

    private fun collectDiagonalLeftDowns(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.diagonalLeftDown() })
    }

    private fun collectDiagonalRight(position: BoardPosition?): Set<BoardPosition> {
        val availablePositions = LinkedHashSet<BoardPosition>()

        collectDiagonalRightUp(position, availablePositions)
        collectDiagonalRightDown(position, availablePositions)

        return availablePositions
    }

    private fun collectDiagonalRightUp(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.diagonalRightUp() })
    }

    private fun collectDiagonalRightDown(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.diagonalRightDown() })
    }

    private fun collectPreviousColumns(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.previousColumn() })
    }

    private fun collectNextColumns(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.nextColumn() })
    }

    private fun collectPreviousRows(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.previousRow() })
    }

    private fun collectNextRows(position: BoardPosition?, availablePositions: MutableSet<BoardPosition>) {
        collect(position, availablePositions, Function { it.nextRow() })
    }

    private fun collect(position: BoardPosition?,
                        availablePositions: MutableSet<BoardPosition>,
                        updatePosition: Function<BoardPosition, BoardPosition>) {
        Optional.ofNullable(position)
                .map(updatePosition)
                .filter { position!! != it }
                .filter { isEmptyBoardPosition(it) }
                .ifPresent {
                    with(availablePositions) {
                        add(it)
                        collect(it, this, updatePosition)
                    }
                }
    }

    fun collectDiagonals(position: BoardPosition?): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        availablePositions.addAll(collectDiagonalLeft(position))
        availablePositions.addAll(collectDiagonalRight(position))

        return availablePositions
    }

    fun collectColumns(position: BoardPosition?): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        collectPreviousColumns(position, availablePositions)
        collectNextColumns(position, availablePositions)

        return availablePositions
    }

    fun collectRows(position: BoardPosition?): Set<BoardPosition> {
        val availablePositions = mutableSetOf<BoardPosition>()

        collectPreviousRows(position, availablePositions)
        collectNextRows(position, availablePositions)

        return availablePositions
    }

    override fun moveTo(position: BoardPosition): Piece {
        Optional.of(this)
                .filter { piece -> isNull(piece.position) }
                .ifPresent {
                    with(it) {
                        this.initialPosition = position
                        this.position = position
                        board[position] = this
                    }
                }

        getAvailablePositions().stream()
                .filter { position == it }
                .findFirst()
                .ifPresent { availablePosition -> board[availablePosition] = this }

        return this
    }

    fun isEmptyBoardPosition(position: BoardPosition): Boolean {
        return isNull(board[position])
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractPiece) return false

        if (color != other.color) return false
        if (initialPosition != other.initialPosition) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = color.hashCode()
        result = 31 * result + (initialPosition?.hashCode() ?: 0)
        result = 31 * result + (position?.hashCode() ?: 0)
        return result
    }

    override fun toString() = "$color ${this.javaClass.simpleName} @ $position"
}

class Knight(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color)

class Pawn(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color), SpecialMovement, Promotion

class Rook(
        override val board: Board,
        override val color: PieceColor) : AbstractPiece(board, color)
