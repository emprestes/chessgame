package chessgame.domain;

public interface Board {

    void init();

    void start();

    Piece get(BoardPosition key);

    Piece get(String key);

    Piece put(BoardPosition key, Piece value);
}
