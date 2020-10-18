package chessgame.app.swing;

import javax.swing.JPanel;
import java.awt.LayoutManager;

/**
 * Abstract view.
 *
 * @author Prestes, E. M.
 * @see JPanel
 * @see LayoutManager
 * @since October 2016
 */
public abstract class View extends JPanel {

    /**
     * Constructor informing layout.
     *
     * @param layout Layout informed.
     */
    protected View(LayoutManager layout) {
        super(layout);
    }
}
