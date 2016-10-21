package chessgame.app.swing;

import java.awt.Dimension;

public abstract class Controller {

    public abstract View getView();

    public abstract String getTitle();

    public abstract Dimension getSize();

    public Object[] getWest() {
        return new Object[]{};
    }

    public Object[] getEast() {
        return new Object[]{};
    }

    public Object[] getNorth() {
        return new Object[]{};
    }

    public Object[] getSouth() {
        return new Object[]{};
    }
}
