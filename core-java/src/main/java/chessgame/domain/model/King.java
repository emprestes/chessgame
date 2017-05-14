package chessgame.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * King of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
public class King extends AbstractPiece {

    /**
     * King's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @see BoardPosition
     * @see PieceColor
     */
    public King(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        BoardPosition myP = getPosition(), aP;
        Board b = getBoard();
        Object o;
        Set<BoardPosition> bps = new HashSet<>();

        aP = myP.nextRow();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.previousRow();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.nextColumn();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.previousColumn();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.diagonalLeftDown();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.diagonalLeftUp();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.diagonalRightDown();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }
        aP = myP.diagonalRightUp();
        o = b.get(aP);
        if (o == null) {
            bps.add(aP);
        }

        return bps;
    }
}
