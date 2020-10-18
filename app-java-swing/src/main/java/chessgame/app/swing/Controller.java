package chessgame.app.swing;

import java.awt.Dimension;

/**
 * Controller interface.
 *
 * @author Prestes, E. M.
 * @see View
 * @see Dimension
 * @since October 2016
 */
public interface Controller {

    /**
     * Recovering the view.
     *
     * @return View
     */
    View getView();

    /**
     * Recovering the view title.
     *
     * @return String
     */
    String getTitle();

    /**
     * Recovering the view size.
     *
     * @return Dimension
     */
    Dimension getSize();

    /**
     * Match initialization of the game.
     */
    void initMatch();

    /**
     * Recovering labels of west region.
     *
     * @return Array
     */
    default Object[] getLabelWest() {
        return new Object[]{};
    }

    /**
     * Recovering labels of east region.
     *
     * @return Array
     */
    default Object[] getLabelEast() {
        return new Object[]{};
    }

    /**
     * Recovering labels of north region.
     *
     * @return Array
     */
    default Object[] getLabelNorth() {
        return new Object[]{};
    }

    /**
     * Recovering labels of south region.
     *
     * @return Array
     */
    default Object[] getLabelSouth() {
        return new Object[]{};
    }
}
