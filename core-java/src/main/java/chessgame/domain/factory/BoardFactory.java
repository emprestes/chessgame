package chessgame.domain.factory;

import chessgame.domain.Board;
import chessgame.domain.model.ChessBoard;

/**
 * Factory of chess board instances.
 *
 * @author Prestes, E. M.
 * @see Board
 * @see ChessBoard
 * @since August 2021
 */
public final class BoardFactory {

    /**
     * Private default constructor.
     */
    private BoardFactory() {
        super();
    }

    /**
     * Create a chess board instance.
     *
     * @return ChessBoard
     */
    public static Board createBoard() {
        return new ChessBoard();
    }
}
