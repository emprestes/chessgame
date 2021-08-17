package chessgame.domain.model;

public final class BoardFactory {

    private BoardFactory() {
        super();
    }

    public static DefaultBoard createBoard() {
        return new DefaultBoard();
    }
}
