package chessgame.app.fx.view;

import chessgame.facade.PieceFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public final class PieceView extends Label {

    private final PieceFacade facade;

    private PieceView(PieceFacade facade) {
        super();
        this.facade = facade;
    }

    public static PieceView create(PieceFacade facade) {
        PieceView view = new PieceView(facade);

        view.setNeedsLayout(Boolean.TRUE);
        view.setLayoutX(1.0);
        view.setLayoutY(2.0);
        view.setPrefWidth(60.0);
        view.setPrefHeight(60.0);
        view.setAlignment(Pos.CENTER);
        view.setFont(Font.font(48.0));
        view.setMnemonicParsing(Boolean.TRUE);
        view.setWrapText(Boolean.TRUE);
        view.setText(facade.getSymbol());

        return view;
    }

    public PieceFacade getFacade() {
        return facade;
    }
}
