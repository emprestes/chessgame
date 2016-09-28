package chessgame.app;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ChessGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Chess Game");
        alert.setHeaderText("Welcome to the Java Project");
        alert.setContentText("Soon, we'll have more features here!");

        alert.showAndWait();
    }
}
