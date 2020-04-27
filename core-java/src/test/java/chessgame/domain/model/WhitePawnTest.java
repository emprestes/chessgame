package chessgame.domain.model;

import chessgame.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static chessgame.domain.factory.PieceFactory.createWhitePawn;
import static chessgame.domain.model.BoardPosition.D2;
import static chessgame.domain.model.BoardPosition.D3;
import static chessgame.domain.model.BoardPosition.D4;
import static chessgame.domain.model.BoardPosition.D5;
import static chessgame.domain.model.BoardPosition.D6;
import static chessgame.domain.model.BoardPosition.D7;
import static chessgame.domain.model.BoardPosition.D8;
import static chessgame.domain.model.PieceColor.WHITE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WhitePawnTest {

    private static final BoardPosition INITIAL_POSITION = D2;

    private Board board;

    private Piece whitePawn;

    @Before
    public void setUp() {
        board = new Board();
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
    public void moveToD4Test() {
        assertNotNull(board.get(INITIAL_POSITION.toString()));
        assertNull(board.get(D4));

        whitePawn.moveTo(D4);

        assertNull(board.get(INITIAL_POSITION));
        assertNotNull(board.get("D4"));
    }

    @Test
    public void getAvailablePositionsFromD3Test() {
        final Set<BoardPosition> pos = whitePawn
                .moveTo("D3")
                .getAvailablePositions();
        assertEquals(1, pos.size());
    }

    @Test
    public void getAvailablePositionsFromD8Test() {
        final Set<BoardPosition> pos = whitePawn
                .moveTo(D3)
                .moveTo(D4)
                .moveTo(D5)
                .moveTo(D6)
                .moveTo(D7)
                .moveTo(D8)
                .getAvailablePositions();
        assertEquals(0, pos.size());
    }
}
