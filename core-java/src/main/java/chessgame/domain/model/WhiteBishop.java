package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

public class WhiteBishop extends AbstractBishop {

    public WhiteBishop(Board board) {
        super(board, WHITE, "\u2657", "&#9815;");
    }
}
