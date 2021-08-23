package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createBlackBishop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackBishopTest {

    private static final String INITIAL_POSITION = "F8";

    private Board board;

    private Piece blackBishop;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        blackBishop = createBlackBishop(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackBishop instanceof BlackBishop);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(BLACK, blackBishop.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackBishop.getPositionAsString());
        assertEquals(blackBishop, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        final String position = "A3";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackBishop.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackBishop.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackBishop.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(7, blackBishop
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(13, blackBishop
                .moveTo("G7", "D4")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(9, blackBishop
                .moveTo("B4")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(7, blackBishop
                .moveTo("G7", "H8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(7, blackBishop
                .moveTo("G7", "A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        assertEquals(7, blackBishop
                .moveTo("D6", "H2")
                .availablePositionsSize());
    }
}
