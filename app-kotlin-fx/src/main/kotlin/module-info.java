module chessgame.app.fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    exports chessgame.app;
    exports chessgame.app.fx;
    exports chessgame.app.fx.controller;

    opens chessgame.app.fx.controller to javafx.fxml;
}
