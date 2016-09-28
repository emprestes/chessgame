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

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public PieceColor getColor() {
        return color;
    }

    @Override
    public BoardPosition getPosition() {
        return position;
    }

    @Override
    public Piece setPosition(BoardPosition position) {
        this.position = position;
        return this;
    }
}
