package chessgame.domain

import chessgame.domain.model.Board
import chessgame.domain.model.BoardPosition
import chessgame.domain.model.PieceColor
import java.io.Serializable

interface Piece : Serializable, Comparable<Piece> {

    val board: Board
    val color: PieceColor
    var position: BoardPosition?

    fun getAvailablePositions(): Set<BoardPosition>

    fun moveTo(position: BoardPosition): Piece

    fun moveTo(position: String): Piece {
        return moveTo(BoardPosition.valueOf(position))
    }

    override fun compareTo(other: Piece) = position!!.compareTo(other.position!!)
}

interface Player : Serializable {
    fun add(piece: Piece): Player
}

interface SpecialMovement : Serializable

interface Promotion : Serializable