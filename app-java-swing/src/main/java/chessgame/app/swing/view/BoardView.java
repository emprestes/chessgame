package chessgame.app.swing.view;

import chessgame.app.swing.View;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
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

    /**
     * Constructor composing by columns and rows informed.
     *
     * @param cols Columns
     * @param rows Rows
     */
    public BoardView(String[] cols, Integer[] rows) {
        super(new GridLayout(cols.length, rows.length));

        init(cols, rows);
    }

    /**
     * Behaviour to initialize view.
     *
     * @param cols Columns on the board
     * @param rows Rows on the board
     */
    private void init(String[] cols, Integer[] rows) {
        JPanel block;
        String pos;
        Color b, w;

        b = new Color(209, 139, 71);
        w = new Color(255, 206, 158);

        for (int row = rows.length - 1; row >= 0; row--) {
            for (int col = 0; col < cols.length; col++) {
                block = new JPanel();
                pos = cols[col] + rows[row];
                block.setName(pos);
                block.setToolTipText(pos);
                block.setBorder(BorderFactory.createEtchedBorder());
                block.setBackground((row % 2 != 0 && col % 2 != 0) || (row % 2 == 0 && col % 2 == 0) ? b : w);
                add(block);
            }
        }
    }

    /**
     * Adding Piece's symbol on specific position.
     *
     * @param pos   Position
     * @param piece Piece's symbol
     */
    public void add(String pos, String piece) {
        Component[] blocks = getComponents();
        JPanel found;

        for (Component block : blocks) {
            if (block instanceof JPanel) {
                if (pos.equals(block.getName())) {
                    found = (JPanel) block;
                    piece = String.format("<html><body style='font-size: 30px;'>%s</body></html>", piece);
                    found.add(new JLabel(piece));
                    break;
                }
            }
        }
    }
}
