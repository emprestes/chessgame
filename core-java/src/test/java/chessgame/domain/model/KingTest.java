package chessgame.domain.model;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

public class KingTest {

    private Board board = new Board();

    @Test
    public void getAvailablePositionsFromF5() throws Exception {

    }

    @Test
    public void getAvailablePositionsFromH5() throws Exception {

    }

    @Test
    public void getAvailablePositionsFromA1() throws Exception {
        King king = (King) board.get(BoardPosition.E1);
        Set<BoardPosition> pos;

        king.setPosition(BoardPosition.A1);
        pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH1() throws Exception {
        King king = (King) board.get(BoardPosition.E1);
        Set<BoardPosition> pos;

        king.setPosition(BoardPosition.H1);
        pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromA8() throws Exception {
        King king = (King) board.get(BoardPosition.E1);
        Set<BoardPosition> pos;

        king.setPosition(BoardPosition.H8);
        pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsFromH8() throws Exception {
        King king = (King) board.get(BoardPosition.E1);
        Set<BoardPosition> pos;

        king.setPosition(BoardPosition.A8);
        pos = king.getAvailablePositions();

        Assert.assertNotNull(king);
        Assert.assertEquals(3, pos.size());
    }

    @Test
    public void getAvailablePositionsNOK() throws Exception {
        // TODO Test here.
    }
}
