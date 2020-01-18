package chessgame.domain;

import java.io.Serializable;

/**
 * Player of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.model.HumanPlayer
 * @see java.io.Serializable
 * @since September 2016
 */
public interface Player extends Serializable {

    /**
     * Add a piece to a player.
     *
     * @param piece Piece informed.
     * @return Player
     */
    Player add(Piece piece);
}
