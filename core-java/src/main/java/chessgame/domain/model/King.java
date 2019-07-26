package chessgame.domain.model;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * King of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
public class King extends AbstractPiece {

    /**
     * King's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @see BoardPosition
     * @see PieceColor
     */
    public King(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        return List.of(myPosition.nextRow(), myPosition.previousRow(),
                myPosition.nextColumn(), myPosition.previousColumn(),
                myPosition.diagonalLeftDown(), myPosition.diagonalLeftUp(),
                myPosition.diagonalRightDown(), myPosition.diagonalRightUp()).stream()
                .filter(myPosition::nonEquals)
                .filter(this::isEmptyBoardPosition)
                .collect(toSet());
    }
}
