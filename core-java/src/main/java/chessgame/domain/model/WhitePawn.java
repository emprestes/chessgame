package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhitePawn extends AbstractPawn {

    public WhitePawn(Board board) {
        super(board, WHITE, "\u2659", "&#9817;");
    }
}
