import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

public class Test extends Application {
    @Override
    public void start(Stage stage) {
        Media media = new Media(new File("src/resources/Sound/bgm.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
