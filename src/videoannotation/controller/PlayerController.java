package videoannotation.controller;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import resources.ResourceLoader;

/**
 *
 * @author Ankit Gupta
 */
public class PlayerController implements Initializable {

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    private Button stopBtn;

    private int playCount = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Media media = null;
        
        try {
            String toString = ResourceLoader.class.getResource("barsandtone.flv").toURI().toString();
            media = new Media(toString);
        } catch (URISyntaxException ex) {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        
        player.statusProperty().addListener(new ChangeListener<MediaPlayer.Status>() {

            @Override
            public void changed(ObservableValue<? extends MediaPlayer.Status> observable, MediaPlayer.Status oldValue, MediaPlayer.Status newValue) {
                System.out.println(oldValue + " --> " + newValue);
            }
        });
        
        playBtn.setOnAction((ActionEvent event) -> {
            player.play();
        });

        pauseBtn.setOnAction((ActionEvent event) -> {
            player.pause();
        });

        stopBtn.setOnAction((ActionEvent e) -> {
            player.stop();
        });
                
        player.setOnEndOfMedia(() -> {
            System.out.println("End of media");
            playCount++;
            if (playCount < 3) {
                player.stop();
                player.play();
            }
        });
    }

}
