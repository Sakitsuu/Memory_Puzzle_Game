import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import my_class.UserChoice;

public class CompleteController {

    @FXML
    private Button button_exit;

    @FXML
    private Button button_home;

    @FXML
    private Button button_next_level;

    @FXML
    private Button button_play_again;

    @FXML
    private Label label_point;

    @FXML
    private Label label_time;

    private MediaPlayer backgroundMusic;
    private boolean isMusicPlaying = true;

    public void initialize() {
        // Play background music when the controller is initialized
        playBackgroundMusic();
    }

    private void playBackgroundMusic() {
        try {
            Media media = new Media(getClass().getResource("/Sound/CROWD CHEER SOUND EFFECT 1080p_20250619232423.mp3").toURI().toString());
            backgroundMusic = new MediaPlayer(media);
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
            backgroundMusic.play();
            isMusicPlaying = true;
        } catch (Exception e) {
            System.err.println("Failed to load background music.");
            e.printStackTrace();
        }
    }


    void setPoint(int point){
        label_point.setText(String.valueOf(point));
    }
    public void setTime(int timeLeft){
        label_time.setText(timeLeft + "s");
    }

    @FXML
    void button_exit_action(ActionEvent event) {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
        System.exit(0);
    }

    @FXML
    void button_home_action(ActionEvent event) {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    @FXML
    void button_next_level_action(ActionEvent event) {
        try{
            if (backgroundMusic != null) {
                backgroundMusic.stop();
            }
            Stage stage = (Stage) button_next_level.getScene().getWindow();
            String fxml = "Level2Animal.fxml"; // default
            if ("car".equals(UserChoice.category)) {
                fxml = "Level2Car.fxml";
            } else if ("fruit".equals(UserChoice.category)) {
                fxml = "Level2Fruit.fxml";
            }

            Scene scene = new FXMLLoader(getClass().getResource(fxml)).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Level 2");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();

        } catch (Exception e) {
            
        }
    }

    @FXML
    void button_play_again_action(ActionEvent event) {

        try {
            if (backgroundMusic != null) {
                backgroundMusic.stop();
            }
            String fxml = "";
            if (UserChoice.category == "animal") {
                if (UserChoice.level == 1) {
                    fxml = "Level1Animal.fxml";
                } else if (UserChoice.level == 2) {
                    fxml = "Level2Animal.fxml";
                } else if (UserChoice.level == 3) {
                    fxml = "Level3Animal.fxml";
                }
            } else if (UserChoice.category == "car") {
                if (UserChoice.level == 1) {
                    fxml = "Level1Car.fxml";
                } else if (UserChoice.level == 2) {
                    fxml = "Level2Car.fxml";
                } else if (UserChoice.level == 3) {
                    fxml = "Level3Car.fxml";
                }
            } else if (UserChoice.category == "fruit") {
                if (UserChoice.level == 1) {
                    fxml = "Level1Fruit.fxml";
                } else if (UserChoice.level == 2) {
                    fxml = "Level2Fruit.fxml";
                } else if (UserChoice.level == 3) {
                    fxml = "Level3Fruit.fxml";
                }
            }
            
            Scene scene = new FXMLLoader(getClass().getResource(fxml)).load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Level 1");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}