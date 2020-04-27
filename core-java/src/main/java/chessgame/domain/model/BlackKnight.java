package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.BLACK;

public class BlackKnight extends AbstractKnight {

    public BlackKnight(Board board) {
        super(board, BLACK, "\u265E", "&#9822;");
    }
}
