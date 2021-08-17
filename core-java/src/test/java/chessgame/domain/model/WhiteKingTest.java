package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chessgame.domain.model.BoardFactory.createBoard;
import static chessgame.domain.model.BoardPosition.A1;
import static chessgame.domain.model.BoardPosition.A2;
import static chessgame.domain.model.BoardPosition.A3;
import static chessgame.domain.model.BoardPosition.A4;
import static chessgame.domain.model.BoardPosition.A5;
import static chessgame.domain.model.BoardPosition.A6;
import static chessgame.domain.model.BoardPosition.A7;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.B1;
import static chessgame.domain.model.BoardPosition.C1;
import static chessgame.domain.model.BoardPosition.D1;
import static chessgame.domain.model.BoardPosition.E1;
import static chessgame.domain.model.BoardPosition.F1;
import static chessgame.domain.model.BoardPosition.F2;
import static chessgame.domain.model.BoardPosition.F3;
import static chessgame.domain.model.BoardPosition.F4;
import static chessgame.domain.model.BoardPosition.F5;
import static chessgame.domain.model.BoardPosition.G1;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H2;
import static chessgame.domain.model.BoardPosition.H3;
import static chessgame.domain.model.BoardPosition.H4;
import static chessgame.domain.model.BoardPosition.H5;
import static chessgame.domain.model.BoardPosition.H6;
import static chessgame.domain.model.BoardPosition.H7;
import static chessgame.domain.model.BoardPosition.H8;
import static chessgame.domain.model.PieceColor.WHITE;
import static chessgame.domain.model.PieceFactory.createWhiteKing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteKingTest {

    private static final BoardPosition INITIAL_POSITION = E1;

    private Board board;

    private Piece whiteKing;

    @BeforeEach
    public void init() {
        board = createBoard();
        board.init();
        whiteKing = createWhiteKing(board);
    }

    @Test
    public void createInstanceTest() {
        assertTrue(whiteKing instanceof WhiteKing);
    }

    @Test
    public void whiteColorTest() {
        assertEquals(WHITE, whiteKing.getColor());
    }

    @Test
    public void initPositionTest() {
        assertEquals(INITIAL_POSITION, whiteKing.getPosition());
        assertEquals(whiteKing, board.get(INITIAL_POSITION));
    }

    @Test
    public void moveToValidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION));
        assertNull(board.get(F1));

        whiteKing.moveTo(F1);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get(F1));
    }

    @Test
    public void moveToAnInvalidPositionTest() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(H8));

        assertThrows(IllegalStateException.class,
                () -> whiteKing.moveTo(H8),
                "This movement shouldn't happen to " + H8);
    }

    @Test
    public void getAvailablePositionsFromF5Test() {
        assertEquals(8, whiteKing
                .moveTo(F1)
                .moveTo(F2)
                .moveTo(F3)
                .moveTo(F4)
                .moveTo(F5)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH5Test() {
        assertEquals(5, whiteKing
                .moveTo(F1)
                .moveTo(G1)
                .moveTo(H1)
                .moveTo(H2)
                .moveTo(H3)
                .moveTo(H4)
                .moveTo(H5)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        assertEquals(3, whiteKing
                .moveTo(D1)
                .moveTo(C1)
                .moveTo(B1)
                .moveTo(A1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        assertEquals(3, whiteKing
                .moveTo(F1)
                .moveTo(G1)
                .moveTo(H1)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        assertEquals(3, whiteKing
                .moveTo(D1)
                .moveTo(C1)
                .moveTo(B1)
                .moveTo(A1)
                .moveTo(A2)
                .moveTo(A3)
                .moveTo(A4)
                .moveTo(A5)
                .moveTo(A6)
                .moveTo(A7)
                .moveTo(A8)
                .availablePositionsSize());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        assertEquals(3, whiteKing
                .moveTo(F1)
                .moveTo(G1)
                .moveTo(H1)
                .moveTo(H2)
                .moveTo(H3)
                .moveTo(H4)
                .moveTo(H5)
                .moveTo(H6)
                .moveTo(H7)
                .moveTo(H8)
                .availablePositionsSize());
    }
}
