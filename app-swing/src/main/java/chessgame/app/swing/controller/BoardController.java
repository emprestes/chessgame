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

    private final Dimension size;
    private final BoardView view;

    /**
     * Default constructor.
     */
    public BoardController() {
        super();

        this.size = new Dimension(500, 500);
        this.view = new BoardView();
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
