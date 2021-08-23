package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.BLACK;
import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.PieceFactory.createBlackPawn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackPawnTest {

    private static final String INITIAL_POSITION = "D7";

    private Board board;

    private Piece blackPawn;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        blackPawn = createBlackPawn(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(blackPawn instanceof BlackPawn);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(BLACK, blackPawn.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, blackPawn.getPositionAsString());
        assertEquals(blackPawn, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "D5";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        blackPawn.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> blackPawn.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> blackPawn.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(2, blackPawn.availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD6Test() {
        assertEquals(1, blackPawn
                .moveTo("D6")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromD8Test() {
        assertEquals(0, blackPawn
                .moveTo("D5", "D4", "D3", "D2", "D1")
                .availablePositionsSize());
    }
}
