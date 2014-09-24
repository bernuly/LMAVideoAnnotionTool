package videoannotation.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import videoannotation.CommunicationBridge;

/**
 * FXML Controller class
 *
 * @author Ankit Gupta
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button nextBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nextBtn.setOnAction((ActionEvent event) -> {
            CommunicationBridge.getInstance().next();
        });
    }    
    
}
