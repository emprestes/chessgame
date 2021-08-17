package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.model.PieceColor.WHITE;

public class WhiteQueen extends AbstractQueen {

    public WhiteQueen(Board board) {
        super(board, WHITE, "\u2655", "&#9813;");
    }
}
