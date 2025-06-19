import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import my_class.UserChoice;

public class OptionController {

    @FXML
    private ImageView Imageview_animal;

    @FXML
    private ImageView Imageview_fruit;

    @FXML
    private ImageView Imgaeview_car;

    @FXML
    private Button Button_back_Option;

    @FXML
    void Imageview_animal_click(MouseEvent event) {
        UserChoice.category = "animal";
        try {
            Stage stage = (Stage) Imageview_animal.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("level.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Level");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void Imageview_car_click(MouseEvent event) {
        UserChoice.category = "car";
        try {
            Stage stage = (Stage) Imgaeview_car.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("level.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Level");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void Imageview_fruit_click(MouseEvent event) {
        UserChoice.category = "fruit";
        try {
            Stage stage = (Stage) Imageview_fruit.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("level.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Level");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    public void initialize() {
        addHoverEffect(Imageview_animal);
        addHoverEffect(Imageview_fruit);
        addHoverEffect(Imgaeview_car); // again, fix spelling if necessary
    }

    private void addHoverEffect(ImageView imageView) {
        ColorAdjust brighter = new ColorAdjust();
        brighter.setBrightness(0.3); // Brighter effect

        imageView.setOnMouseEntered(e -> imageView.setEffect(brighter));
        imageView.setOnMouseExited(e -> imageView.setEffect(null));
    }
       
    @FXML
    void Imageview_fruit_action(MouseEvent event) {

    }

    @FXML
    void Imageview_animal_action(MouseEvent event) {
    }

    @FXML
    void Imgaeview_car_action(MouseEvent event) {

    }

    @FXML
    void Button_back_Option_action(ActionEvent event) {
        try {
            Stage stage = (Stage) Button_back_Option.getScene().getWindow();
            javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("PlayView.fxml")).load();
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Login");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
