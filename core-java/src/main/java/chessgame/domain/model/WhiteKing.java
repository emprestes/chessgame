package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.WHITE;

public class WhiteKing extends AbstractKing {

    public WhiteKing(Board board) {
        super(board, WHITE, "\u2654", "&#9812;");
    }
}
