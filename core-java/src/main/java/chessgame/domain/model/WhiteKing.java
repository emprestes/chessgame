package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhiteKing extends AbstractKing {

    public WhiteKing(Board board) {
        super(board, WHITE, "\u2654", "&#9812;");
    }
}
