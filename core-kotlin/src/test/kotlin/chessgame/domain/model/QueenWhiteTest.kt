package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteQueen
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.WHITE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class QueenWhiteTest {

    companion object {
        private val INITIAL_POSITION = D1
    }

    private var board: Board? = null
    private var whiteQueen: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whiteQueen = createWhiteQueen(board!!)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteQueen is Queen)

    @Test
    fun whiteColorTest() = assertEquals(WHITE, whiteQueen!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteQueen!!.position)
        assertEquals(whiteQueen, board!!.get(INITIAL_POSITION))
    }

    @Test
    fun moveToA1Test() {
        assertNotNull(board!![INITIAL_POSITION.toString()])
        assertNull(board!![A1])

        whiteQueen!!.moveTo(A1)

        assertNull(board!![INITIAL_POSITION])
        assertNotNull(board!!["A1"])
    }

    @Test
    fun getAvailablePositionsFromD5Test() = assertEquals(27, whiteQueen!!
            .moveTo("D5")
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromB4Test() = assertEquals(23, whiteQueen!!
            .moveTo(B1)
            .moveTo(B3)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA1Test() = assertEquals(21, whiteQueen!!
            .moveTo(A1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH1Test() = assertEquals(21, whiteQueen!!
            .moveTo(H1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA8Test() = assertEquals(21, whiteQueen!!
            .moveTo(A1)
            .moveTo(A8)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH8Test() = assertEquals(21, whiteQueen!!
            .moveTo(H1)
            .moveTo(H8)
            .getAvailablePositions()
            .size)
}