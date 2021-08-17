package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
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
import static chessgame.domain.model.PieceFactory.createWhiteBishop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteBishopTest {

    private static final BoardPosition INITIAL_POSITION = F1;

    private Board board;

    private Piece whiteBishop;

    @BeforeEach
    public void setUp() {
        board = createBoard();
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
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A8));

        assertThrows(IllegalStateException.class,
                () -> whiteBishop.moveTo(A8),
                "This movement shouldn't happen to " + A8);
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
        assertEquals(13, whiteBishop
                .moveTo(G2)
                .moveTo(D5)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(9, whiteBishop
                .moveTo(C4)
                .moveTo(B3)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(7, whiteBishop
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(7, whiteBishop
                .moveTo(G2)
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(7, whiteBishop
                .moveTo(G2)
                .moveTo(A8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        assertEquals(7, whiteBishop
                .moveTo(D3)
                .moveTo(H7)
                .availablePositionsSize());
    }
}
