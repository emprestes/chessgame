package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B6;
import static chessgame.domain.model.BoardPosition.B8;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H4;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.BLACK;
import static chessgame.domain.model.PieceFactory.createBlackQueen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackQueenTest {

    private static final BoardPosition INITIAL_POSITION = D8;

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
        assertEquals(INITIAL_POSITION, blackQueen.getPosition());
        assertEquals(blackQueen, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A8));

        blackQueen.moveTo(A8);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get("A8"));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H1));

        assertThrows(IllegalStateException.class,
                () -> blackQueen.moveTo(H1),
                "This movement shouldn't happen to " + H1);
    }

    @Test
    public void getAvailablePositionsFromD5Test() {
        assertEquals(27, blackQueen
                .moveTo("D5")
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB4Test() {
        assertEquals(23, blackQueen
                .moveTo(B8)
                .moveTo(B6)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(21, blackQueen
                .moveTo(H8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(21, blackQueen
                .moveTo(H4)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(21, blackQueen
                .moveTo(A8)
                .moveTo(A1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(21, blackQueen
                .moveTo(H4)
                .moveTo(H8)
                .availablePositionsSize());
    }
}
