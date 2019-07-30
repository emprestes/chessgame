package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteRook
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.WHITE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RookWhiteTest {

    companion object {
        private val INITIAL_POSITION = A1
    }

    private var board: Board? = null
    private var whiteRook: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whiteRook = createWhiteRook(board!!, INITIAL_POSITION)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteRook is Rook)

    @Test
    fun whiteColorTest() = assertEquals(WHITE, whiteRook!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteRook!!.position)
        assertEquals(whiteRook, board!![INITIAL_POSITION])
    }

    @Test
    fun moveToA8Test() {
        assertNotNull(board!![INITIAL_POSITION.toString()])
        assertNull(board!![A8])

        whiteRook!!.moveTo(A8)

        assertNull(board!![INITIAL_POSITION])
        assertNotNull(board!![A8])
    }

    @Test
    fun getAvailablePositionsFromD5Test() = assertEquals(14, whiteRook!!
            .moveTo(A5)
            .moveTo(B5)
            .moveTo(C5)
            .moveTo(D5)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromB3Test() = assertEquals(14, whiteRook!!
            .moveTo(B1)
            .moveTo(B2)
            .moveTo(B3)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromInitialPositionTest() = assertEquals(14, whiteRook!!
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH1Test() = assertEquals(14, whiteRook!!
            .moveTo(H1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA8Test() = assertEquals(14, whiteRook!!
            .moveTo(A8)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH8Test() = assertEquals(14, whiteRook!!
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