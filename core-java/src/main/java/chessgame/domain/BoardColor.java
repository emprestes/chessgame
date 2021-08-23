package chessgame.domain;

/**
 * Colors of Chessboard.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public enum BoardColor {
    /**
     * Light color of a chess board position.
     */
    LIGHT("#FFCE9E;"),
    /**
     * Dark color of a chess board position.
     */
    DARK("#D18B47;");

    private final String color;

    BoardColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
