package chessgame.domain.model;

import chessgame.domain.Piece;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

import static java.util.Objects.nonNull;

/**
 * Queen of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
public class Queen extends AbstractPiece {

    /**
     * Queen's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @see BoardPosition
     * @see PieceColor
     */
    public Queen(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        availablePositions.addAll(collectColumns(myPosition));
        availablePositions.addAll(collectRows(myPosition));
        availablePositions.addAll(collectDiagonalRight(myPosition));
        availablePositions.addAll(collectDiagonalLeft(myPosition));

        return availablePositions;
    }

    private Set<BoardPosition> collectColumns(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectPreviousColumns(position, availablePositions);
        collectNextColumns(position, availablePositions);

        return availablePositions;
    }

    private void collectPreviousColumns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::previousColumn, availablePositions);
    }

    private void collectNextColumns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::nextColumn, availablePositions);
    }

    private Set<BoardPosition> collectRows(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectPreviousRows(position, availablePositions);
        collectNextRows(position, availablePositions);

        return availablePositions;
    }

    private void collectPreviousRows(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::previousRow, availablePositions);
    }

    private void collectNextRows(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::nextRow, availablePositions);
    }

    private Set<BoardPosition> collectDiagonalLeft(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectDiagonalLeftUp(position, availablePositions);
        collectDiagonalLeftDowns(position, availablePositions);

        return availablePositions;
    }

    private void collectDiagonalLeftUp(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::diagonalLeftUp, availablePositions);
    }

    private void collectDiagonalLeftDowns(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::diagonalLeftDown, availablePositions);
    }

    private Set<BoardPosition> collectDiagonalRight(BoardPosition position) {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        collectDiagonalRightUp(position, availablePositions);
        collectDiagonalRightDown(position, availablePositions);

        return availablePositions;
    }

    private void collectDiagonalRightUp(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::diagonalRightUp, availablePositions);
    }

    private void collectDiagonalRightDown(BoardPosition position, Set<BoardPosition> availablePositions) {
        collect(position, BoardPosition::diagonalRightDown, availablePositions);
    }

    private void collect(BoardPosition position,
                         Function<BoardPosition, BoardPosition> updatePosition,
                         Set<BoardPosition> availablePositions) {
        final BoardPosition newPosition = updatePosition.apply(position);
        final Piece piece = getBoard().get(newPosition);

        if (position.equals(newPosition) || nonNull(piece)) {
            return;
        }

        availablePositions.add(newPosition);
        collect(newPosition, updatePosition, availablePositions);
    }
}
