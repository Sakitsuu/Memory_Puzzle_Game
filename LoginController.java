import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import my_class.Login;

public class LoginController {

    @FXML
    private Button Button_login;

    @FXML
    private Button Button_quit;

    @FXML
    private Button Button_register_login;

    @FXML
    private CheckBox Checkbox_show_login;

    @FXML
    private Label Label_status;

    @FXML
    private PasswordField Passwordfield_password_login;

    @FXML
    private TextField Textfield_password_login;

    @FXML
    private TextField Textfield_username_login;

    @FXML
    void Button_login_action(ActionEvent event) {
        String username = Textfield_username_login.getText();
        String password;
        if (Checkbox_show_login.isSelected()) {
            password = Textfield_password_login.getText();
        } else {
            password = Passwordfield_password_login.getText();
        }

        Login login = new Login();
        if (login.successLogIn(username, password)) {
            Label_status.setText("Login Success!");

            try {
                Stage stage = (Stage) Button_login.getScene().getWindow();
                javafx.scene.Scene scene = new javafx.fxml.FXMLLoader(getClass().getResource("PlayView.fxml")).load();
                stage.setScene(scene);
                stage.setTitle("Memory Puzzle Game - Play");
                stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
                stage.show();
            } catch (Exception e) {
            // TODO: handle exception
            }

        } else {
            Label_status.setText("Login Fail!");
            Label_status.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void Button_quit_action(ActionEvent event) {
        // Close the application
        System.exit(0);
    }

    @FXML
    void Button_register_login_action(ActionEvent event) {
        try {
            Stage stage = (Stage) Button_register_login.getScene().getWindow();
            javafx.scene.Scene scene = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Register");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void Checkbox_show_login_action(ActionEvent event) {
        if (Checkbox_show_login.isSelected()) {
            Textfield_password_login.setText(Passwordfield_password_login.getText());
            Textfield_password_login.setVisible(true);
            Passwordfield_password_login.setVisible(false);
        } else {
            Passwordfield_password_login.setText(Textfield_password_login.getText());
            Passwordfield_password_login.setVisible(true);
            Textfield_password_login.setVisible(false);
        }
    }

}
