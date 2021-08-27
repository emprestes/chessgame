package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.BoardPosition;
import chessgame.domain.PieceColor;

import java.util.Set;

/**
 * Bishop of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
abstract class AbstractBishop extends AbstractPiece {

    /**
     * Bishop's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @param uniCode Unicode.
     * @param htmlCode HTML code (decimal).
     * @see BoardPosition
     * @see PieceColor
     */
    AbstractBishop(Board board, PieceColor color, String uniCode, String htmlCode) {
        super(board, color, "Bishop", uniCode, htmlCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        return collectDiagonals(myPosition);
    }
}
