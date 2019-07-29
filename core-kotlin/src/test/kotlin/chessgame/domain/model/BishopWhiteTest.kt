package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteBishop
import chessgame.domain.model.BoardPosition.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BishopWhiteTest {

    private val initialPosition: BoardPosition = F1
    private var board: Board? = null
    private var whiteBishop: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whiteBishop = createWhiteBishop(board!!, initialPosition)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteBishop is Bishop)

    @Test
    fun whiteColorTest() = assertEquals(PieceColor.WHITE, whiteBishop!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(initialPosition, whiteBishop!!.position)
        assertEquals(whiteBishop, board!![initialPosition])
    }

    @Test
    fun moveToA6Test() {
        assertNotNull(board!![initialPosition.toString()])
        assertNull(board!![A6])

        whiteBishop!!.moveTo(A6)

        assertNull(board!![initialPosition])
        assertNotNull(board!![A6])
    }

    @Test
    fun getAvailablePositionsFromD5Test() {
        val pos = whiteBishop!!
                .moveTo(G2)
                .moveTo(D5)
                .getAvailablePositions()
        assertEquals(13, pos.size)
    }

    @Test
    fun getAvailablePositionsFromB3Test() {
        val pos = whiteBishop!!
                .moveTo(C4)
                .moveTo(B3)
                .getAvailablePositions()
        assertEquals(9, pos.size)
    }

    @Test
    fun getAvailablePositionsFromInitialPositionTest() {
        val pos = whiteBishop!!.getAvailablePositions()
        assertEquals(7, pos.size)
    }

    @Test
    fun getAvailablePositionsFromH1Test() {
        val pos = whiteBishop!!
                .moveTo(G2)
                .moveTo(H1)
                .getAvailablePositions()
        assertEquals(7, pos.size)
    }

    @Test
    fun getAvailablePositionsFromA8Test() {
        val pos = whiteBishop!!
                .moveTo(G2)
                .moveTo(A8)
                .getAvailablePositions()
        assertEquals(7, pos.size)
    }

    @Test
    fun getAvailablePositionsFromH7Test() {
        val pos = whiteBishop!!
                .moveTo(D3)
                .moveTo(H7)
                .getAvailablePositions()
        assertEquals(7, pos.size)
    }
}
