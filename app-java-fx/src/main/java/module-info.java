/**
 * JavaFX application
 */
module chessgame.app.fx {
    requires javafx.controls;
    requires javafx.fxml;

    exports chessgame.app;
    exports chessgame.app.fx.api;
    exports chessgame.app.fx.controller;
    exports chessgame.app.fx.view;
}
