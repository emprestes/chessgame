package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.model.PieceColor.BLACK;

public class BlackKing extends AbstractKing {

    public BlackKing(Board board) {
        super(board, BLACK, "\u265A", "&#9818;");
    }
}
