package chessgame.domain.model;

import java.util.Collections;
import java.util.Set;

public class Queen extends AbstractPiece {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BoardPosition> getAvailablePositions() {
        // TODO Implementation here.
        return Collections.emptySet();
    }
}
