package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteQueen;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class QueenWhiteTest {

    private static final BoardPosition INITIAL_POSITION = D1;

    private Board board;

    private Piece whiteQueen;

    @Before
    public void setUp() {
        board = new Board();
        board.init();
        whiteQueen = createWhiteQueen(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteQueen instanceof Queen);
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteQueen.getPosition());
        assertEquals(whiteQueen, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToA1Test() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A1));

        whiteQueen.moveTo(A1);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get("A1"));
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo("D5")
                .getAvailablePositions();
        assertEquals(27, pos.size());
    }

    @Test
    public void getAvailablePositionsFromB4Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(B1)
                .moveTo(B3)
                .getAvailablePositions();
        assertEquals(23, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(A1)
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(H1)
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(A1)
                .moveTo(A8)
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(H1)
                .moveTo(H8)
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }
}
