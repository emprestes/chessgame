package chessgame.domain.model;

import java.util.Collections;
import java.util.Set;

/**
 * Pawn of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
public class Pawn extends AbstractPiece {

    /**
     * Pawn's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @see BoardPosition
     * @see PieceColor
     */
    public Pawn(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        // TODO Implementation here.
        return Collections.emptySet();
    }
}
