package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black king instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractKing
 * @see Board
 * @since August 2021
 */
public class BlackKing extends AbstractKing {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackKing(Board board) {
        super(board, BLACK, "\u265A", "&#9818;");
    }
}
