package chessgame.domain;

import java.io.Serializable;

public interface Player extends Serializable {

    Player add(Piece piece);
}
