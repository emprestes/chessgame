package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createBlackKing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackKingTest {

    private static final String INITIAL_POSITION = "E8";

    private Board board;

    private Piece blackKing;

    @BeforeEach
    public void init() {
        board = createBoard();
        board.init();
        blackKing = createBlackKing(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackKing instanceof BlackKing);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(BLACK, blackKing.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackKing.getPositionAsString());
        assertEquals(blackKing, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        final String position = "F8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackKing.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackKing.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackKing.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromF5Test() {
        assertEquals(8, blackKing
                .moveTo("F8", "F7", "F6", "F5", "F4")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH5Test() {
        assertEquals(5, blackKing
                .moveTo("F8", "G8", "H8", "H7", "H6", "H5", "H4")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(3, blackKing
                .moveTo("D8", "C8", "B8", "A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(3, blackKing
                .moveTo("F8", "G8", "H8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(3, blackKing
                .moveTo("D8", "C8", "B8", "A8", "A7", "A6", "A5", "A4", "A3", "A2", "A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(3, blackKing
                .moveTo("F8", "G8", "H8", "H7", "H6", "H5", "H4", "H3", "H2", "H1")
                .availablePositionsSize());
    }
}
