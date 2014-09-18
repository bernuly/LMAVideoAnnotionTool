package videoannotation.preferences;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import videoannotation.fxml.LoaderClass;

/**
 *
 * @author Ankit Gupta
 */
public class PreferencesDialogController implements Initializable {

    @FXML
    private ListView prefList;

    @FXML
    private Button closeBtn;

    @FXML
    private Button applyBtn;

    @FXML
    private StackPane prefContainerPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) closeBtn.getScene().getWindow();
                stage.close();
            }
        });

        prefList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue.equals("Show/Hide")) {
                    try {
                        Parent showHidePrefsPane = FXMLLoader.load(LoaderClass.class.getResource("ShowHidePrefs.fxml"));
                        prefContainerPane.getChildren().remove(showHidePrefsPane);
                        prefContainerPane.getChildren().add(showHidePrefsPane);
                    } catch (IOException ex) {
                        Logger.getLogger(PreferencesDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.err.println("Invalid Selection");
                }
            }
        });

        prefList.getItems().add("Show/Hide");
    }

}
