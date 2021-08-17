package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.model.PieceColor.BLACK;

public class BlackQueen extends AbstractQueen {

    public BlackQueen(Board board) {
        super(board, BLACK, "\u265B", "&#9819;");
    }
}
