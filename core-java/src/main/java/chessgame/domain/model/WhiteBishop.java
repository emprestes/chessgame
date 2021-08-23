package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White bishop instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractBishop
 * @see Board
 * @since August 2021
 */
public class WhiteBishop extends AbstractBishop {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhiteBishop(Board board) {
        super(board, WHITE, "\u2657", "&#9815;");
    }
}
