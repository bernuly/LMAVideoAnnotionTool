package videoannotation.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import videoannotation.fxml.FXMLResourceLoader;

/**
 *
 * @author Ankit Gupta
 */
public class VideoAnnotationWindowController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private HBox playerArea;

    @FXML
    private HBox questionArea;
    
    @FXML
    private MenuItem closeMenuItem;
    
    @FXML
    private MenuItem preferencesMenuItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.prefWidthProperty().bind(anchorPane.widthProperty());
        try {
            Parent player1 = FXMLLoader.load(FXMLResourceLoader.class.getResource("Player.fxml"));
            playerArea.getChildren().add(player1);

            Parent player2 = FXMLLoader.load(FXMLResourceLoader.class.getResource("Player.fxml"));
            playerArea.getChildren().add(player2);
        } catch (IOException ex) {
            Logger.getLogger(VideoAnnotationWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeMenuItem.setOnAction((ActionEvent e)->{
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        }); 
        
        preferencesMenuItem.setOnAction((ActionEvent event) -> {
            try {
                Parent parent = FXMLLoader.load(FXMLResourceLoader.class.getResource("PreferencesDialog.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(anchorPane.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(VideoAnnotationWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
