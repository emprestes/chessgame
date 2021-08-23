package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.factory.BoardFactory.createBoard;
import static chessgame.domain.factory.PieceFactory.createBlackKnight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackKnightTest {

    private static final String INITIAL_POSITION = "B8";

    private Board board;

    private Piece blackKnight;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        blackKnight = createBlackKnight(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackKnight instanceof BlackKnight);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(BLACK, blackKnight.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackKnight.getPositionAsString());
        assertEquals(blackKnight, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "A6";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackKnight.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackKnight.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackKnight.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(2, blackKnight
                .moveTo("D7")
                .moveTo("B6")
                .moveTo("A8")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(3, blackKnight.availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA6Test() {
        assertEquals(4, blackKnight
                .moveTo("A6")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromC6Test() {
        assertEquals(8, blackKnight
                .moveTo("C6")
                .availablePositionsSize());
    }
}
