package chessgame.domain;

/**
 * Interface of a chess board.
 *
 * @author Prestes, E. M.
 * @see BoardPosition
 * @see Piece
 * @since August 2021
 */
public interface Board {

    /**
     * Initialize an empty board.
     */
    void init();

    /**
     * Initialize a game.
     */
    void start();

    /**
     * Recover a piece from a board position.
     *
     * @param key Position informed.
     * @return Piece
     */
    Piece get(BoardPosition key);

    /**
     * Recover a piece from a board position.
     *
     * @param key String position informed.
     * @return Piece
     */
    default Piece get(String key) {
        return get(BoardPosition.valueOf(key));
    }

    /**
     * Put a piece into a position.
     *
     * @param key   Position informed.
     * @param value Piece informed.
     * @return Piece
     */
    Piece put(BoardPosition key, Piece value);
}
