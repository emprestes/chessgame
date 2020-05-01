package chessgame.app.fx.util;

import chessgame.app.fx.api.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Helper to build FXML files into objects.
 *
 * @author Prestes, E. M.
 * @see Scene
 * @see Stage
 * @since October 2016
 */
public final class FXMLHelper {

    /**
     * Default constructor.
     */
    private FXMLHelper() {
        super();
    }

    /**
     * Create a scene.
     *
     * @param stage     Stage informed.
     * @param viewTitle Title of window informed.
     * @param view      Path and file FXML informed.
     * @param styles    CSS file informed.
     * @return Scene
     * @throws Exception Throw an exception in case of problems.
     */
    public static Scene createScene(Stage stage, String viewTitle, String view, String... styles) throws Exception {
        URL v = getResource(view);
        URL[] s = getResources(styles);

        return createScene(stage, viewTitle, v, s);
    }

    /**
     * Create a scene.
     *
     * @param stage Stage informed.
     * @param viewTitle Title of window informed.
     * @param view Path and file FXML informed.
     * @param styles CSS file informed.
     * @return Scene
     * @throws Exception Throw an exception in case of problems.
     */
    private static Scene createScene(Stage stage, String viewTitle, URL view, URL... styles) throws Exception {
        Parent root = createView(stage, viewTitle, view, styles);

        return new Scene(root);
    }

    /**
     * Create a Node view.
     *
     * @param <V>       Generic type to casting.
     * @param stage     Stage informed.
     * @param viewTitle Title of window informed.
     * @param view      Path and file FXML informed.
     * @param styles    CSS file informed.
     * @return Scene
     * @throws Exception Throw an exception in case of problems.
     */
    private static <V extends Parent> V createView(Stage stage, String viewTitle, URL view, URL... styles)
            throws Exception {
        FXMLLoader fxml;
        Controller controller;
        V root;

        fxml = new FXMLLoader(view);
        root = fxml.load();
        controller = fxml.getController();

        for (URL style : styles) {
            if (style != null) {
                root.getStylesheets().add(style.toExternalForm());
            }
        }

        stage.setTitle(viewTitle);

        controller.setStage(stage);

        return root;
    }

    /**
     * Recovery a resource from classpath.
     *
     * @param r Resource location informed.
     *
     * @return URL
     */
    private static URL getResource(String r) {
        return FXMLHelper.class.getResource(r);
    }

    /**
     * Recovery resources from classpath.
     *
     * @param r Resources location.
     *
     * @return URL[]
     */
    private static URL[] getResources(String... r) {
        if (r == null) {
            r = new String[]{};
        }

        URL[] rs = new URL[r.length];

        for (int i = 0; i < rs.length; i++) {
            rs[i] = FXMLHelper.class.getResource(r[i]);
        }

        return rs;
    }
}
