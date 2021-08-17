package chessgame.domain;

import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.PieceColor;

import java.io.Serializable;
import java.util.Set;

/**
 * Interface of chess piece with available behaviours to use into a match.
 *
 * @author Prestes, E. M.
 * @see Serializable
 * @since September 2016
 */
public interface Piece extends Serializable {

    /**
     * Recovery current board.
     *
     * @return Board
     */
    Board getBoard();

    /**
     * Recovery current color of chess piece.
     *
     * @return PieceColor
     */
    PieceColor getColor();

    /**
     * Recovery current position of chess piece.
     *
     * @return BoardPosition
     */
    BoardPosition getPosition();

    String getUniCode();

    String getHtmlCode();

    /**
     * Recovery available positions of a piece.
     *
     * @return Set
     */
    Set<BoardPosition> getAvailablePositions();

    default int availablePositionsSize() {
        return getAvailablePositions().size();
    }

    /**
     * Move this piece to the position informed.
     *
     * @param position Position informed.
     * @return Actual piece reference
     */
    Piece moveTo(BoardPosition position);

    /**
     * Move this piece to the position informed.
     *
     * @param position String position informed.
     * @return Actual piece reference
     */
    default Piece moveTo(String position) {
        return moveTo(BoardPosition.valueOf(position));
    }
}
