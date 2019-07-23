package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhiteKing;
import static chessgame.domain.model.BoardPosition.A8;
import static chessgame.domain.model.BoardPosition.F5;
import static chessgame.domain.model.BoardPosition.H1;
import static chessgame.domain.model.BoardPosition.H5;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KingTest {

    private Board board;

    @Before
    public void init() {
        board = new Board();
        board.init();
    }

    @Test
    public void getAvailablePositionsFromF5Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(F5);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(8, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH5Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(H5);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(5, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA1Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(BoardPosition.A1);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(H1);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(A8);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8Test() {
        final Piece king = createWhiteKing(board);

        assertTrue(king instanceof King);

        king.move(BoardPosition.H8);
        final Set<BoardPosition> pos = king.getAvailablePositions();

        assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsNOKTest() {
        // TODO Test here.
    }
}
