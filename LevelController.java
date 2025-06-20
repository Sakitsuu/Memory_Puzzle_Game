import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import my_class.UserChoice;

public class LevelController {

    @FXML
    private Button button_back;

    @FXML
    private Button button_level_1;

    @FXML
    private Button button_level_2;

    @FXML
    private Button button_level_3;

    @FXML
    void button_back_action(ActionEvent event) {
        try {
            Stage stage = (Stage) button_back.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("OptionView.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Options");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void button_level_1_action(ActionEvent event) {
        UserChoice.level = 1; // Set the level to 1
        try {
            Stage stage = (Stage) button_level_1.getScene().getWindow();
            String fxmlToLoad = "";
            String title = "";

            if (UserChoice.category.equals("animal")) {
                fxmlToLoad = "Level1Animal.fxml";
                title = "Memory Puzzle Game - Level 1 Animal";
            } else if (UserChoice.category.equals("fruit")) {
                fxmlToLoad = "Level1Fruit.fxml";
                title = "Memory Puzzle Game - Level 1 Fruit";
            } else if (UserChoice.category.equals("car")) {
                fxmlToLoad = "Level1Car.fxml";
                title = "Memory Puzzle Game - Level 1 Car";
            } else {
                // Default or error handling
                fxmlToLoad = "Level_1.fxml";
                title = "Memory Puzzle Game - Level 1";
            }

            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlToLoad)).load();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void button_level_2_action(ActionEvent event) {
        UserChoice.level = 2; 
        try {
            Stage stage = (Stage) button_level_2.getScene().getWindow();
            String fxmlToLoad = "";
            String title = "";

            if (UserChoice.category.equals("animal")) {
                fxmlToLoad = "Level2Animal.fxml";
                title = "Memory Puzzle Game - Level 2 Animal";
            } else if (UserChoice.category.equals("fruit")) {
                fxmlToLoad = "Level2Fruit.fxml";
                title = "Memory Puzzle Game - Level 2 Fruit";
            } else if (UserChoice.category.equals("car")) {
                fxmlToLoad = "Level2Car.fxml";
                title = "Memory Puzzle Game - Level 2 Car";
            } else {
                // Default or error handling
                fxmlToLoad = "Level_2.fxml";
                title = "Memory Puzzle Game - Level 2";
            }

            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlToLoad)).load();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void button_level_3_action(ActionEvent event) {
        UserChoice.level = 3;
        try {
            Stage stage = (Stage) button_level_3.getScene().getWindow();
            String fxmlToLoad = "";
            String title = "";

            if (UserChoice.category.equals("animal")) {
                fxmlToLoad = "Level3Animal.fxml";
                title = "Memory Puzzle Game - Level 3 Animal";
            } else if (UserChoice.category.equals("fruit")) {
                fxmlToLoad = "Level3Fruit.fxml";
                title = "Memory Puzzle Game - Level 3 Fruit";
            } else if (UserChoice.category.equals("car")) {
                fxmlToLoad = "Level3Car.fxml";
                title = "Memory Puzzle Game - Level 3 Car";
            } else {
                // Default or error handling
                fxmlToLoad = "Level_3.fxml";
                title = "Memory Puzzle Game - Level 3";
            }

            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlToLoad)).load();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
