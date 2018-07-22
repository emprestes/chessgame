package chessgame.domain.model

import chessgame.domain.PieceFactory.Companion.createBishop
import chessgame.domain.PieceFactory.Companion.createKnight
import chessgame.domain.PieceFactory.Companion.createQueen
import chessgame.domain.PieceFactory.Companion.createRook
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.BLACK
import chessgame.domain.model.PieceColor.WHITE
import org.junit.Assert.assertTrue
import org.junit.Test

class CreatePieceByPromotionTest {

    @Test
    fun createQueenByPromotionTest() {
        val pawn = Pawn(Board(), WHITE, H8)
        val piece = createQueen(pawn)

        assertTrue(piece is Queen)
        assertTrue(pawn.board === piece.board)
        assertTrue(pawn.color === piece.color)
        assertTrue(pawn.position === piece.position)
    }

    @Test
    fun createBishopByPromotionTest() {
        val pawn = Pawn(Board(), BLACK, A7)
        val piece = createBishop(pawn)

        assertTrue(piece is Bishop)
        assertTrue(pawn.board === piece.board)
        assertTrue(pawn.color === piece.color)
        assertTrue(pawn.position === piece.position)
    }

    @Test
    fun createKnightByPromotionTest() {
        val pawn = Pawn(Board(), WHITE, H6)
        val piece = createKnight(pawn)

        assertTrue(piece is Knight)
        assertTrue(pawn.board === piece.board)
        assertTrue(pawn.color === piece.color)
        assertTrue(pawn.position === piece.position)
    }

    @Test
    fun createRookByPromotionTest() {
        val pawn = Pawn(Board(), BLACK, A5)
        val piece = createRook(pawn)

        assertTrue(piece is Rook)
        assertTrue(pawn.board === piece.board)
        assertTrue(pawn.color === piece.color)
        assertTrue(pawn.position === piece.position)
    }
}