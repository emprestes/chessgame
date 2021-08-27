package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.factory.BoardFactory.createBoard;
import static chessgame.domain.factory.PieceFactory.createBlackQueen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackQueenTest {

    private static final String INITIAL_POSITION = "D8";

    private Board board;

    private Piece blackQueen;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        blackQueen = createBlackQueen(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackQueen instanceof BlackQueen);
    }

    @Test
    public void blackColorTest() {
        assertEquals(BLACK, blackQueen.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackQueen.getPositionAsString());
        assertEquals(blackQueen, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "A8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackQueen.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H1";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackQueen.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackQueen.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(21, blackQueen.availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(21, blackQueen
                .moveTo("A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD7Test() {
        assertEquals(23, blackQueen
                .moveTo("D7")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromF6Test() {
        assertEquals(25, blackQueen
                .moveTo("F6")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(27, blackQueen
                .moveTo("D5")
                .availablePositionsSize());
    }
}
