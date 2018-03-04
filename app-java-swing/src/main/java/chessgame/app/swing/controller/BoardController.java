package chessgame.app.swing.controller;

import chessgame.app.swing.Controller;
import chessgame.app.swing.View;
import chessgame.app.swing.view.BoardView;

import java.awt.Dimension;
import java.util.Arrays;

/**
 * Chessboard controller.
 *
 * @author Prestes, E. M.
 * @see BoardView
 * @see Controller
 * @see Dimension
 * @since October 2016
 */
public class BoardController implements Controller {

    private static final String[] COLS_LABEL = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private static final Integer[] ROWS_LABEL = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final String[] PIECES = {
            "A8:&#9820;", "B8:&#9822;", "C8:&#9821;", "D8:&#9819;",
            "E8:&#9818;", "F8:&#9821;", "G8:&#9822;", "H8:&#9820;",
            "A7:&#9823;", "B7:&#9823;", "C7:&#9823;", "D7:&#9823;",
            "E7:&#9823;", "F7:&#9823;", "G7:&#9823;", "H7:&#9823;",
            "A2:&#9817;", "B2:&#9817;", "C2:&#9817;", "D2:&#9817;",
            "E2:&#9817;", "F2:&#9817;", "G2:&#9817;", "H2:&#9817;",
            "A1:&#9814;", "B1:&#9816;", "C1:&#9815;", "D1:&#9813;",
            "E1:&#9812;", "F1:&#9815;", "G1:&#9816;", "H1:&#9814;"
    };

    private final Dimension size;
    private final BoardView view;

    /**
     * Default constructor.
     */
    public BoardController() {
        super();

        this.size = new Dimension(500, 500);
        this.view = new BoardView(COLS_LABEL, ROWS_LABEL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView() {
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return "Chess Game";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getSize() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initMatch() {
        String[] piece;
        for (String i : PIECES) {
            piece = i.split(":");
            view.add(piece[0], piece[1]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getLabelEast() {
        return Arrays.copyOf(ROWS_LABEL, ROWS_LABEL.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getLabelWest() {
        return Arrays.copyOf(ROWS_LABEL, ROWS_LABEL.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getLabelNorth() {
        return Arrays.copyOf(COLS_LABEL, COLS_LABEL.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getLabelSouth() {
        return Arrays.copyOf(COLS_LABEL, COLS_LABEL.length);
    }
}
