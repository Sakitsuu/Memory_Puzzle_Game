import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = FXMLLoader.load(getClass().getResource("PlayView.fxml"));
        stage.setScene(scene);
        stage.setTitle("Memory Puzzle Game - Login");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
        stage.show();
    }
}
