package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createWhiteRook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteRookTest {

    private static final String INITIAL_POSITION = "A1";

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
        assertEquals(INITIAL_POSITION, whiteRook.getPositionAsString());
        assertEquals(whiteRook, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "A8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whiteRook.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whiteRook.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whiteRook.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(14, whiteRook
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(14, whiteRook
                .moveTo("A5", "D5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(14, whiteRook
                .moveTo("B1", "B3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromE4Test() {
        assertEquals(14, whiteRook
                .moveTo("E1", "E4")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(14, whiteRook
                .moveTo("A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(14, whiteRook
                .moveTo("H1", "H8")
                .availablePositionsSize());
    }
}
