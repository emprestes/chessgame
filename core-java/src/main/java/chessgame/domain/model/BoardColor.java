package chessgame.domain.model;

/**
 * Colors of Chessboard.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public enum BoardColor {
    LIGHT("#FFCE9E;"), DARK("#D18B47;");

    private final String color;

    BoardColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
