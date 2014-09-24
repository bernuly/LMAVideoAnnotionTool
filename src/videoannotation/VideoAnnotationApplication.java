package videoannotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import videoannotation.fxml.FXMLResourceLoader;

/**
 *
 * @author Ankit Gupta
 */
public class VideoAnnotationApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        CommunicationBridge bridge = CommunicationBridge.getInstance();
        bridge.setApplication(this);
        
        sequence.add("Login.fxml");
        sequence.add("ParticipantDetails.fxml");
        sequence.add("Consent.fxml");
        sequence.add("VideoAnnotationWindow.fxml");
        
        
        this.primaryStage = primaryStage;
        
        next();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int currentIndex = 0;

    private final static List<String> sequence = new ArrayList<String>();

    private void show(String fxmlFile) {
        try {
            Parent window = FXMLLoader.load(FXMLResourceLoader.class.getResource(fxmlFile));
            Scene scene = new Scene(window);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Could not read fxml file");
        }
    }

    public void next() {
        show(sequence.get(currentIndex++));
    }

}
