package chessgame.app;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ChessGame {

    public static void main(String[] args) {
        launch(args);
    }

    private static void launch(String... args) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null,
                        "Chess Game Project\nWelcome to the Java Project\nSoon, we'll have more features here!"));
    }
}
