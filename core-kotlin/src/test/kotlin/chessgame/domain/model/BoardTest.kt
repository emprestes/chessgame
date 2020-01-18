package chessgame.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class BoardTest {

    val board = Board().start()

    @Test
    fun initializationTest() = assertEquals(64, board.size)

    @Test
    fun initializationEmptyBlocksTest() = assertEquals(32, board.filter { (_, piece) -> piece === null }.size)

    @Test
    fun initializationPieceBlockTest() = assertEquals(32, board.filter { (_, piece) -> piece != null }.size)

    @Test
    fun initializationKingBlockTest() = assertEquals(2, board.filter { (_, piece) -> piece is King }.size)

    @Test
    fun initializationQueenBlockTest() = assertEquals(2, board.filter { (_, piece) -> piece is Queen }.size)

    @Test
    fun initializationBishopBlockTest() = assertEquals(4, board.filter { (_, piece) -> piece is Bishop }.size)

    @Test
    fun initializationKnightBlockTest() = assertEquals(4, board.filter { (_, piece) -> piece is Knight }.size)

    @Test
    fun initializationRookBlockTest() = assertEquals(4, board.filter { (_, piece) -> piece is Rook }.size)

    @Test
    fun initializationPawnBlockTest() = assertEquals(16, board.filter { (_, piece) -> piece is Pawn }.size)

}