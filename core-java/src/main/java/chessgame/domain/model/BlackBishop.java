package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black bishop instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractBishop
 * @see Board
 * @since August 2021
 */
public class BlackBishop extends AbstractBishop {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackBishop(Board board) {
        super(board, BLACK, "\u265D", "&#9821;");
    }
}
