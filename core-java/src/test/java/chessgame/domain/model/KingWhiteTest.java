package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteKing;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A2;
import static chessgame.domain.model.BoardPosition.A3;
import static chessgame.domain.model.BoardPosition.A4;
import static chessgame.domain.model.BoardPosition.A5;
import static chessgame.domain.model.BoardPosition.A6;
import static chessgame.domain.model.BoardPosition.A7;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.C1;
import static chessgame.domain.model.BoardPosition.C3;
import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.F2;
import static chessgame.domain.model.BoardPosition.F3;
import static chessgame.domain.model.BoardPosition.F4;
import static chessgame.domain.model.BoardPosition.F5;
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

public class KingWhiteTest {

    private static final BoardPosition INITIAL_POSITION = E1;

    private Board board;

    private Piece whiteKing;

    @Before
    public void init() {
        board = new Board();
        board.init();
        whiteKing = createWhiteKing(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteKing instanceof King);
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKing.getPosition());
        assertEquals(whiteKing, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(F1));

        whiteKing.moveTo(F1);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(F1));
    }

    @Test
    public void moveToInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(C3));

        whiteKing.moveTo(C3);

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(C3));
    }

    @Test
    public void getAvailablePositionsFromF5Test() {
        final Set<BoardPosition> pos = whiteKing
                .moveTo(F1)
                .moveTo(F2)
                .moveTo(F3)
                .moveTo(F4)
                .moveTo(F5)
                .getAvailablePositions();
        assertEquals(8, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH5Test() {
        final Set<BoardPosition> pos = whiteKing
                .moveTo(F1)
                .moveTo(G1)
                .moveTo(H1)
                .moveTo(H2)
                .moveTo(H3)
                .moveTo(H4)
                .moveTo(H5)
                .getAvailablePositions();
        assertEquals(5, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        final Set<BoardPosition> pos = whiteKing
                .moveTo(D1)
                .moveTo(C1)
                .moveTo(B1)
                .moveTo(A1)
                .getAvailablePositions();
        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Set<BoardPosition> pos = whiteKing
                .moveTo(F1)
                .moveTo(G1)
                .moveTo(H1)
                .getAvailablePositions();
        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        final Set<BoardPosition> pos = whiteKing
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
                .getAvailablePositions();
        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        final Set<BoardPosition> pos = whiteKing
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
        assertEquals(3, pos.size());
    }
}
