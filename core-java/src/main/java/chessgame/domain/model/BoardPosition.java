package chessgame.domain.model;

/**
 * Positions of Chessboard.
 *
 * @author Prestes, E. M.
 * @since September 2016
 */
public enum BoardPosition {
    A1(1, 1), A2(1, 2), A3(1, 3), A4(1, 4), A5(1, 5), A6(1, 6), A7(1, 7), A8(1, 8),
    B1(2, 1), B2(2, 1), B3(2, 1), B4(2, 1), B5(2, 1), B6(2, 1), B7(2, 1), B8(2, 1),
    C1(3, 1), C2(3, 1), C3(3, 1), C4(3, 1), C5(3, 1), C6(3, 1), C7(3, 1), C8(3, 1),
    D1(4, 1), D2(4, 1), D3(4, 1), D4(4, 1), D5(4, 1), D6(4, 1), D7(4, 1), D8(4, 1),
    E1(5, 1), E2(5, 1), E3(5, 1), E4(5, 1), E5(5, 1), E6(5, 1), E7(5, 1), E8(5, 1),
    F1(6, 1), F2(6, 1), F3(6, 1), F4(6, 1), F5(6, 1), F6(6, 1), F7(6, 1), F8(6, 1),
    G1(7, 1), G2(7, 1), G3(7, 1), G4(7, 1), G5(7, 1), G6(7, 1), G7(7, 1), G8(7, 1),
    H1(8, 1), H2(8, 1), H3(8, 1), H4(8, 1), H5(8, 1), H6(8, 1), H7(8, 1), H8(8, 1);

    private int column;
    private int row;

    BoardPosition(int column, int row) {
        this.column = column;
        this.row = row;
    }
}
