package chessgame.domain.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

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
        final Board board = getBoard();
        return List.of(myPosition.nextRow(), myPosition.previousRow(),
                myPosition.nextColumn(), myPosition.previousColumn(),
                myPosition.diagonalLeftDown(), myPosition.diagonalLeftUp(),
                myPosition.diagonalRightDown(), myPosition.diagonalRightUp()).stream()
                .filter(position -> !position.equals(myPosition))
                .filter(position -> isNull(board.get(position)))
                .collect(Collectors.toSet());
    }
}
