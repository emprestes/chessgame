package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.BLACK;

public class BlackRook extends AbstractRook {

    public BlackRook(Board board) {
        super(board, BLACK, "\u265C", "&#9820;");
    }
}
