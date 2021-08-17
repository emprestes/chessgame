package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.D2;
import static chessgame.domain.model.BoardPosition.D3;
import static chessgame.domain.model.BoardPosition.D4;
import static chessgame.domain.model.BoardPosition.D5;
import static chessgame.domain.model.BoardPosition.D6;
import static chessgame.domain.model.BoardPosition.D7;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.WHITE;
import static chessgame.domain.model.PieceFactory.createWhitePawn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhitePawnTest {

    private static final BoardPosition INITIAL_POSITION = D2;

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
        assertEquals(INITIAL_POSITION, whitePawn.getPosition());
        assertEquals(whitePawn, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(D4));

        whitePawn.moveTo(D4);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get("D4"));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        assertThrows(IllegalStateException.class,
                () -> whitePawn.moveTo(H8),
                "This movement shouldn't happen to " + H8);
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
                .moveTo(D3)
                .moveTo(D4)
                .moveTo(D5)
                .moveTo(D6)
                .moveTo(D7)
                .moveTo(D8)
                .availablePositionsSize());
    }
}
