import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Level2CarController {

    @FXML
    private Button button_01;

    @FXML
    private Button button_02;

    @FXML
    private Button button_03;

    @FXML
    private Button button_04;

    @FXML
    private Button button_05;

    @FXML
    private Button button_06;

    @FXML
    private Button button_07;

    @FXML
    private Button button_08;

    @FXML
    private Button button_09;

    @FXML
    private Button button_10;

    @FXML
    private Button button_11;

    @FXML
    private Button button_12;

    @FXML
    private Button button_13;

    @FXML
    private Button button_14;

    @FXML
    private Button button_15;

    @FXML
    private Button button_16;

    @FXML
    private Button button_17;

    @FXML
    private Button button_18;

    @FXML
    private Button button_19;

    @FXML
    private Button button_20;

    @FXML
    private Button button_quit_C2;

    @FXML
    private Label label_time;

    @FXML 
    private ImageView Imageview_soundON_C2;

    @FXML
    private ImageView Imageview_soundOFF_C2;

    private List<Button> buttons;
    private List<Image> images; // Shuffled images for the game
    private Image blankImage;

    private Button firstSelected = null;
    private Button secondSelected = null;
    private int firstIndex = -1;
    private int secondIndex = -1;
    private boolean canClick = true;

    private Timer gameTimer;
    private int timeLeft = 45;
    private int matchedPairs = 0;

    private MediaPlayer backgroundMusic;
    private boolean isMusicPlaying = true;

    public void initialize() {
        buttons = Arrays.asList(
            button_01, button_02, button_03, button_04, button_05, button_06,
            button_07, button_08, button_09, button_10, button_11, button_12,
            button_13, button_14, button_15, button_16, button_17, button_18,
            button_19, button_20
        );

        blankImage = new Image(getClass().getResource("/Car/Blank.jpg").toExternalForm());

        // Get all unique animal image names (ignore Blank.jpg and *Copy.jpg)
        List<String> carImageNames = new ArrayList<>();
        try {
            URL url = getClass().getResource("/Car");
            if (url != null) {
                File folder = new File(url.toURI());
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    String name = file.getName();
                    if (name.endsWith(".jpg") && !name.equalsIgnoreCase("Blank.jpg")) {
    carImageNames.add(name);
    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.shuffle(carImageNames);
        // List<String> selected = animalImageNames.size() >= 6 ? animalImageNames.subList(0, 6) : animalImageNames;
        List<String> selected = carImageNames.size() >= 10 ? carImageNames.subList(0, 10) : carImageNames;
        images = new ArrayList<>();
        for (String name : selected) {
            Image img = new Image(getClass().getResource("/Car/" + name).toExternalForm());
            images.add(img);
            images.add(img);
        }
        Collections.shuffle(images);

        // Set all buttons to show the blank image at start using the FXML ImageView
        for (Button btn : buttons) {
            setImageOnButton(btn, blankImage);
        }

        startTimer();
        playBackgroundMusic();
    }

    private void setImageOnButton(Button btn, Image img) {
        // Only update the image in the existing ImageView (do not create a new one)
        if (btn.getGraphic() instanceof ImageView) {
            ((ImageView) btn.getGraphic()).setImage(img);
        }
    }

    private int getButtonIndex(Button btn) {
        return buttons.indexOf(btn);
    }

    private void handleButtonClick(Button btn) {
    if (!canClick || btn == firstSelected || btn == secondSelected) return;

    int idx = getButtonIndex(btn);
    setImageOnButton(btn, images.get(idx));

    if (firstSelected == null) {
        firstSelected = btn;
        firstIndex = idx;
    } else if (secondSelected == null) {
        secondSelected = btn;
        secondIndex = idx;
        canClick = false;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(() -> {
                    if (!images.get(firstIndex).equals(images.get(secondIndex))) {
                        setImageOnButton(firstSelected, blankImage);
                        setImageOnButton(secondSelected, blankImage);
                    } else {
                        // Pair matched!
                        matchedPairs++;
                        // Optionally disable matched buttons:
                        firstSelected.setDisable(true);
                        secondSelected.setDisable(true);
                        // Check if all pairs are matched
                        if (matchedPairs == 10) {
                            showCompleteScene();
                        }
                    }
                    firstSelected = null;
                    secondSelected = null;
                    firstIndex = -1;
                    secondIndex = -1;
                    canClick = true;
                });
            }
        }, 800);
    }
}
    private void startTimer() {
    label_time.setText(timeLeft + "s");
    gameTimer = new Timer();
    gameTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            javafx.application.Platform.runLater(() -> {
                timeLeft--;
                label_time.setText(timeLeft + "s");
                if (timeLeft <= 0) {
                    label_time.setText("Time's up!");
                    canClick = false;
                    for (Button btn : buttons) {
                        btn.setDisable(true);
                    }
                    gameTimer.cancel();
                    backgroundMusic.pause();
                    isMusicPlaying = false;

                    try{
                        Scene scene = FXMLLoader.load(getClass().getResource("failure.fxml"));
                        Stage stage = (Stage) label_time.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("You Lost!");

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }, 1000, 1000);
}

    private void playBackgroundMusic() {
        try {
            Media media = new Media(getClass().getResource("/Sound/FIFTY FIFTY - Cupid (Twin Version) (Lyrics) 1080p_20250619160432.mp3").toURI().toString());
            backgroundMusic = new MediaPlayer(media);
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
            backgroundMusic.play();
            isMusicPlaying = true;
        } catch (Exception e) {
            System.err.println("Failed to load background music.");
            e.printStackTrace();
        }
    }
    
    private void showCompleteScene(){
        try {
            if(gameTimer != null) {
                gameTimer.cancel();
                backgroundMusic.pause();
                isMusicPlaying = false;
            }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Complete.fxml"));
        Scene scene = loader.load();
        CompleteController controller = loader.getController();
        int point = matchedPairs * 10;
        controller.setPoint(point);
        controller.setTime(timeLeft);

        // Get the stage BEFORE switching the scene
        Stage stage = (Stage) label_time.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Congratulations!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void button_01_action(ActionEvent event) {
        handleButtonClick(button_01);
    }

    @FXML
    void button_02_action(ActionEvent event) {
        handleButtonClick(button_02);
    }

    @FXML
    void button_03_action(ActionEvent event) {
        handleButtonClick(button_03);
    }

    @FXML
    void button_04_action(ActionEvent event) {
        handleButtonClick(button_04);
    }

    @FXML
    void button_05_action(ActionEvent event) {
        handleButtonClick(button_05);
    }

    @FXML
    void button_06_action(ActionEvent event) {
        handleButtonClick(button_06);
    }

    @FXML
    void button_07_action(ActionEvent event) {
        handleButtonClick(button_07);
    }

    @FXML
    void button_08_action(ActionEvent event) {
        handleButtonClick(button_08);
    }

    @FXML
    void button_09_action(ActionEvent event) {
        handleButtonClick(button_09);
    }

    @FXML
    void button_10_action(ActionEvent event) {
        handleButtonClick(button_10);

    }

    @FXML
    void button_11_action(ActionEvent event) {
        handleButtonClick(button_11);
    }

    @FXML
    void button_12_action(ActionEvent event) {
        handleButtonClick(button_12);
    }

    @FXML
    void button_13_action(ActionEvent event) {
        handleButtonClick(button_13);
    }

    @FXML
    void button_14_action(ActionEvent event) {
        handleButtonClick(button_14);
    }

    @FXML
    void button_15_action(ActionEvent event) {
        handleButtonClick(button_15);
    }

    @FXML
    void button_16_action(ActionEvent event) {
        handleButtonClick(button_16);
    }

    @FXML
    void button_17_action(ActionEvent event) {
        handleButtonClick(button_17);
    }

    @FXML
    void button_18_action(ActionEvent event) {
        handleButtonClick(button_18);
    }

    @FXML
    void button_19_action(ActionEvent event) {
        handleButtonClick(button_19);

    }

    @FXML
    void button_20_action(ActionEvent event) {
        handleButtonClick(button_20);
    }

    @FXML
    void button_quit_C2_action(ActionEvent event) {
        try {
            if (backgroundMusic != null) {
                backgroundMusic.stop();
            }
            Stage stage = (Stage) button_quit_C2.getScene().getWindow();
            Scene scene = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Play");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Imageview_soundON_C2_action(MouseEvent event) {
        Imageview_soundON_C2.setVisible(false);
        Imageview_soundOFF_C2.setVisible(true);

    // Pause music
        if (backgroundMusic != null) {
            backgroundMusic.pause();
            isMusicPlaying = false;
        }
    }

    @FXML
    void Imageview_soundOFF_C2_action(MouseEvent event) {
        Imageview_soundON_C2.setVisible(true);
        Imageview_soundOFF_C2.setVisible(false);

    // Resume music
        if (backgroundMusic != null) {
            backgroundMusic.play();
            isMusicPlaying = true;
        }
    }
}
