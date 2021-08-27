package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black queen instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractQueen
 * @see Board
 * @since August 2021
 */
public class BlackQueen extends AbstractQueen {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackQueen(Board board) {
        super(board, BLACK, "\u265B", "&#9819;");
    }
}
