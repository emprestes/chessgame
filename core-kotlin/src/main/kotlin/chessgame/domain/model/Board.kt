package chessgame.domain.model

import chessgame.domain.BoardException
import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createBlackBishop
import chessgame.domain.PieceFactory.Companion.createBlackKing
import chessgame.domain.PieceFactory.Companion.createBlackKnight
import chessgame.domain.PieceFactory.Companion.createBlackPawn
import chessgame.domain.PieceFactory.Companion.createBlackQueen
import chessgame.domain.PieceFactory.Companion.createBlackRook
import chessgame.domain.PieceFactory.Companion.createWhiteBishop
import chessgame.domain.PieceFactory.Companion.createWhiteKing
import chessgame.domain.PieceFactory.Companion.createWhiteKnight
import chessgame.domain.PieceFactory.Companion.createWhitePawn
import chessgame.domain.PieceFactory.Companion.createWhiteQueen
import chessgame.domain.PieceFactory.Companion.createWhiteRook
import chessgame.domain.Player
import chessgame.domain.model.BoardPosition.*
import java.util.*

enum class BoardColor {
    DARK, LIGHT
}

enum class BoardPosition {
    A1, A2, A3, A4, A5, A6, A7, A8,
    B1, B2, B3, B4, B5, B6, B7, B8,
    C1, C2, C3, C4, C5, C6, C7, C8,
    D1, D2, D3, D4, D5, D6, D7, D8,
    E1, E2, E3, E4, E5, E6, E7, E8,
    F1, F2, F3, F4, F5, F6, F7, F8,
    G1, G2, G3, G4, G5, G6, G7, G8,
    H1, H2, H3, H4, H5, H6, H7, H8
}

class Board : TreeMap<BoardPosition, Piece?>() {

    private val whitePlayer = HumanPlayer()
    private val blackPlayer = HumanPlayer()

    fun init(): Board {
        BoardPosition.values().forEach { position ->
            when (position) {
                A1, H1 -> put(whitePlayer, createWhiteRook(this, position))
                B1, G1 -> put(whitePlayer, createWhiteKnight(this, position))
                C1, F1 -> put(whitePlayer, createWhiteBishop(this, position))
                D1 -> put(whitePlayer, createWhiteQueen(this))
                E1 -> put(whitePlayer, createWhiteKing(this))
                A2, B2, C2, D2, E2, F2, G2, H2 -> put(whitePlayer, createWhitePawn(this, position))
                A7, B7, C7, D7, E7, F7, G7, H7 -> put(blackPlayer, createBlackPawn(this, position))
                A8, H8 -> put(blackPlayer, createBlackRook(this, position))
                B8, G8 -> put(blackPlayer, createBlackKnight(this, position))
                C8, F8 -> put(blackPlayer, createBlackBishop(this, position))
                D8 -> put(blackPlayer, createBlackQueen(this))
                E8 -> put(blackPlayer, createBlackKing(this))
                else -> put(position, null)
            }
        }

        return this
    }

    private fun put(player: Player, piece: Piece?): Piece? {
        piece?.let { player.add(piece) }
        return put(piece!!.position, piece)
    }

    override fun put(key: BoardPosition, value: Piece?): Piece? {
        if (size <= BoardPosition.values().size) {
            return super.put(key, value)
        }

        throw BoardException("Board created! More positions aren't allowed!")
    }

}
