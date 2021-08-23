package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

/**
 * Black pawn instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractPawn
 * @see Board
 * @since August 2021
 */
public class BlackPawn extends AbstractPawn {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public BlackPawn(Board board) {
        super(board, BLACK, "\u265F", "&#9823;");
    }
}
