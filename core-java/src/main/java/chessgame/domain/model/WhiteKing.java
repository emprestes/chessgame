package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White king instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractKing
 * @see Board
 * @since August 2021
 */
public class WhiteKing extends AbstractKing {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhiteKing(Board board) {
        super(board, WHITE, "\u2654", "&#9812;");
    }
}
