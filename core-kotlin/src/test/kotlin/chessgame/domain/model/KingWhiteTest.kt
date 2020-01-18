package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteKing
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.WHITE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class KingWhiteTest {

    companion object {
        private val INITIAL_POSITION = E1
    }

    private var board: Board? = null
    private var whiteKing: Piece? = null

    @Before
    fun init() {
        board = Board()
        board!!.init()
        whiteKing = createWhiteKing(board!!)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteKing is King)

    @Test
    fun whiteColorTest() = assertEquals(WHITE, whiteKing!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKing!!.position)
        assertEquals(whiteKing, board!!.get(INITIAL_POSITION))
    }

    @Test
    fun moveToValidPositionTest() {
        assertNotNull(board!!.get(INITIAL_POSITION))
        assertNull(board!!.get(F1))

        whiteKing!!.moveTo(F1)

        assertNull(board!!.get(INITIAL_POSITION))
        assertNotNull(board!!.get(F1))
    }

    @Test
    fun moveToInvalidPositionTest() {
        assertNotNull(board!!.get(INITIAL_POSITION))
        assertNull(board!!.get(C3))

        whiteKing!!.moveTo(C3)

        assertNotNull(board!!.get(INITIAL_POSITION))
        assertNull(board!!.get(C3))
    }

    @Test
    fun getAvailablePositionsFromF5Test() = assertEquals(8, whiteKing!!
            .moveTo(F1)
            .moveTo(F2)
            .moveTo(F3)
            .moveTo(F4)
            .moveTo(F5)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH5Test() = assertEquals(5, whiteKing!!
            .moveTo(F1)
            .moveTo(G1)
            .moveTo(H1)
            .moveTo(H2)
            .moveTo(H3)
            .moveTo(H4)
            .moveTo(H5)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA1Test() = assertEquals(3, whiteKing!!
            .moveTo(D1)
            .moveTo(C1)
            .moveTo(B1)
            .moveTo(A1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH1Test() = assertEquals(3, whiteKing!!
            .moveTo(F1)
            .moveTo(G1)
            .moveTo(H1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA8Test() = assertEquals(3, whiteKing!!
            .moveTo(D1)
            .moveTo(C1)
            .moveTo(B1)
            .moveTo(A1)
            .moveTo(A2)
            .moveTo(A3)
            .moveTo(A4)
            .moveTo(A5)
            .moveTo(A6)
            .moveTo(A7)
            .moveTo(A8)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH8Test() = assertEquals(3, whiteKing!!
            .moveTo(F1)
            .moveTo(G1)
            .moveTo(H1)
            .moveTo(H2)
            .moveTo(H3)
            .moveTo(H4)
            .moveTo(H5)
            .moveTo(H6)
            .moveTo(H7)
            .moveTo(H8)
            .getAvailablePositions()
            .size)
}