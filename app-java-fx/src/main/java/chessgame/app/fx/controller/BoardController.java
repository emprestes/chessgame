package chessgame.app.fx.controller;

import chessgame.app.fx.view.PieceView;
import chessgame.facade.BoardFacade;
import chessgame.facade.PieceFacade;
import chessgame.facade.mock.MockBoardFacade;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Map;

/**
 * Controller of Chessboard.
 *
 * @author Prestes, E. M.
 * @see GridPane
 * @see AbstractController
 * @see FXML
 * @since October 2016
 */
public class BoardController extends AbstractController {

    public static final String VIEW_TITLE = "Chess Game";

    public static final String VIEW_URL = String.format(VIEW_PACKAGE, "BoardView");

    private final BoardFacade facade = new MockBoardFacade();

    @FXML
    public GridPane boardView;

    @FXML
    public void initialize() {
        initialize(facade.initBlackPieces());
        initialize(facade.initWhitePieces());
    }

    private void initialize(Map<String, PieceFacade> pieces) {
        pieces.forEach((position, piece) -> boardView.getChildren().stream()
                .filter(blockView -> position.equals(blockView.getId()))
                .map(foundView -> ((Pane) foundView).getChildren())
                .forEach(foundView -> foundView.add(PieceView.create(piece))));
    }
}
