package chessgame.domain;

import chessgame.domain.model.BoardPosition;

import java.io.Serializable;
import java.util.Set;

/**
 * Chess game piece with available behaviours to use into a game.
 *
 * @author Prestes, E. M.
 * @see Serializable
 * @since September 2016
 */
public interface Piece extends Serializable {

    /**
     * Recovering available positions of a piece.
     *
     * @return Set
     */
    Set<BoardPosition> getAvailablePositions();
}