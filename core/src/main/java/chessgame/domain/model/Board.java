package chessgame.domain.model;

import chessgame.domain.Piece;
import chessgame.domain.Player;

import java.util.TreeMap;

public class Board extends TreeMap<BoardPosition, Piece> {

    private final Player white;

    private final Player black;

    public Board() {
        super();

        this.white = new HumanPlayer();
        this.black = new HumanPlayer();

        init();
    }

    public Board init() {
        // TODO Implementation here.
        return this;
    }
}
