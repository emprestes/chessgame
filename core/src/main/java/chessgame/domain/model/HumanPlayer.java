package chessgame.domain.model;

import chessgame.domain.Piece;
import chessgame.domain.Player;

import java.util.Set;
import java.util.TreeSet;

public class HumanPlayer implements Player {

    private final Set<Piece> pieces;

    public HumanPlayer() {
        super();

        this.pieces = new TreeSet<>();
    }

    @Override
    public Player add(Piece piece) {
        pieces.add(piece);
        return this;
    }
}
