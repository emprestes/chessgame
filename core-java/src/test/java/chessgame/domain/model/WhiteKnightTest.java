package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A3;
import static chessgame.domain.model.BoardPosition.A4;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.B2;
import static chessgame.domain.model.BoardPosition.C2;
import static chessgame.domain.model.BoardPosition.C3;
import static chessgame.domain.model.BoardPosition.D2;
import static chessgame.domain.model.BoardPosition.E4;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.G3;
import static chessgame.domain.model.BoardPosition.G5;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H7;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.WHITE;
import static chessgame.domain.model.PieceFactory.createWhiteKnight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteKnightTest {

    private static final BoardPosition INITIAL_POSITION = B1;

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
        assertEquals(INITIAL_POSITION, whiteKnight.getPosition());
        assertEquals(whiteKnight, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToAValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(A3));

        whiteKnight.moveTo(A3);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(A3));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        assertThrows(IllegalStateException.class,
                () -> whiteKnight.moveTo(H8),
                "This movement shouldn't happen to " + H8);
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(2, whiteKnight
                .moveTo(A3)
                .moveTo(C2)
                .moveTo(A1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA3Test() {
        assertEquals(4, whiteKnight
                .moveTo(A3)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromInitialPositionTest() {
        assertEquals(3, whiteKnight.availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(2, whiteKnight
                .moveTo(D2)
                .moveTo(F1)
                .moveTo(G3)
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromB2Test() {
        assertEquals(4, whiteKnight
                .moveTo(C3)
                .moveTo(A4)
                .moveTo(B2)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH7Test() {
        assertEquals(3, whiteKnight
                .moveTo(C3)
                .moveTo(E4)
                .moveTo(G5)
                .moveTo(H7)
                .availablePositionsSize());
    }
}
