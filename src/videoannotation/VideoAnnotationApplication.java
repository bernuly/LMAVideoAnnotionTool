package videoannotation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import videoannotation.fxml.LoaderClass;

/**
 *
 * @author Ankit Gupta
 */
public class VideoAnnotationApplication extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent window = FXMLLoader.load(LoaderClass.class.getResource("VideoAnnotationWindow.fxml"));
        Scene scene = new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
