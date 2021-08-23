package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

public class BlackKnight extends AbstractKnight {

    public BlackKnight(Board board) {
        super(board, BLACK, "\u265E", "&#9822;");
    }
}
