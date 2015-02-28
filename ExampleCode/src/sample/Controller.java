package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML private Text warningText;

    @FXML private TextField userName;
    @FXML private PasswordField userPassword;

    @FXML
    public void loginOnclick(ActionEvent event) {
        //logic code:
        warningText.setText("Wrong id or password!");
    }

    @FXML
    public void registerOnClick(ActionEvent event) {
        //logic code:
        warningText.setText("Register not yet implemented!");
    }
}
