package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

/**
 * White pawn instances of a chess game board.
 *
 * @author Prestes, E. M.
 * @see AbstractPawn
 * @see Board
 * @since August 2021
 */
public class WhitePawn extends AbstractPawn {

    /**
     * Constructor compose by a board.
     *
     * @param board Board informed
     */
    public WhitePawn(Board board) {
        super(board, WHITE, "\u2659", "&#9817;");
    }
}
