package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

public class BlackBishop extends AbstractBishop {

    public BlackBishop(Board board) {
        super(board, BLACK, "\u265D", "&#9821;");
    }
}
