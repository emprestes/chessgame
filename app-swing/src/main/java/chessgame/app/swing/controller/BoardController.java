package chessgame.app.swing.controller;

import chessgame.app.swing.Controller;
import chessgame.app.swing.View;
import chessgame.app.swing.view.BoardView;

import java.awt.Dimension;
import java.util.Arrays;

public class BoardController extends Controller {

    private static final Integer[] COLS_LABEL = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final String[] ROWS_LABEL = {"A", "B", "C", "D", "E", "F", "G", "H"};

    private final Dimension size;
    private final BoardView view;

    public BoardController() {
        super();

        this.size = new Dimension(600, 600);
        this.view = new BoardView();
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public String getTitle() {
        return "Chessgame";
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public Object[] getEast() {
        return Arrays.copyOf(ROWS_LABEL, ROWS_LABEL.length);
    }

    @Override
    public Object[] getWest() {
        return Arrays.copyOf(ROWS_LABEL, ROWS_LABEL.length);
    }

    @Override
    public Object[] getNorth() {
        return Arrays.copyOf(COLS_LABEL, COLS_LABEL.length);
    }

    @Override
    public Object[] getSouth() {
        return Arrays.copyOf(COLS_LABEL, COLS_LABEL.length);
    }
}
