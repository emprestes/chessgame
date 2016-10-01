package chessgame.app;

import chessgame.app.fx.util.FXMLHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static chessgame.app.fx.controller.BoardController.VIEW_TITLE;
import static chessgame.app.fx.controller.BoardController.VIEW_URL;

public class Chess extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene board = FXMLHelper.createScene(primaryStage, VIEW_TITLE, VIEW_URL);

        primaryStage.setScene(board);
        primaryStage.setResizable(Boolean.FALSE);
        primaryStage.show();
    }
}
