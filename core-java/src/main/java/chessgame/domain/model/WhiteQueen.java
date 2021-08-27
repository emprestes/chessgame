package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White queen instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractQueen
 * @see Board
 * @since August 2021
 */
public class WhiteQueen extends AbstractQueen {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhiteQueen(Board board) {
        super(board, WHITE, "\u2655", "&#9813;");
    }
}
