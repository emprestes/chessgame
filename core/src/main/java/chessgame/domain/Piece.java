package chessgame.domain;

import chessgame.domain.model.BoardPosition;

import java.io.Serializable;

public interface Piece extends Serializable {

    BoardPosition getAvailablePosition();
}
