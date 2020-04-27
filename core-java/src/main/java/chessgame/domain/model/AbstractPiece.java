package chessgame.domain.model;

import chessgame.domain.Piece;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.util.Objects.isNull;

/**
 * Abstract class of chess piece with common state and behaviour.
 *
 * @author Prestes, E. M.
 * @see Piece
 * @see BoardPosition
 * @since September 2016
 */
abstract class AbstractPiece implements Piece {

    private String uniCode;

    private String htmlCode;

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
    AbstractPiece(Board board, PieceColor color, String uniCode, String htmlCode) {
        super();

        this.board = board;
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

    @Override
    public Piece moveTo(BoardPosition position) {
        Optional.of(this)
                .filter(piece -> isNull(piece.position))
                .ifPresent(piece -> {
                    piece.setInitialPosition(position);
                    piece.setPosition(position);
                });

        getAvailablePositions().stream()
                .filter(position::equals)
                .findFirst()
                .ifPresent(availablePosition -> getBoard().put(availablePosition, this));

        return this;
    }

    Boolean isEmptyBoardPosition(BoardPosition position) {
        return isNull(board.get(position));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s %s @ %s", getColor(), getClass().getSimpleName(), getPosition());
    }
}
