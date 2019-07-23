package chessgame.domain.model;

import chessgame.domain.Piece;

/**
 * Abstract class of chess piece with common state and behaviour.
 *
 * @author Prestes, E. M.
 * @see Piece
 * @see BoardPosition
 * @since September 2016
 */
abstract class AbstractPiece implements Piece {

    private final Board board;

    private final PieceColor color;

    private BoardPosition position;

    /**
     * AbstractPiece's construtor.
     *
     * @param board Board informed.
     * @param color Color informed.
     */
    AbstractPiece(Board board, PieceColor color) {
        super();

        this.board = board;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PieceColor getColor() {
        return color;
    }

    /** {@inheritDoc} */
    @Override
    public BoardPosition getPosition() {
        return position;
    }

    /** {@inheritDoc} */
    @Override
    public Piece setPosition(BoardPosition position) {
        this.position = position;
        return this;
    }

    @Override
    public void move(BoardPosition position) {
        getBoard().put(getPosition(), null);
        setPosition(position);
        getBoard().put(getPosition(), this);
    }
}
