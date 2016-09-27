package chessgame.domain;

import chessgame.domain.model.BoardPosition;

import java.io.Serializable;
import java.util.Set;


public interface Piece extends Serializable {

    Set<BoardPosition> getAvailablePosition();
}
