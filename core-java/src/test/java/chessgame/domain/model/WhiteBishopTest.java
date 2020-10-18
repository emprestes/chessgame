package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteBishop;
import static chessgame.domain.model.BoardPosition.A6;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.C4;
import static chessgame.domain.model.BoardPosition.D3;
import static chessgame.domain.model.BoardPosition.D5;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.G2;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H7;
import static chessgame.domain.model.PieceColor.WHITE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WhiteBishopTest {

    private static final BoardPosition INITIAL_POSITION = F1;

    private Board board;

    private Piece whiteBishop;

    @Before
    public void setUp() {
        board = new Board();
        board.init();
        whiteBishop = createWhiteBishop(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteBishop instanceof WhiteBishop);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteBishop.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteBishop.getPosition());
        assertEquals(whiteBishop, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToA6Test() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A6));

        whiteBishop.moveTo(A6);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(A6));
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        final Set<BoardPosition> pos = whiteBishop
                .moveTo(G2)
                .moveTo(D5)
                .getAvailablePositions();
        assertEquals(13, pos.size());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        final Set<BoardPosition> pos = whiteBishop
                .moveTo(C4)
                .moveTo(B3)
                .getAvailablePositions();
        assertEquals(9, pos.size());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        final Set<BoardPosition> pos = whiteBishop.getAvailablePositions();
        assertEquals(7, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Set<BoardPosition> pos = whiteBishop
                .moveTo(G2)
                .moveTo(H1)
                .getAvailablePositions();
        assertEquals(7, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        final Set<BoardPosition> pos = whiteBishop
                .moveTo(G2)
                .moveTo(A8)
                .getAvailablePositions();
        assertEquals(7, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        final Set<BoardPosition> pos = whiteBishop
                .moveTo(D3)
                .moveTo(H7)
                .getAvailablePositions();
        assertEquals(7, pos.size());
    }
}
