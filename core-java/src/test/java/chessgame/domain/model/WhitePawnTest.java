package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.factory.BoardFactory.createBoard;
import static chessgame.domain.factory.PieceFactory.createWhitePawn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhitePawnTest {

    private static final String INITIAL_POSITION = "D2";

    private Board board;

    private Piece whitePawn;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        whitePawn = createWhitePawn(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whitePawn instanceof WhitePawn);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whitePawn.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whitePawn.getPositionAsString());
        assertEquals(whitePawn, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "D4";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whitePawn.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whitePawn.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whitePawn.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(2, whitePawn.availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD3Test() {
        assertEquals(1, whitePawn
                .moveTo("D3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD8Test() {
        assertEquals(0, whitePawn
                .moveTo("D3", "D4", "D5", "D6", "D7", "D8")
                .availablePositionsSize());
    }
}
