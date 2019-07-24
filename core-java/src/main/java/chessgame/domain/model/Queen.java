package chessgame.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Queen of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
public class Queen extends AbstractPiece {

    /**
     * Queen's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @see BoardPosition
     * @see PieceColor
     */
    public Queen(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        availablePositions.addAll(collectColumns(myPosition));
        availablePositions.addAll(collectRows(myPosition));
        availablePositions.addAll(collectDiagonals(myPosition));

        return availablePositions;
    }
}
