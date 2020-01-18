package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteKnight;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A3;
import static chessgame.domain.model.BoardPosition.A4;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B2;
import static chessgame.domain.model.BoardPosition.C2;
import static chessgame.domain.model.BoardPosition.C3;
import static chessgame.domain.model.BoardPosition.D2;
import static chessgame.domain.model.BoardPosition.E4;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.G3;
import static chessgame.domain.model.BoardPosition.G5;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H7;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class KnightWhiteTest {

    private static final BoardPosition INITIAL_POSITION = B1;

    private Board board;

    private Piece whiteKnight;

    @Before
    public void setUp() {
        board = new Board();
        board.init();
        whiteKnight = createWhiteKnight(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteKnight instanceof Knight);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(PieceColor.WHITE, whiteKnight.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKnight.getPosition());
        assertEquals(whiteKnight, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToA3Test() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A3));

        whiteKnight.moveTo(A3);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(A3));
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        final Set<BoardPosition> pos = whiteKnight
                .moveTo(A3)
                .moveTo(C2)
                .moveTo(A1)
                .getAvailablePositions();
        assertEquals(2, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA3Test() {
        final Set<BoardPosition> pos = whiteKnight
                .moveTo(A3)
                .getAvailablePositions();
        assertEquals(4, pos.size());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        final Set<BoardPosition> pos = whiteKnight.getAvailablePositions();
        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Set<BoardPosition> pos = whiteKnight
                .moveTo(D2)
                .moveTo(F1)
                .moveTo(G3)
                .moveTo(H1)
                .getAvailablePositions();
        assertEquals(2, pos.size());
    }

    @Test
    public void getAvailablePositionsFromB2Test() {
        final Set<BoardPosition> pos = whiteKnight
                .moveTo(C3)
                .moveTo(A4)
                .moveTo(B2)
                .getAvailablePositions();
        assertEquals(4, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        final Set<BoardPosition> pos = whiteKnight
                .moveTo(C3)
                .moveTo(E4)
                .moveTo(G5)
                .moveTo(H7)
                .getAvailablePositions();
        assertEquals(3, pos.size());
    }
}
