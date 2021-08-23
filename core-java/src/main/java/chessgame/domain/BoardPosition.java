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
    A1(1, 1, DARK), A2(1, 2, LIGHT), A3(1, 3, DARK), A4(1, 4, LIGHT),
    A5(1, 5, DARK), A6(1, 6, LIGHT), A7(1, 7, DARK), A8(1, 8, LIGHT),
    B1(2, 1, LIGHT), B2(2, 2, DARK), B3(2, 3, LIGHT), B4(2, 4, DARK),
    B5(2, 5, LIGHT), B6(2, 6, DARK), B7(2, 7, LIGHT), B8(2, 8, DARK),
    C1(3, 1, DARK), C2(3, 2, LIGHT), C3(3, 3, DARK), C4(3, 4, LIGHT),
    C5(3, 5, DARK), C6(3, 6, LIGHT), C7(3, 7, DARK), C8(3, 8, LIGHT),
    D1(4, 1, LIGHT), D2(4, 2, DARK), D3(4, 3, LIGHT), D4(4, 4, DARK),
    D5(4, 5, LIGHT), D6(4, 6, DARK), D7(4, 7, LIGHT), D8(4, 8, DARK),
    E1(5, 1, DARK), E2(5, 2, LIGHT), E3(5, 3, DARK), E4(5, 4, LIGHT),
    E5(5, 5, DARK), E6(5, 6, LIGHT), E7(5, 7, DARK), E8(5, 8, LIGHT),
    F1(6, 1, LIGHT), F2(6, 2, DARK), F3(6, 3, LIGHT), F4(6, 4, DARK),
    F5(6, 5, LIGHT), F6(6, 6, DARK), F7(6, 7, LIGHT), F8(6, 8, DARK),
    G1(7, 1, DARK), G2(7, 2, LIGHT), G3(7, 3, DARK), G4(7, 4, LIGHT),
    G5(7, 5, DARK), G6(7, 6, LIGHT), G7(7, 7, DARK), G8(7, 8, LIGHT),
    H1(8, 1, LIGHT), H2(8, 2, DARK), H3(8, 3, LIGHT), H4(8, 4, DARK),
    H5(8, 5, LIGHT), H6(8, 6, DARK), H7(8, 7, LIGHT), H8(8, 8, DARK);

    private final int column;
    private final int row;
    private final BoardColor color;

    BoardPosition(int column, int row, BoardColor color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    public BoardPosition nextColumn() {
        return Optional.of(this)
                .filter(BoardPosition::isLastColumn)
                .orElse(valueOf(this.column + 1, this.row));
    }

    public BoardPosition nextRow() {
        return Optional.of(this)
                .filter(BoardPosition::isLastRow)
                .orElse(valueOf(this.column, this.row + 1));
    }

    public BoardPosition previousRow() {
        return Optional.of(this)
                .filter(BoardPosition::isFirstRow)
                .orElse(valueOf(this.column, this.row - 1));
    }

    public BoardPosition previousColumn() {
        return Optional.of(this)
                .filter(BoardPosition::isFirstColumn)
                .orElse(valueOf(this.column - 1, this.row));
    }

    public BoardPosition diagonalRightUp() {
        return Optional.of(this)
                .filter(BoardPosition::nonLastColumn)
                .map(BoardPosition::nextColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonLastRow)
                .map(BoardPosition::nextRow)
                .orElse(this);
    }

    public BoardPosition diagonalRightDown() {
        return Optional.of(this)
                .filter(BoardPosition::nonLastColumn)
                .map(BoardPosition::nextColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonFirstRow)
                .map(BoardPosition::previousRow)
                .orElse(this);
    }

    public BoardPosition diagonalLeftUp() {
        return Optional.of(this)
                .filter(BoardPosition::nonFirstColumn)
                .map(BoardPosition::previousColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonLastRow)
                .map(BoardPosition::nextRow)
                .orElse(this);
    }

    public BoardPosition diagonalLeftDown() {
        return Optional.of(this)
                .filter(BoardPosition::nonFirstColumn)
                .map(BoardPosition::previousColumn)
                .filter(this::nonEquals)
                .filter(BoardPosition::nonFirstRow)
                .map(BoardPosition::previousRow)
                .orElse(this);
    }

    public Boolean isFirstColumn() {
        return this.column == 1;
    }

    public Boolean nonFirstColumn() {
        return !isFirstColumn();
    }

    public Boolean isLastColumn() {
        return this.column == 8;
    }

    public Boolean nonLastColumn() {
        return !isLastColumn();
    }

    public Boolean isFirstRow() {
        return this.row == 1;
    }

    public Boolean nonFirstRow() {
        return !isFirstRow();
    }

    public Boolean isLastRow() {
        return this.row == 8;
    }

    public Boolean nonLastRow() {
        return !isLastRow();
    }

    public Boolean nonEquals(BoardPosition position) {
        return !this.equals(position);
    }

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
