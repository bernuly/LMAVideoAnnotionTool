package videoannotation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import videoannotation.preferences.PrefDialogLoaderClass;

/**
 *
 * @author Ankit Gupta
 */
public class VideoPlayerMenuBar extends MenuBar {

    private final Menu fileMenu;
    private final MenuItem prefMenuItem;
    private final MenuItem exitMenuItem;

    public VideoPlayerMenuBar(Stage primaryStage) {

        fileMenu = new Menu("File");
        prefMenuItem = new MenuItem("Preferences");
        prefMenuItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent prefDialog = FXMLLoader.load(PrefDialogLoaderClass.class.getResource("PreferencesDialog.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(prefDialog);
                    stage.setScene(scene);
                    stage.setTitle("Preferences");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(primaryStage);
                    stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(VideoPlayerMenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        exitMenuItem = new MenuItem("Exit");

        fileMenu.getItems().add(prefMenuItem);
        fileMenu.getItems().add(exitMenuItem);

        getMenus().add(fileMenu);

    }

}
