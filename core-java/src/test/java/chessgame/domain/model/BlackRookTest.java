package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createBlackRook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackRookTest {

    private static final String INITIAL_POSITION = "H1";

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
        assertEquals(INITIAL_POSITION, blackRook.getPositionAsString());
        assertEquals(blackRook, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackRook.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "A8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackRook.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackRook.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(14, blackRook
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB5Test() {
        assertEquals(14, blackRook
                .moveTo("H5")
                .moveTo("B5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB3Test() {
        assertEquals(14, blackRook
                .moveTo("B1", "B3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(14, blackRook
                .moveTo("A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(14, blackRook
                .moveTo("H8", "A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(14, blackRook
                .moveTo("H8")
                .availablePositionsSize());
    }
}
