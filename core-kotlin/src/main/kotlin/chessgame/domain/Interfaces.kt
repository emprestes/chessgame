package chessgame.domain

import chessgame.domain.model.Board
import chessgame.domain.model.BoardPosition
import chessgame.domain.model.PieceColor
import java.io.Serializable

interface Piece : Serializable {

    val board: Board
    val color: PieceColor
    var position: BoardPosition

    fun getAvailablePositions(): Set<BoardPosition>
}

interface Player : Serializable {
    fun add(piece: Piece): Player
}

interface SpecialMovement : Serializable

interface Promotion : Serializable