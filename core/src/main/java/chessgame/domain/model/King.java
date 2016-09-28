package chessgame.domain.model;

import java.util.Collections;
import java.util.Set;

public class King extends AbstractPiece {

    public King(Board board, PieceColor color) {
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
