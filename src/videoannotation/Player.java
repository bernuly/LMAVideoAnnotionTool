package videoannotation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Ankit Gupta
 */
public class Player extends VBox {

    private final MediaView mediaView;
    private final HBox controlsBox;
    private final MediaPlayer player;
    private int playCount = 0;

    public Player(String path) {
        super(5);

        mediaView = new MediaView();
        VBox mediaViewContainer = new VBox(mediaView);
        mediaViewContainer.setPrefSize(640, 480);

        Media media = new Media(path);
        player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);

        controlsBox = new HBox(3);
        addControls(controlsBox);

        getChildren().addAll(mediaViewContainer, controlsBox);
    }

    private void addControls(HBox controlsBox) {
        Button playButton = new Button("Play");
        playButton.setOnAction((ActionEvent event) -> {
            player.play();
        });
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction((ActionEvent event) -> {
            player.pause();
        });
        Button stopButton = new Button("Stop");
        stopButton.setOnAction((ActionEvent event) -> {
            player.stop();
        });

        player.setOnEndOfMedia(() -> {
            playCount++;
            if (playCount < 3) {
                player.stop();
                player.play();
            }
        });

        controlsBox.getChildren().addAll(playButton, pauseButton, stopButton);
    }

    public void setPlayer(MediaPlayer player) {
        mediaView.setMediaPlayer(player);
    }

    public void showControls(boolean show) {
        controlsBox.setVisible(show);
    }
}
