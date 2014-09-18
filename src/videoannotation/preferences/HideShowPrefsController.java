package videoannotation.preferences;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Ankit Gupta
 */
public class HideShowPrefsController implements Initializable{
    
    @FXML
    private TextField replayIntervalField;
    
    @FXML
    private TextField nextVideoIntervalField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
