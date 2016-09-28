package chessgame.domain.model;

import java.util.Collections;
import java.util.Set;

public class Bishop extends AbstractPiece {

    public Bishop(Board board, PieceColor color) {
        super(board, color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        // TODO Implementation here.
        return Collections.emptySet();
    }
}
