package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhitePawn extends AbstractPawn {

    public WhitePawn(Board board) {
        super(board, WHITE, "\u2659", "&#9817;");
    }
}
