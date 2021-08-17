package chessgame.domain.model;

import chessgame.domain.Board;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static chessgame.domain.model.PieceColor.BLACK;
import static chessgame.domain.model.PieceColor.WHITE;

/**
 * Pawn of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
abstract class AbstractPawn extends AbstractPiece {

    private final Map<PieceColor, Function<BoardPosition, BoardPosition>> map;

    /**
     * Pawn's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @param uniCode Unicode.
     * @param htmlCode HTML code (decimal).
     * @see BoardPosition
     * @see PieceColor
     */
    AbstractPawn(Board board, PieceColor color, String uniCode, String htmlCode) {
        super(board, color, uniCode, htmlCode);

        map = Map.of(
                WHITE, BoardPosition::nextRow,
                BLACK, BoardPosition::previousRow);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final Set<BoardPosition> availablePositions = new LinkedHashSet<>();

        map.forEach((color, positionFunction) -> Optional.of(this)
                .filter(piece -> color.equals(piece.getColor()))
                .map(AbstractPawn::getPosition)
                .map(positionFunction)
                .filter(this::isEmptyBoardPosition)
                .filter(availablePositions::add)
                .filter(position -> this.isInitialPosition())
                .map(positionFunction)
                .filter(this::isEmptyBoardPosition)
                .filter(availablePositions::add));

        return availablePositions;
    }
}
