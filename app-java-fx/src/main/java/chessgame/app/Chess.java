package chessgame.app;

import chessgame.app.fx.util.FXMLHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static chessgame.app.fx.controller.BoardController.VIEW_TITLE;
import static chessgame.app.fx.controller.BoardController.VIEW_URL;

/**
 * Welcome to Chess Game Java Project for Java beginners using javaFX.
 * <p>
 * Running project with: app-fx $ mvn exec:java
 *
 * @author Prestes, E. M.
 * @see Application
 * @see Stage
 * @see Scene
 * @see FXMLHelper
 * @since October 2016
 */
public class Chess extends Application {

    /**
     * Main behaviour.
     *
     * @param args Arguments informed by terminal.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene board = FXMLHelper.createScene(primaryStage, VIEW_TITLE, VIEW_URL);

        primaryStage.setScene(board);
        primaryStage.setResizable(Boolean.FALSE);
        primaryStage.show();
    }
}
