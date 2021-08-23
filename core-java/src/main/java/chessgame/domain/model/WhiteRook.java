package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White rook instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractRook
 * @see Board
 * @since August 2021
 */
public class WhiteRook extends AbstractRook {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhiteRook(Board board) {
        super(board, WHITE, "\u2656", "&#9814;");
    }
}
