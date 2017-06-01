package chessgame.domain;

import chessgame.domain.exception.PieceException;
import chessgame.domain.model.Board;
import chessgame.domain.model.BoardPosition;
import chessgame.domain.model.PieceColor;

/**
 * Factory to create chess pieces.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
final class PieceFactory {

    /**
     * Private default constructor.
     */
    private PieceFactory() {
        super();
    }

    /**
     * @param board    Board informed.
     * @param position Board position informed.
     * @param color    Piece color informed.
     * @param classs   Piece class informed.
     * @return Piece
     * @throws PieceException Throw this exception in a cause of instantiation problems.
     * @see Board
     * @see BoardPosition
     * @see PieceColor
     * @see Piece
     */
    static Piece create(Board board, BoardPosition position, PieceColor color, Class<? extends Piece> classs)
            throws PieceException {
        try {
            Piece piece = classs.getConstructor(Board.class, PieceColor.class)
                    .newInstance(board, color)
                    .setPosition(position);
            board.put(position, piece);
            return piece;
        } catch (ReflectiveOperationException cause) {
            throw new PieceException(cause);
        }
    }
}
