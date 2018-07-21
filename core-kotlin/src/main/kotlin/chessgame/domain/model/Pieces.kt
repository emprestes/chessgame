package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.Promotion
import chessgame.domain.SpecialMovement
import java.util.*

enum class PieceColor {
    BLACK, WHITE
}

abstract class AbstractPiece(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : Piece {

    override fun getAvailablePositions(): Set<BoardPosition> = Collections.emptySet()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractPiece) return false

        if (board != other.board) return false
        if (color != other.color) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = board.hashCode()

        result = 31 * result + color.hashCode()
        result = 31 * result + position.hashCode()

        return result
    }

    override fun toString() = "${this.javaClass.simpleName} (color=$color, position=$position)"
}

class Bishop(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position)

class King(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position), SpecialMovement

class Knight(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position)

class Pawn(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position), SpecialMovement, Promotion

class Queen(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position)

class Rook(
        override val board: Board,
        override val color: PieceColor,
        override var position: BoardPosition) : AbstractPiece(board, color, position)
