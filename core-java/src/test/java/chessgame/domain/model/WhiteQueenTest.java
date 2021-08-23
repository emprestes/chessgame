package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createWhiteQueen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteQueenTest {

    private static final String INITIAL_POSITION = "D1";

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
        assertEquals(INITIAL_POSITION, whiteQueen.getPositionAsString());
        assertEquals(whiteQueen, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "A1";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whiteQueen.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whiteQueen.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whiteQueen.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(21, whiteQueen.availablePositionsSize());
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
                .moveTo("B1", "B3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(21, whiteQueen
                .moveTo("A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(21, whiteQueen
                .moveTo("H1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(21, whiteQueen
                .moveTo("A1", "A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(21, whiteQueen
                .moveTo("H1", "H8")
                .availablePositionsSize());
    }
}
