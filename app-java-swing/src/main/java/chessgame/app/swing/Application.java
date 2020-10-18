package chessgame.app.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.lang.reflect.Constructor;

/**
 * Abstract application for Swing Applications.
 *
 * @author Prestes, E. M.
 * @see SwingUtilities
 * @see JFrame
 * @since October 2016
 */
public abstract class Application {

    /**
     * Static behaviour to launch the application.
     *
     * @param classs Application class informed.
     * @param args   Arguments informed.
     */
    protected static void launch(Class<? extends Application> classs, String... args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame view = new JFrame();
                Constructor<? extends Application> constructor = classs.getConstructor();
                Application app = constructor.newInstance();

                app.start(view);

                view.setLocationRelativeTo(null);
                view.setResizable(Boolean.FALSE);
                view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            } catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        });
    }

    /**
     * Behaviour to start the application.
     *
     * @param view Window informed.
     * @throws Exception Throw problem during application initialization.
     */
    public abstract void start(JFrame view) throws Exception;
}
