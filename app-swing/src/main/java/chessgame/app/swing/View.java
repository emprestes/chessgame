package chessgame.app.swing;

import javax.swing.JPanel;
import java.awt.LayoutManager;

public abstract class View extends JPanel {

    protected View(LayoutManager layout) {
        super(layout);
    }
}
