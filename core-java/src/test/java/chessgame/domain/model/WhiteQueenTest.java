package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteQueen;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A2;
import static chessgame.domain.model.BoardPosition.A3;
import static chessgame.domain.model.BoardPosition.A4;
import static chessgame.domain.model.BoardPosition.A5;
import static chessgame.domain.model.BoardPosition.A6;
import static chessgame.domain.model.BoardPosition.A7;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B2;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.C1;
import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.D3;
import static chessgame.domain.model.BoardPosition.D5;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.G1;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H2;
import static chessgame.domain.model.BoardPosition.H3;
import static chessgame.domain.model.BoardPosition.H4;
import static chessgame.domain.model.BoardPosition.H5;
import static chessgame.domain.model.BoardPosition.H6;
import static chessgame.domain.model.BoardPosition.H7;
import static chessgame.domain.model.BoardPosition.H8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WhiteQueenTest {

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
        assertEquals(D1, whiteQueen.getPosition());
        assertEquals(whiteQueen, board.get(D1));
    }

    @Test
    public void moveFromD1ToA1Test() {
        assertNotNull(board.get("D1"));
        assertNull(board.get(A1));

        whiteQueen.moveTo(A1);

        assertNull(board.get(D1));
        assertNotNull(board.get("A1"));
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo("D2")
                .moveTo(D3)
                .moveTo("D4")
                .moveTo(D5)
                .getAvailablePositions();
        assertEquals(27, pos.size());
    }

    @Test
    public void getAvailablePositionsFromB4Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(C1)
                .moveTo(B1)
                .moveTo(B2)
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
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        final Set<BoardPosition> pos = whiteQueen
                .moveTo(E1)
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
                .getAvailablePositions();
        assertEquals(21, pos.size());
    }
}
