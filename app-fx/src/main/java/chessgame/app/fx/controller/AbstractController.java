package chessgame.app.fx.controller;

import chessgame.app.fx.Controller;
import javafx.stage.Stage;

abstract class AbstractController implements Controller {

    static final String VIEW_PACKAGE = "/chessgame/app/fx/view/%s.fxml";

    private Stage stage;

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
