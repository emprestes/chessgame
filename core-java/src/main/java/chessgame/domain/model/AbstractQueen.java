package chessgame.domain.model;

import chessgame.domain.Board;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Queen of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
abstract class AbstractQueen extends AbstractPiece {

    /**
     * Queen's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @param uniCode Unicode.
     * @param htmlCode HTML code (decimal).
     * @see BoardPosition
     * @see PieceColor
     */
    AbstractQueen(Board board, PieceColor color, String uniCode, String htmlCode) {
        super(board, color, uniCode, htmlCode);
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
