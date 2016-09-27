package chessgame.domain.model;

import java.util.Collections;
import java.util.Set;

public class Queen extends AbstractPiece {

    @Override
    public Set<BoardPosition> getAvailablePosition() {
        // TODO Implementation here.
        return Collections.emptySet();
    }
}
