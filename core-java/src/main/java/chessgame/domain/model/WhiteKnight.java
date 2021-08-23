package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White knight instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractKnight
 * @see Board
 * @since August 2021
 */
public class WhiteKnight extends AbstractKnight {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhiteKnight(Board board) {
        super(board, WHITE, "\u2658", "&#9816;");
    }
}
