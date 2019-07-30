package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhitePawn
import chessgame.domain.model.BoardPosition.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class PawnWhiteTest {

    companion object {
        private val INITIAL_POSITION = D2
    }

    private var board: Board? = null
    private var whitePawn: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whitePawn = createWhitePawn(board!!, INITIAL_POSITION)
    }

    @Test
    fun createInstanceTest() = assertTrue(whitePawn is Pawn)

    @Test
    fun whiteColorTest() = assertEquals(PieceColor.WHITE, whitePawn!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whitePawn!!.position)
        assertEquals(whitePawn, board!![INITIAL_POSITION])
    }

    @Test
    fun moveToD4Test() {
        assertNotNull(board!![INITIAL_POSITION.toString()])
        assertNull(board!![D4])

        whitePawn!!.moveTo(D4)

        assertNull(board!![INITIAL_POSITION])
        assertNotNull(board!!["D4"])
    }

    @Test
    fun getAvailablePositionsFromD3Test() = assertEquals(1, whitePawn!!
            .moveTo("D3")
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromD8Test() = assertEquals(0, whitePawn!!
            .moveTo(D3)
            .moveTo(D4)
            .moveTo(D5)
            .moveTo(D6)
            .moveTo(D7)
            .moveTo(D8)
            .getAvailablePositions()
            .size)
}