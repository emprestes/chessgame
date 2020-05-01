package chessgame.app.fx.api;

import javafx.stage.Stage;

/**
 * Interface for behaviour of Controllers.
 *
 * @author Prestes, E. M.
 * @see Stage
 * @since October 2016.
 */
public interface Controller {

    /**
     * Recovery the stage.
     *
     * @return Stage
     */
    Stage getStage();

    /**
     * Set the stage.
     *
     * @param stage Stage informed.
     */
    void setStage(Stage stage);
}
