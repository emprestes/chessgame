package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

public class WhiteRook extends AbstractRook {

    public WhiteRook(Board board) {
        super(board, WHITE, "\u2656", "&#9814;");
    }
}
