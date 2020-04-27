package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhiteRook extends AbstractRook {

    public WhiteRook(Board board) {
        super(board, WHITE, "\u2656", "&#9814;");
    }
}
