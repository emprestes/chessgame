package chessgame.domain.model;

import chessgame.domain.Piece;
import chessgame.domain.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation for human player of chess game.
 *
 * @author Prestes, E. M.
 * @see Player
 * @since September 2016
 */
public class HumanPlayer implements Player {

    private final Set<Piece> pieces = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Player add(Piece piece) {
        pieces.add(piece);
        return this;
    }
}
