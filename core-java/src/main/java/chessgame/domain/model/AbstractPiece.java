package chessgame.domain.model;

import chessgame.domain.Piece;

import java.util.Objects;
import java.util.Optional;

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
    void setPosition(BoardPosition position) {
        this.position = position;
    }

    @Override
    public Piece moveTo(BoardPosition position) {
        Optional.of(this)
                .filter(piece -> Objects.isNull(piece.position))
                .ifPresent(piece -> piece.setPosition(position));

        getAvailablePositions().stream()
                .filter(position::equals)
                .findFirst()
                .ifPresent(availablePosition -> getBoard().put(availablePosition, this));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s %s @ %s", getColor(), getClass().getSimpleName(), getPosition());
    }
}
