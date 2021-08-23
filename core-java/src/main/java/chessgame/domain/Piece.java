package chessgame.domain;

import java.io.Serializable;
import java.util.Set;

import static java.util.stream.Stream.of;

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

    /**
     * Recovery current position of chess piece.
     *
     * @return String
     */
    default String getPositionAsString() {
        return "" + getPosition();
    }

    /**
     * Recover unicode value of this piece.
     *
     * @return String
     */
    String getUniCode();

    /**
     * Recover html code value of thsi piece.
     *
     * @return String
     */
    String getHtmlCode();

    /**
     * Recovery available positions of a piece.
     *
     * @return Set
     */
    Set<BoardPosition> getAvailablePositions();

    /**
     * Count and recover the size of available positions.
     *
     * @return int
     */
    default int availablePositionsSize() {
        return getAvailablePositions().size();
    }

    /**
     * Move this piece to the position informed.
     *
     * @param position Position informed.
     * @return Actual piece reference
     */
    Piece moveTo(BoardPosition... position);

    /**
     * Move this piece to the position informed.
     *
     * @param positions String positions informed.
     * @return Actual piece reference
     */
    default Piece moveTo(String... positions) {
        return moveTo(of(positions)
                .filter(position -> !position.isEmpty())
                .filter(position -> !position.isBlank())
                .map(BoardPosition::valueOf)
                .toArray(BoardPosition[]::new));
    }
}
