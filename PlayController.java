import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayController {

    @FXML
    private Button Button_history;

    @FXML
    private Button Button_play;

    @FXML
    private Button button_exit;

    @FXML
    void Button_history_action(ActionEvent event) {
        try {
            Stage stage = (Stage) Button_history.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("HistoryView.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - History");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void Button_play_action(ActionEvent event) {
        try {
            Stage stage = (Stage) Button_play.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("OptionView.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void button_exit_action(ActionEvent event) {
        try {
            Stage stage = (Stage) button_exit.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("LoginView.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Login");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
