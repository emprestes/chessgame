package chessgame.app;

import chessgame.app.swing.Application;
import chessgame.app.swing.Controller;
import chessgame.app.swing.View;
import chessgame.app.swing.controller.BoardController;
import chessgame.app.swing.view.LabelView;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Chess extends Application {

    public static void main(String[] args) {
        launch(Chess.class, args);
    }

    @Override
    public void start(JFrame frame) throws Exception {
        Controller controller;
        View board, rows, cols;

        controller = new BoardController();
        rows = createRows(controller.getWest());
        frame.add(rows, BorderLayout.WEST);
        rows = createRows(controller.getEast());
        frame.add(rows, BorderLayout.EAST);

        board = controller.getView();
        frame.add(board, BorderLayout.CENTER);

        cols = createCols(controller.getNorth());
        frame.add(cols, BorderLayout.NORTH);
        cols = createCols(controller.getSouth());
        frame.add(cols, BorderLayout.SOUTH);

        frame.setTitle(controller.getTitle());
        frame.setSize(controller.getSize());
        frame.setVisible(Boolean.TRUE);
    }

    private View createCols(Object... items) {
        return LabelView.createCols(items);
    }

    private View createRows(Object... items) {
        return LabelView.createRows(items);
    }
}
