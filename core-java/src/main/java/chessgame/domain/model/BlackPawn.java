package chessgame.domain.model;

import static chessgame.domain.model.PieceColor.BLACK;

public class BlackPawn extends AbstractPawn {

    public BlackPawn(Board board) {
        super(board, BLACK, "\u265F", "&#9823;");
    }
}
