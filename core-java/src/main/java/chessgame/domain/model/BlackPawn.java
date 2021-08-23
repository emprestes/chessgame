package chessgame.domain.model;

import chessgame.domain.Board;

import static chessgame.domain.PieceColor.BLACK;

public class BlackPawn extends AbstractPawn {

    public BlackPawn(Board board) {
        super(board, BLACK, "\u265F", "&#9823;");
    }
}
