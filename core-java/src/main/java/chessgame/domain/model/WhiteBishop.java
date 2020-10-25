package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhiteBishop extends AbstractBishop {

    public WhiteBishop(Board board) {
        super(board, WHITE, "\u2657", "&#9815;");
    }
}
