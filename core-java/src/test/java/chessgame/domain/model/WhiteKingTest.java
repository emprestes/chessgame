package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createWhiteKing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteKingTest {

    private static final String INITIAL_POSITION = "E1";

    private Board board;

    private Piece whiteKing;

    @BeforeEach
    public void init() {
        board = createBoard();
        board.init();
        whiteKing = createWhiteKing(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteKing instanceof WhiteKing);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteKing.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKing.getPositionAsString());
        assertEquals(whiteKing, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        final String position = "F1";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whiteKing.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whiteKing.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whiteKing.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromF5Test() {
        assertEquals(8, whiteKing
                .moveTo("F1", "F2", "F3", "F4", "F5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH5Test() {
        assertEquals(5, whiteKing
                .moveTo("F1", "G1", "H1", "H2", "H3", "H4", "H5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(3, whiteKing
                .moveTo("D1", "C1", "B1", "A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(3, whiteKing
                .moveTo("F1", "G1", "H1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(3, whiteKing
                .moveTo("D1", "C1", "B1", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(3, whiteKing
                .moveTo("F1", "G1", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8")
                .availablePositionsSize());
    }
}
