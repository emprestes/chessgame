package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteBishop
import chessgame.domain.model.BoardPosition.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BishopWhiteTest {

    companion object {
        private val INITIAL_POSITION: BoardPosition = F1
    }

    private var board: Board? = null
    private var whiteBishop: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whiteBishop = createWhiteBishop(board!!, INITIAL_POSITION)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteBishop is Bishop)

    @Test
    fun whiteColorTest() = assertEquals(PieceColor.WHITE, whiteBishop!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteBishop!!.position)
        assertEquals(whiteBishop, board!![INITIAL_POSITION])
    }

    @Test
    fun moveToA6Test() {
        assertNotNull(board!![INITIAL_POSITION.toString()])
        assertNull(board!![A6])

        whiteBishop!!.moveTo(A6)

        assertNull(board!![INITIAL_POSITION])
        assertNotNull(board!![A6])
    }

    @Test
    fun getAvailablePositionsFromD5Test() = assertEquals(13, whiteBishop!!
            .moveTo(G2)
            .moveTo(D5)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromB3Test() = assertEquals(9, whiteBishop!!
            .moveTo(C4)
            .moveTo(B3)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromInitialPositionTest() = assertEquals(7, whiteBishop!!
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH1Test() = assertEquals(7, whiteBishop!!
            .moveTo(G2)
            .moveTo(H1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA8Test() = assertEquals(7, whiteBishop!!
            .moveTo(G2)
            .moveTo(A8)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH7Test() = assertEquals(7, whiteBishop!!
            .moveTo(D3)
            .moveTo(H7)
            .getAvailablePositions()
            .size)
}
