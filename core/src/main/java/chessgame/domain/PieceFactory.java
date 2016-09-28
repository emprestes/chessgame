package chessgame.domain;

import chessgame.domain.exception.PieceException;
import chessgame.domain.model.Board;
import chessgame.domain.model.PieceColor;

final class PieceFactory {

    private PieceFactory() {
        super();
    }

    static Piece create(Board board, PieceColor color, Class<? extends Piece> _class) throws PieceException {
        try {
            return _class.getConstructor(Board.class, PieceColor.class).newInstance(board, color);
        } catch (ReflectiveOperationException cause) {
            throw new PieceException(cause);
        }
    }
}
