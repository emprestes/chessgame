package chessgame.domain.model;

import chessgame.domain.Piece;

abstract class AbstractPiece implements Piece {

    private PieceColor color;

    private BoardPosition position;

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public BoardPosition getPosition() {
        return position;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }
}
