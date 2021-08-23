package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.factory.BoardFactory.createBoard;
import static chessgame.domain.factory.PieceFactory.createWhiteBishop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteBishopTest {

    private static final String INITIAL_POSITION = "F1";

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
        assertEquals(INITIAL_POSITION, whiteBishop.getPositionAsString());
        assertEquals(whiteBishop, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        final String position = "A6";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whiteBishop.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whiteBishop.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whiteBishop.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(7, whiteBishop
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(13, whiteBishop
                .moveTo("G2", "D5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(9, whiteBishop
                .moveTo("C4", "B3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(7, whiteBishop
                .moveTo("G2", "H1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(7, whiteBishop
                .moveTo("G2", "A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        assertEquals(7, whiteBishop
                .moveTo("D3", "H7")
                .availablePositionsSize());
    }
}
