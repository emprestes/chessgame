package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black rook instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractRook
 * @see Board
 * @since August 2021
 */
public class BlackRook extends AbstractRook {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackRook(Board board) {
        super(board, BLACK, "\u265C", "&#9820;");
    }
}
