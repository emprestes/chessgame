package chessgame.app.swing.view;

import chessgame.app.swing.View;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public final class LabelView extends View {

    private LabelView() {
        super(new BorderLayout());
    }

    private LabelView(int rows, int cols) {
        super(new GridLayout(rows, cols));
    }

    public static LabelView createCols(Object... items) {
        LabelView view = new LabelView();
        LabelView labels;
        Dimension d;
        JLabel c;
        Border b;

        labels = new LabelView(1, items.length);
        labels = create(labels, false, items);

        d = new Dimension(12, 0);
        b = BorderFactory.createEtchedBorder();
        c = createLabel(d, b);
        view.add(c, BorderLayout.WEST);
        view.add(labels, BorderLayout.CENTER);
        c = createLabel(d, b);
        view.add(c, BorderLayout.EAST);

        return view;
    }

    private static JLabel createLabel(Dimension d, Border b) {
        JLabel l = new JLabel();
        l.setMinimumSize(d);
        l.setPreferredSize(d);
        l.setMaximumSize(d);
        l.setBorder(b);

        return l;
    }

    public static LabelView createRows(Object... items) {
        LabelView view = new LabelView(items.length, 1);
        return create(view, true, items);
    }

    private static LabelView create(LabelView view, boolean invert, Object... items) {
        JLabel row;

        for (int i = invert ? items.length - 1 : 0; invert ? i >= 0 : i < items.length; ) {
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
