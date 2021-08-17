package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B2;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.D5;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H2;
import static chessgame.domain.model.BoardPosition.H3;
import static chessgame.domain.model.BoardPosition.H4;
import static chessgame.domain.model.BoardPosition.H5;
import static chessgame.domain.model.BoardPosition.H6;
import static chessgame.domain.model.BoardPosition.H7;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.BLACK;
import static chessgame.domain.model.PieceFactory.createBlackRook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackRookTest {

    private static final BoardPosition INITIAL_POSITION = H1;

    private Board board;

    private Piece blackRook;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        blackRook = createBlackRook(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackRook instanceof BlackRook);
    }

    @Test
    public void blackColorTest() {
        assertEquals(BLACK, blackRook.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackRook.getPosition());
        assertEquals(blackRook, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        blackRook.moveTo(H8);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(H8));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A8));

        assertThrows(IllegalStateException.class,
                () -> blackRook.moveTo(A8),
                "This movement shouldn't happen to " + A8);
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(14, blackRook
                .moveTo(H5)
                .moveTo(D5)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(14, blackRook
                .moveTo(B1)
                .moveTo(B2)
                .moveTo(B3)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(14, blackRook
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(14, blackRook
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(14, blackRook
                .moveTo(H8)
                .moveTo(A8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(14, blackRook
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
