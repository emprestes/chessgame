package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black knight instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractKnight
 * @see Board
 * @since August 2021
 */
public class BlackKnight extends AbstractKnight {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackKnight(Board board) {
        super(board, BLACK, "\u265E", "&#9822;");
    }
}
