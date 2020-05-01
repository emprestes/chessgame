package chessgame.app.swing.view;

import chessgame.app.swing.api.View;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * View to create labels to columns and rows.
 *
 * @author Prestes, E. M.
 * @see View
 * @see BorderLayout
 * @since October 2016
 */
public final class LabelView extends View {

    /**
     * Default constructor
     */
    private LabelView() {
        super(new BorderLayout());
    }

    /**
     * Constructor informing rows and columns.
     *
     * @param rows Rows informed.
     * @param cols Columns informed.
     */
    private LabelView(int rows, int cols) {
        super(new GridLayout(rows, cols));
    }

    /**
     * Create labels views for columns.
     *
     * @param items Labels informed.
     * @return LabelView
     */
    public static LabelView createCols(Object... items) {
        LabelView view = new LabelView();
        LabelView labels;
        Dimension d;
        JLabel c;
        Border b;

        labels = new LabelView(1, items.length);
        labels = create(labels, Boolean.FALSE, items);

        d = new Dimension(14, 0);
        b = BorderFactory.createEtchedBorder();
        c = createLabel(d, b);
        view.add(c, BorderLayout.WEST);
        view.add(labels, BorderLayout.CENTER);
        c = createLabel(d, b);
        view.add(c, BorderLayout.EAST);

        return view;
    }

    /**
     * Create a label.
     *
     * @param d Dimension informed.
     * @param b Border informed.
     * @return JLabel
     */
    private static JLabel createLabel(Dimension d, Border b) {
        JLabel l = new JLabel();

        l.setMinimumSize(d);
        l.setPreferredSize(d);
        l.setMaximumSize(d);
        l.setBorder(b);

        return l;
    }

    /**
     * Create labels for rows.
     *
     * @param items Labels informed.
     * @return LabelView
     */
    public static LabelView createRows(Object... items) {
        LabelView view = new LabelView(items.length, 1);
        return create(view, Boolean.TRUE, items);
    }

    /**
     * Create labels for a label view.
     *
     * @param view   Label view informed.
     * @param invert Invert order of labels.
     * @param items  Labels informed.
     * @return LabelView
     */
    private static LabelView create(LabelView view, boolean invert, Object... items) {
        JLabel row;

        for (int i = invert ? items.length - 1 : 0; invert ? i >= 0 : i < items.length;) {
            row = new JLabel(String.valueOf(items[i]), SwingConstants.CENTER);
            row.setBorder(BorderFactory.createEtchedBorder());
            view.add(row);

            if (invert) {
                i--;
            } else {
                i++;
            }
        }

        return view;
    }
}
