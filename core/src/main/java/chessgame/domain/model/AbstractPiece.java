package chessgame.domain.model;

import chessgame.domain.Piece;

abstract class AbstractPiece implements Piece {

    private final Board board;

    private final PieceColor color;

    private BoardPosition position;

    AbstractPiece(Board board, PieceColor color) {
        super();

        this.board = board;
        this.color = color;
    }

    public Board getBoard() {
        return board;
    }

    public PieceColor getColor() {
        return color;
    }

    public BoardPosition getPosition() {
        return position;
    }

    public void setPosition(BoardPosition position) {
        this.position = position;
    }
}
