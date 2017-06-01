package chessgame.domain.model;

import chessgame.domain.Piece;
import junitx.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;
public class KingTest {

    private Board board;

    @Before
    public void init() {
        board = new Board();
    }

    @Test
    public void getAvailablePositionsFromF5() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.F5);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(8, pos.size());

    }

    @Test
    public void getAvailablePositionsFromH5() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.H5);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(5, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA1() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.A1);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.H1);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.A8);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8() throws Exception {
        King king = (King) Piece.createWhiteKing(board);
        king.move(BoardPosition.H8);
        Set<BoardPosition> pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsNOK() throws Exception {
        // TODO Test here.
    }
}
