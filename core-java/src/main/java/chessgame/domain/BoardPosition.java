package chessgame.domain;

import java.util.Arrays;
import java.util.Optional;

import static chessgame.domain.BoardColor.DARK;
import static chessgame.domain.BoardColor.LIGHT;

/**
 * Positions of Chessboard.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public enum BoardPosition {
    /**
     * A1 position.
     */
    A1(1, 1, DARK),
    /**
     * A2 position.
     */
    A2(1, 2, LIGHT),
    /**
     * A3 position.
     */
    A3(1, 3, DARK),
    /**
     * A4 position.
     */
    A4(1, 4, LIGHT),
    /**
     * A5 position.
     */
    A5(1, 5, DARK),
    /**
     * A6 position.
     */
    A6(1, 6, LIGHT),
    /**
     * A7 position.
     */
    A7(1, 7, DARK),
    /**
     * A8 position.
     */
    A8(1, 8, LIGHT),
    /**
     * B1 position.
     */
    B1(2, 1, LIGHT),
    /**
     * B2 position.
     */
    B2(2, 2, DARK),
    /**
     * B3 position.
     */
    B3(2, 3, LIGHT),
    /**
     * B4 position.
     */
    B4(2, 4, DARK),
    /**
     * B5 position.
     */
    B5(2, 5, LIGHT),
    /**
     * B6 position.
     */
    B6(2, 6, DARK),
    /**
     * B7 position.
     */
    B7(2, 7, LIGHT),
    /**
     * B8 position.
     */
    B8(2, 8, DARK),
    /**
     * C1 position.
     */
    C1(3, 1, DARK),
    /**
     * C2 position.
     */
    C2(3, 2, LIGHT),
    /**
     * C3 position.
     */
    C3(3, 3, DARK),
    /**
     * C4 position.
     */
    C4(3, 4, LIGHT),
    /**
     * C5 position.
     */
    C5(3, 5, DARK),
    /**
     * C6 position.
     */
    C6(3, 6, LIGHT),
    /**
     * C7 position.
     */
    C7(3, 7, DARK),
    /**
     * C8 position.
     */
    C8(3, 8, LIGHT),
    /**
     * D1 position.
     */
    D1(4, 1, LIGHT),
    /**
     * D2 position.
     */
    D2(4, 2, DARK),
    /**
     * D3 position.
     */
    D3(4, 3, LIGHT),
    /**
     * D4 position.
     */
    D4(4, 4, DARK),
    /**
     * D5 position.
     */
    D5(4, 5, LIGHT),
    /**
     * D6 position.
     */
    D6(4, 6, DARK),
    /**
     * D7 position.
     */
    D7(4, 7, LIGHT),
    /**
     * D8 position.
     */
    D8(4, 8, DARK),
    /**
     * E1 position.
     */
    E1(5, 1, DARK),
    /**
     * E2 position.
     */
    E2(5, 2, LIGHT),
    /**
     * E3 position.
     */
    E3(5, 3, DARK),
    /**
     * E4 position.
     */
    E4(5, 4, LIGHT),
    /**
     * E5 position.
     */
    E5(5, 5, DARK),
    /**
     * E6 position.
     */
    E6(5, 6, LIGHT),
    /**
     * E7 position.
     */
    E7(5, 7, DARK),
    /**
     * E8 position.
     */
    E8(5, 8, LIGHT),
    /**
     * F1 position.
     */
    F1(6, 1, LIGHT),
    /**
     * F2 position.
     */
    F2(6, 2, DARK),
    /**
     * F3 position.
     */
    F3(6, 3, LIGHT),
    /**
     * F4 position.
     */
    F4(6, 4, DARK),
    /**
     * F5 position.
     */
    F5(6, 5, LIGHT),
    /**
     * F6 position.
     */
    F6(6, 6, DARK),
    /**
     * F7 position.
     */
    F7(6, 7, LIGHT),
    /**
     * F8 position.
     */
    F8(6, 8, DARK),
    /**
     * G1 position.
     */
    G1(7, 1, DARK),
    /**
     * G2 position.
     */
    G2(7, 2, LIGHT),
    /**
     * G3 position.
     */
    G3(7, 3, DARK),
    /**
     * G4 position.
     */
    G4(7, 4, LIGHT),
    /**
     * G5 position.
     */
    G5(7, 5, DARK),
    /**
     * G6 position.
     */
    G6(7, 6, LIGHT),
    /**
     * G7 position.
     */
    G7(7, 7, DARK),
    /**
     * G8 position.
     */
    G8(7, 8, LIGHT),
    /**
     * H1 position.
     */
    H1(8, 1, LIGHT),
    /**
     * H2 position.
     */
    H2(8, 2, DARK),
    /**
     * H3 position.
     */
    H3(8, 3, LIGHT),
    /**
     * H4 position.
     */
    H4(8, 4, DARK),
    /**
     * H5 position.
     */
    H5(8, 5, LIGHT),
    /**
     * H6 position.
     */
    H6(8, 6, DARK),
    /**
     * H7 position.
     */
    H7(8, 7, LIGHT),
    /**
     * H8 position.
     */
    H8(8, 8, DARK);

    private final int column;
    private final int row;
    private final BoardColor color;

    BoardPosition(int column, int row, BoardColor color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    /**
     * Go to the next column.
     *
     * @return BoardPosition
     */
    public BoardPosition nextColumn() {
        return Optional.of(this)
                .filter(BoardPosition::isLastColumn)
                .orElse(valueOf(this.column + 1, this.row));
    }

    /**
     * Go to the next row.
     *
     * @return BoardPosition
     */
    public BoardPosition nextRow() {
        return Optional.of(this)
                .filter(BoardPosition::isLastRow)
                .orElse(valueOf(this.column, this.row + 1));
    }

    /**
     * Go to the previous row.
     *
     * @return BoardPosition
     */
    public BoardPosition previousRow() {
        return Optional.of(this)
                .filter(BoardPosition::isFirstRow)
                .orElse(valueOf(this.column, this.row - 1));
    }

    /**
     * Go to the previous column.
     *
     * @return BoardPosition
     */
    public BoardPosition previousColumn() {
        return Optional.of(this)
                .filter(BoardPosition::isFirstColumn)
                .orElse(valueOf(this.column - 1, this.row));
    }

    /**
     * Go to the diagonal right up.
     *
     * @return BoardPosition
     */
    public BoardPosition diagonalRightUp() {
        return Optional.of(this)
                .filter(BoardPosition::nonLastColumn)
                .map(BoardPosition::nextColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonLastRow)
                .map(BoardPosition::nextRow)
                .orElse(this);
    }

    /**
     * Go to the diagonal right down.
     *
     * @return BoardPosition
     */
    public BoardPosition diagonalRightDown() {
        return Optional.of(this)
                .filter(BoardPosition::nonLastColumn)
                .map(BoardPosition::nextColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonFirstRow)
                .map(BoardPosition::previousRow)
                .orElse(this);
    }

    /**
     * Go to the diagonal left up.
     *
     * @return BoardPosition
     */
    public BoardPosition diagonalLeftUp() {
        return Optional.of(this)
                .filter(BoardPosition::nonFirstColumn)
                .map(BoardPosition::previousColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonLastRow)
                .map(BoardPosition::nextRow)
                .orElse(this);
    }

    /**
     * Go to the diagonal left down.
     *
     * @return BoardPosition
     */
    public BoardPosition diagonalLeftDown() {
        return Optional.of(this)
                .filter(BoardPosition::nonFirstColumn)
                .map(BoardPosition::previousColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonFirstRow)
                .map(BoardPosition::previousRow)
                .orElse(this);
    }

    /**
     * Check if this position is the first column.
     *
     * @return Boolean
     */
    public Boolean isFirstColumn() {
        return this.column == 1;
    }

    /**
     * Check if this position is not the first column.
     *
     * @return Boolean
     */
    public Boolean nonFirstColumn() {
        return !isFirstColumn();
    }

    /**
     * Check if this position is the last column.
     *
     * @return Boolean
     */
    public Boolean isLastColumn() {
        return this.column == 8;
    }

    /**
     * Check if this position is not the last column.
     *
     * @return Boolean
     */
    public Boolean nonLastColumn() {
        return !isLastColumn();
    }

    /**
     * Check if this position is the first row.
     *
     * @return Boolean
     */
    public Boolean isFirstRow() {
        return this.row == 1;
    }

    /**
     * Check if this position is not the first row.
     *
     * @return Boolean
     */
    public Boolean nonFirstRow() {
        return !isFirstRow();
    }

    /**
     * Check if this position is the last row.
     *
     * @return Boolean
     */
    public Boolean isLastRow() {
        return this.row == 8;
    }

    /**
     * Check if this position is not the last row.
     *
     * @return Boolean
     */
    public Boolean nonLastRow() {
        return !isLastRow();
    }

    /**
     * Check if both positions are not the same.
     *
     * @param position Position informed.
     * @return Boolean
     */
    public Boolean nonEquals(BoardPosition position) {
        return !this.equals(position);
    }

    /**
     * Recover the color of this piece.
     *
     * @return CharSequence
     */
    public CharSequence getColor() {
        return String.valueOf(color);
    }

    private BoardPosition valueOf(int column, int row) {
        return Arrays.stream(values())
                .filter(position -> position.column == column && position.row == row)
                .findFirst()
                .orElse(this);
    }
}
