package chessgame.app.fx.controller;

import chessgame.app.fx.api.Controller;
import javafx.stage.Stage;

/**
 * Common implementation between controllers.
 *
 * @author Prestes, E. M.
 * @see Controller
 * @see Stage
 * @since October 2016
 */
abstract class AbstractController implements Controller {

    static final String VIEW_PACKAGE = "/chessgame/app/fx/view/%s.fxml";

    private Stage stage;

    /**
     * {@inheritDoc}
     */
    @Override
    public Stage getStage() {
        return stage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
