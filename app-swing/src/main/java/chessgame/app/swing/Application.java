package chessgame.app.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public abstract class Application {

    protected static void launch(Class<? extends Application> classs, String... args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame view = new JFrame();
                Application app = classs.newInstance();

                view.setLocationRelativeTo(null);
                view.setResizable(Boolean.FALSE);
                view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                app.start(view);
            } catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        });
    }

    public abstract void start(JFrame view) throws Exception;
}