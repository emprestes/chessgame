package chessgame.app;

import chessgame.app.swing.Application;
import chessgame.app.swing.Controller;
import chessgame.app.swing.View;
import chessgame.app.swing.controller.BoardController;
import chessgame.app.swing.view.LabelView;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Chess game application.
 *
 * @author Prestes, E. M.
 * @see Application
 * @see Controller
 * @see View
 * @see JFrame
 * @see BoardController
 * @see BorderLayout
 * @since October 2016
 */
public class Chess extends Application {

    /**
     * Main behaviour.
     *
     * @param args Arguments informed.
     */
    public static void main(String[] args) {
        launch(Chess.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(JFrame frame) {
        Controller controller;
        View board, rows, cols;

        controller = new BoardController();
        rows = createRows(controller.getLabelWest());
        frame.add(rows, BorderLayout.WEST);
        rows = createRows(controller.getLabelEast());
        frame.add(rows, BorderLayout.EAST);

        board = controller.getView();
        frame.add(board, BorderLayout.CENTER);

        cols = createCols(controller.getLabelNorth());
        frame.add(cols, BorderLayout.NORTH);
        cols = createCols(controller.getLabelSouth());
        frame.add(cols, BorderLayout.SOUTH);

        controller.initMatch();

        frame.setTitle(controller.getTitle());
        frame.setSize(controller.getSize());
        frame.setVisible(Boolean.TRUE);
    }

    /**
     * Create labels for columns.
     *
     * @param items Labels informed.
     * @return View
     */
    private View createCols(Object... items) {
        return LabelView.createCols(items);
    }

    /**
     * Create labels for rows.
     *
     * @param items Labels informed.
     * @return View
     */
    private View createRows(Object... items) {
        return LabelView.createRows(items);
    }
}
