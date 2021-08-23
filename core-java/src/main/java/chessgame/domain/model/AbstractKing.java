package chessgame.domain.model;

import chessgame.domain.Board;
import chessgame.domain.BoardPosition;
import chessgame.domain.PieceColor;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * King of Chess game.
 *
 * @author Prestes, E. M.
 * @see chessgame.domain.Piece
 * @since September 2016
 */
abstract class AbstractKing extends AbstractPiece {

    /**
     * King's constructor.
     *
     * @param board Board informed.
     * @param color Color informed.
     * @param uniCode Unicode.
     * @param htmlCode HTML code (decimal).
     * @see BoardPosition
     * @see PieceColor
     */
    AbstractKing(Board board, PieceColor color, String uniCode, String htmlCode) {
        super(board, color, uniCode, htmlCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        final BoardPosition myPosition = getPosition();
        return Stream.of(myPosition.nextRow(), myPosition.previousRow(),
                        myPosition.nextColumn(), myPosition.previousColumn(),
                        myPosition.diagonalLeftDown(), myPosition.diagonalLeftUp(),
                        myPosition.diagonalRightDown(), myPosition.diagonalRightUp())
                .filter(myPosition::nonEquals)
                .filter(this::isEmptyBoardPosition)
                .collect(toSet());
    }
}
