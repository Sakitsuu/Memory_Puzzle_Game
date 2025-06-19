import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import my_class.Register;

public class RegisterController {

    @FXML
    private CheckBox Checkbox_show_password;

    @FXML
    private Label Label_status_usernameRegister;

    @FXML
    private PasswordField Passwordfield_password_register;

    @FXML
    private PasswordField Passwordfield_verify_register;

    @FXML
    private TextField Textfield_password_register;

    @FXML
    private TextField Textfield_username_register;

    @FXML
    private TextField Textfield_verify_register;

    @FXML
    private Button button_back_to_login;

    @FXML
    private Button button_register;

    @FXML
    private Label label_statusResult;

    @FXML
    private Label label_status_passwordRegister;

    @FXML
    private Label label_status_verifyRegister;

    @FXML
    private Label textfield_username;

    @FXML
    void Checkbox_show_password_action(ActionEvent event) {
        if (Checkbox_show_password.isSelected()) {
            String password = Passwordfield_password_register.getText();
            String verify = Passwordfield_verify_register.getText();
            Textfield_password_register.setText(password);
            Textfield_verify_register.setText(verify);

            Passwordfield_password_register.setVisible(false);
            Textfield_password_register.setVisible(true);
            Passwordfield_verify_register.setVisible(false);
            Textfield_verify_register.setVisible(true);
        } else {
            String password = Textfield_password_register.getText();
            String verify = Textfield_verify_register.getText();
            Passwordfield_password_register.setText(password);
            Passwordfield_verify_register.setText(verify);
            
            Passwordfield_password_register.setVisible(true);
            Textfield_password_register.setVisible(false);
            Passwordfield_verify_register.setVisible(true);
            Textfield_verify_register.setVisible(false);
        }
    }

    Register rg = new Register();

    @FXML
    void Passwordfield_password_register_active(KeyEvent event) {
        if (!Checkbox_show_password.isSelected()) {
            String password = Passwordfield_password_register.getText();
            if (rg.isPasswordValid(password)) {
                label_status_passwordRegister.setText("Valid password");
                label_status_passwordRegister.setStyle("-fx-text-fill: green;");
            } else {
                label_status_passwordRegister.setText("Invalid password");
                label_status_passwordRegister.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    void Passwordfield_verify_register_active(KeyEvent event) {
        String password;
        if (Checkbox_show_password.isSelected()) {
            password = Textfield_password_register.getText();
        } else {
            password = Passwordfield_password_register.getText();
        }
        String verify = Passwordfield_verify_register.getText();
        if (password.equals(verify)) {
            label_status_verifyRegister.setText("Passwords match");
            label_status_verifyRegister.setStyle("-fx-text-fill: green;");
        } else {
            label_status_verifyRegister.setText("Passwords do not match");
            label_status_verifyRegister.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void Textfield_password_register_action(KeyEvent event) {
        if (Checkbox_show_password.isSelected()) {
            String password = Textfield_password_register.getText();
            if (rg.isPasswordValid(password)) {
                label_status_passwordRegister.setText("Valid password");
                label_status_passwordRegister.setStyle("-fx-text-fill: green;");
            } else {
                label_status_passwordRegister.setText("Invalid password");
                label_status_passwordRegister.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    void Textfield_username_register_active(KeyEvent event) {
        String username = Textfield_username_register.getText();
        if (rg.isUserNameValid(username)) {
            Label_status_usernameRegister.setText("Valid username");
            Label_status_usernameRegister.setStyle("-fx-text-fill: green;");
        } else {
            Label_status_usernameRegister.setText("Invalid username");
            Label_status_usernameRegister.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void Textfield_verify_register_active(KeyEvent event) {
        String password;
        if (Checkbox_show_password.isSelected()) {
            password = Textfield_password_register.getText();
        } else {
            password = Passwordfield_password_register.getText();
        }
        String verify = Textfield_verify_register.getText();
        if (password.equals(verify)) {
            label_status_verifyRegister.setText("Passwords match");
            label_status_verifyRegister.setStyle("-fx-text-fill: green;");
        } else {
            label_status_verifyRegister.setText("Passwords do not match");
            label_status_verifyRegister.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void button_back_to_login_action(ActionEvent event) {
        try {
            Stage stage = (Stage) button_back_to_login.getScene().getWindow();
            javafx.scene.Scene scene = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            stage.setScene(scene);
            stage.setTitle("Memory Puzzle Game - Login");
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Puzzle Memory Gaming Logo.png")));
            stage.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @FXML
    void button_register_action(ActionEvent event) {
        rg = new Register();
        String username = Textfield_username_register.getText();
        String password;
        if (Checkbox_show_password.isSelected()) {
            password = Textfield_password_register.getText();
        } else {
            password = Passwordfield_password_register.getText();
        }
        String verify = Passwordfield_verify_register.getText();
        if (rg.isRegisterSuccess(username, password, verify)) {
            label_statusResult.setText("Register Success!");
            label_statusResult.setStyle("-fx-text-fill: green;");
        } else {
            label_statusResult.setText("Register Fail!");
            label_statusResult.setStyle("-fx-text-fill: red;");
        }
    }

}
