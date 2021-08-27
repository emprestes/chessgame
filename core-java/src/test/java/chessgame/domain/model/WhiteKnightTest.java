package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.PieceColor.WHITE;
import static chessgame.domain.factory.BoardFactory.createBoard;
import static chessgame.domain.factory.PieceFactory.createWhiteKnight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteKnightTest {

    private static final String INITIAL_POSITION = "B1";

    private Board board;

    private Piece whiteKnight;

    @BeforeEach
    public void setUp() {
        board = createBoard();
        board.init();
        whiteKnight = createWhiteKnight(board, INITIAL_POSITION);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteKnight instanceof WhiteKnight);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteKnight.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKnight.getPositionAsString());
        assertEquals(whiteKnight, board.get(INITIAL_POSITION));
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(3, whiteKnight.availablePositionsSize());
    }

    @Test
    public void moveToAValidPositionTest() {
        final String position = "A3";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        whiteKnight.moveTo(position);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(position));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        final String position = "H8";

        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(position));

        assertThrows(IllegalStateException.class,
                () -> whiteKnight.moveTo(position),
                "This movement shouldn't happen to " + position);
    }

    @Test
    public void moveToEmptyPositionTest() {
        assertThrows(IllegalStateException.class,
                () -> whiteKnight.moveTo(new String[0]),
                "This movement shouldn't happen to an empty position");
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(2, whiteKnight
                .moveTo("A3", "C2", "A1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA3Test() {
        assertEquals(4, whiteKnight
                .moveTo("A3")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(2, whiteKnight
                .moveTo("D2", "F1", "G3", "H1")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB2Test() {
        assertEquals(4, whiteKnight
                .moveTo("C3", "A4", "B2")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        assertEquals(3, whiteKnight
                .moveTo("C3", "E4", "G5", "H7")
                .availablePositionsSize());
    }
}
