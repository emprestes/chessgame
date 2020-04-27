package chessgame.domain.model;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toSet;

/**
 * Knight of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
abstract class AbstractKnight extends AbstractPiece {

    /**
     * Knight's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @param uniCode Unicode.
     * @param htmlCode HTML code (decimal).
     * @see BoardPosition
     * @see PieceColor
     */
    AbstractKnight(Board board, PieceColor color, String uniCode, String htmlCode) {
        super(board, color, uniCode, htmlCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        return List.of(
                getPosition(myPosition.nextColumn(), BoardPosition::nextRow, BoardPosition::nonLastRow),
                getPosition(myPosition.nextColumn(), BoardPosition::previousRow, BoardPosition::nonFirstRow),
                getPosition(myPosition.nextRow(), BoardPosition::nextColumn, BoardPosition::nonLastColumn),
                getPosition(myPosition.nextRow(), BoardPosition::previousColumn, BoardPosition::nonFirstColumn),
                getPosition(myPosition.previousRow(), BoardPosition::nextColumn, BoardPosition::nonLastColumn),
                getPosition(myPosition.previousRow(), BoardPosition::previousColumn, BoardPosition::nonFirstColumn),
                getPosition(myPosition.previousColumn(), BoardPosition::nextRow, BoardPosition::nonLastRow),
                getPosition(myPosition.previousColumn(), BoardPosition::previousRow, BoardPosition::nonFirstRow))
                .stream()
                .filter(myPosition::nonEquals)
                .filter(this::isEmptyBoardPosition)
                .collect(toSet());
    }

    private BoardPosition getPosition(BoardPosition position,
                                      Function<BoardPosition, BoardPosition> mapFunction,
                                      Predicate<BoardPosition> filterFunction) {
        return getPosition(position, 2, mapFunction, filterFunction);
    }

    private BoardPosition getPosition(BoardPosition actualPosition, final int move,
                                      Function<BoardPosition, BoardPosition> mapFunction,
                                      Predicate<BoardPosition> filterFunction) {
        return of(of(actualPosition)
                .filter(getPosition()::nonEquals)
                .filter(filterFunction)
                .filter(position -> move > 0)
                .map(mapFunction)
                .map(position -> getPosition(position, move - 1, mapFunction, filterFunction))
                .orElse(actualPosition))
                .filter(position -> actualPosition.nonEquals(position) || move == 0)
                .orElse(getPosition());
    }
}
