package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhiteKnight extends AbstractKnight {

    public WhiteKnight(Board board) {
        super(board, WHITE, "\u2658", "&#9816;");
    }
}
