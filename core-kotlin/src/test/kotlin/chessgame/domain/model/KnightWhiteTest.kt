package chessgame.domain.model

import chessgame.domain.Piece
import chessgame.domain.PieceFactory.Companion.createWhiteKnight
import chessgame.domain.model.BoardPosition.*
import chessgame.domain.model.PieceColor.WHITE
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class KnightWhiteTest {

    companion object {
        private val INITIAL_POSITION = B1
    }

    private var board: Board? = null
    private var whiteKnight: Piece? = null

    @Before
    fun setUp() {
        board = Board()
        board!!.init()
        whiteKnight = createWhiteKnight(board!!, INITIAL_POSITION)
    }

    @Test
    fun createInstanceTest() = assertTrue(whiteKnight is Knight)

    @Test
    fun whiteColorTest() = assertEquals(WHITE, whiteKnight!!.color)

    @Test
    fun initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKnight!!.position)
        assertEquals(whiteKnight, board!![INITIAL_POSITION])
    }

    @Test
    fun moveToA3Test() {
        assertNotNull(board!![INITIAL_POSITION.toString()])
        assertNull(board!![A3])

        whiteKnight!!.moveTo(A3)

        assertNull(board!![INITIAL_POSITION])
        assertNotNull(board!![A3])
    }

    @Test
    fun getAvailablePositionsFromA1Test() = assertEquals(2, whiteKnight!!
            .moveTo(A3)
            .moveTo(C2)
            .moveTo(A1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromA3Test() = assertEquals(4, whiteKnight!!
            .moveTo(A3)
            .getAvailablePositions().size)

    @Test
    fun getAvailablePositionsFromInitialPositionTest() = assertEquals(3, whiteKnight!!
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH1Test() = assertEquals(2, whiteKnight!!
            .moveTo(D2)
            .moveTo(F1)
            .moveTo(G3)
            .moveTo(H1)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromB2Test() = assertEquals(4, whiteKnight!!
            .moveTo(C3)
            .moveTo(A4)
            .moveTo(B2)
            .getAvailablePositions()
            .size)

    @Test
    fun getAvailablePositionsFromH7Test() = assertEquals(3, whiteKnight!!
            .moveTo(C3)
            .moveTo(E4)
            .moveTo(G5)
            .moveTo(H7)
            .getAvailablePositions()
            .size)
}