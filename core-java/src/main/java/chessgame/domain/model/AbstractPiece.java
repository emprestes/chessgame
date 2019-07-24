package chessgame.domain.model;

import chessgame.domain.Piece;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.util.Objects.nonNull;

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

    private void collectPreviousColumns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::previousColumn);
    }

    private void collectNextColumns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::nextColumn);
    }

    private void collectPreviousRows(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::previousRow);
    }

    private void collectNextRows(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::nextRow);
    }

    private Set<BoardPosition> collectDiagonalLeft(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectDiagonalLeftUp(position, availablePositions);
        collectDiagonalLeftDowns(position, availablePositions);

        return availablePositions;
    }

    private void collectDiagonalLeftUp(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::diagonalLeftUp);
    }

    private void collectDiagonalLeftDowns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::diagonalLeftDown);
    }

    private Set<BoardPosition> collectDiagonalRight(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectDiagonalRightUp(position, availablePositions);
        collectDiagonalRightDown(position, availablePositions);

        return availablePositions;
    }

    private void collectDiagonalRightUp(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::diagonalRightUp);
    }

    private void collectDiagonalRightDown(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, availablePositions, BoardPosition::diagonalRightDown);
    }

    private void collect(BoardPosition position,
                         Set<BoardPosition> availablePositions,
                         Function<BoardPosition, BoardPosition> updatePosition) {
        final BoardPosition newPosition = updatePosition.apply(position);
        final Piece piece = getBoard().get(newPosition);

        if (position.equals(newPosition) || nonNull(piece)) {
            return;
        }

        availablePositions.add(newPosition);
        collect(newPosition, availablePositions, updatePosition);
    }

    Set<BoardPosition> collectColumns(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectPreviousColumns(position, availablePositions);
        collectNextColumns(position, availablePositions);

        return availablePositions;
    }

    Set<BoardPosition> collectDiagonals(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        availablePositions.addAll(collectDiagonalLeft(position));
        availablePositions.addAll(collectDiagonalRight(position));

        return availablePositions;
    }

    Set<BoardPosition> collectRows(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectPreviousRows(position, availablePositions);
        collectNextRows(position, availablePositions);

        return availablePositions;
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
