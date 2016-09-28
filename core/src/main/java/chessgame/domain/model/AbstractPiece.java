package chessgame.domain.model;

import chessgame.domain.Piece;

abstract class AbstractPiece implements Piece {

    private BoardPosition position;

    public BoardPosition getPosition() {
        return position;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }
}
