package chessgame.app.swing.view;

import chessgame.app.swing.View;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * Chessboard view.
 *
 * @author Prestes, E. M.
 * @see View
 * @see GridLayout
 * @since October 2016
 */
public class BoardView extends View {

    private static final int COLS = 8;
    private static final int ROWS = 8;

    /**
     * Default constructor.
     */
    public BoardView() {
        super(new GridLayout(ROWS, COLS));

        init();
    }

    /**
     * Behaviour to initialize view.
     */
    private void init() {
        JPanel block;
        Color b, w;

        b = new Color(209, 139, 71);
        w = new Color(255, 206, 158);
        setLayout(new GridLayout(ROWS, COLS));

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                block = new JPanel();
                block.setBorder(BorderFactory.createEtchedBorder());
                block.setBackground((row % 2 != 0 && col % 2 != 0) || (row % 2 == 0 && col % 2 == 0) ? w : b);
                add(block);
            }
        }
    }
}
