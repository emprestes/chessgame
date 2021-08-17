package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
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
import static chessgame.domain.model.PieceColor.WHITE;
import static chessgame.domain.model.PieceFactory.createWhiteRook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteRookTest {

    private static final BoardPosition INITIAL_POSITION = A1;

    private Board board;

    private Piece whiteRook;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        whiteRook = createWhiteRook(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteRook instanceof WhiteRook);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteRook.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteRook.getPosition());
        assertEquals(whiteRook, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A8));

        whiteRook.moveTo(A8);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(A8));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        assertThrows(IllegalStateException.class,
                () -> whiteRook.moveTo(H8),
                "This movement shouldn't happen to " + H8);
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(14, whiteRook
                .moveTo(A5)
                .moveTo(B5)
                .moveTo(C5)
                .moveTo(D5)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(14, whiteRook
                .moveTo(B1)
                .moveTo(B2)
                .moveTo(B3)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(14, whiteRook
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(14, whiteRook
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(14, whiteRook
                .moveTo(A8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(14, whiteRook
                .moveTo(H1)
                .moveTo(H2)
                .moveTo(H3)
                .moveTo(H4)
                .moveTo(H5)
                .moveTo(H6)
                .moveTo(H7)
                .moveTo(H8)
                .availablePositionsSize());
    }
}
