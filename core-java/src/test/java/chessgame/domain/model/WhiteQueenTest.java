package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B3;
import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.WHITE;
import static chessgame.domain.model.PieceFactory.createWhiteQueen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteQueenTest {

    private static final BoardPosition INITIAL_POSITION = D1;

    private Board board;

    private Piece whiteQueen;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        whiteQueen = createWhiteQueen(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteQueen instanceof WhiteQueen);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteQueen.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteQueen.getPosition());
        assertEquals(whiteQueen, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A1));

        whiteQueen.moveTo(A1);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get("A1"));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        assertThrows(IllegalStateException.class,
                () -> whiteQueen.moveTo(H8),
                "This movement shouldn't happen to " + H8);
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(27, whiteQueen
                .moveTo("D5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB4Test() {
        assertEquals(23, whiteQueen
                .moveTo(B1)
                .moveTo(B3)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(21, whiteQueen
                .moveTo(A1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(21, whiteQueen
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(21, whiteQueen
                .moveTo(A1)
                .moveTo(A8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(21, whiteQueen
                .moveTo(H1)
                .moveTo(H8)
                .availablePositionsSize());
    }
}
