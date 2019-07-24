package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteRook;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A5;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B2;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.B5;
import static chessgame.domain.model.BoardPosition.C5;
import static chessgame.domain.model.BoardPosition.D5;
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

public class RookWhiteTest {

    private static final BoardPosition INITIAL_POSITION = A1;

    private Board board;

    private Piece whiteRook;

    @Before
    public void setUp() {
        board = new Board();
        board.init();
        whiteRook = createWhiteRook(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteRook instanceof Rook);
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteRook.getPosition());
        assertEquals(whiteRook, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToA8Test() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A8));

        whiteRook.moveTo(A8);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(A8));
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        final Set<BoardPosition> pos = whiteRook
                .moveTo(A5)
                .moveTo(B5)
                .moveTo(C5)
                .moveTo(D5)
                .getAvailablePositions();
        assertEquals(14, pos.size());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        final Set<BoardPosition> pos = whiteRook
                .moveTo(B1)
                .moveTo(B2)
                .moveTo(B3)
                .getAvailablePositions();
        assertEquals(14, pos.size());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        final Set<BoardPosition> pos = whiteRook.getAvailablePositions();
        assertEquals(14, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Set<BoardPosition> pos = whiteRook
                .moveTo(H1)
                .getAvailablePositions();
        assertEquals(14, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        final Set<BoardPosition> pos = whiteRook
                .moveTo(A8)
                .getAvailablePositions();
        assertEquals(14, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        final Set<BoardPosition> pos = whiteRook
                .moveTo(H1)
                .moveTo(H2)
                .moveTo(H3)
                .moveTo(H4)
                .moveTo(H5)
                .moveTo(H6)
                .moveTo(H7)
                .moveTo(H8)
                .getAvailablePositions();
        assertEquals(14, pos.size());
    }
}
