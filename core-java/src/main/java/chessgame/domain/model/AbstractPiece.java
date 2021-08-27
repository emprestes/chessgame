package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.BoardPosition;
import chessgame.domain.Piece;
import chessgame.domain.PieceColor;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.stream.Stream.of;

/**
 * Abstract class of chess piece with common state and behaviour.
 *
 * @author Prestes, E. M.
 * @see Piece
 * @see BoardPosition
 * @since September 2016
 */
abstract class AbstractPiece implements Piece {

    private final String name;
    private final String uniCode;
    private final String htmlCode;

    private final Board board;

    private final PieceColor color;

    private BoardPosition initialPosition;

    private BoardPosition position;

    /**
     * AbstractPiece's construtor.
     *
     * @param board Board informed.
     * @param color Color informed.
     */
    AbstractPiece(Board board, PieceColor color, String name, String uniCode, String htmlCode) {
        super();

        this.board = board;
        this.name = name;
        this.color = color;
        this.uniCode = uniCode;
        this.htmlCode = htmlCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUniCode() {
        return uniCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHtmlCode() {
        return htmlCode;
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

    Boolean isInitialPosition() {
        return initialPosition.equals(getPosition());
    }

    /** {@inheritDoc} */
    @Override
    public BoardPosition getPosition() {
        return position;
    }

    private void setInitialPosition(BoardPosition initialPosition) {
        this.initialPosition = initialPosition;
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
        Optional.of(position)
                .map(updatePosition)
                .filter(position::nonEquals)
                .filter(newPosition -> isNull(getBoard().get(newPosition)))
                .filter(availablePositions::add)
                .ifPresent(newPosition -> collect(newPosition, availablePositions, updatePosition));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Piece moveTo(BoardPosition... positions) {
        of(positions)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Impossible to move to empty position."));
        of(positions)
                .forEach(this::moveTo);

        return this;
    }

    private void moveTo(BoardPosition position) {
        moveToFirstPosition(position);

        getAvailablePositions().stream()
                .filter(position::equals)
                .findFirst()
                .ifPresent(availablePosition -> getBoard().put(availablePosition, this));

        checkInvalidPosition(position);
    }

    private void checkInvalidPosition(BoardPosition position) {
        if (getPosition().nonEquals(position)) {
            throw new IllegalStateException(
                    format("This %s has an impossible movement from %s to %s", getName(), getPosition(), position));
        }
    }

    private void moveToFirstPosition(BoardPosition position) {
        Optional.of(this)
                .filter(piece -> isNull(piece.position))
                .ifPresent(piece -> {
                    piece.setInitialPosition(position);
                    piece.setPosition(position);
                });
    }

    Boolean isEmptyBoardPosition(BoardPosition position) {
        return isNull(board.get(position));
    }

    String getName() {
        return String.format("%s %s", getColor(), name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPiece)) return false;
        AbstractPiece that = (AbstractPiece) o;
        return Objects.equals(name, that.name)
                && Objects.equals(getUniCode(), that.getUniCode())
                && Objects.equals(getHtmlCode(), that.getHtmlCode())
                && Objects.equals(getBoard(), that.getBoard())
                && getColor() == that.getColor()
                && initialPosition == that.initialPosition
                && getPosition() == that.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getUniCode(), getHtmlCode(), getBoard(), getColor(), initialPosition, getPosition());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return format("%s %s @ %s", getColor(), name, getPosition());
    }
}
