package Calendar;

import Calendar.model.CheckUser;
import Calendar.model.Query;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class LoginController {
    @FXML private Text warningText;

    @FXML private TextField userName;
    @FXML private PasswordField userPassword;

    /**
     * handle users and administration to login
     *
     * @param event
     */
    @FXML
    public void loginOnclick(ActionEvent event) {
        String email = userName.getText();
        String pass = userPassword.getText();
        if (CheckUser.canLogin(email, pass)) {
            warningText.setFill(Color.CORNFLOWERBLUE);

            if (email.equalsIgnoreCase("koieadmin")) {
                warningText.setText("Administration logged in !");
            } else if (CheckUser.canLogin(email, pass)) {
                warningText.setText(
                        "Welcome back: " + Query.getUserName(email));
                ScreenController.loadView();
            }

        } else {
            warningText.setFill(Color.valueOf("#0277BD"));
            warningText.setText("Wrong id(Email address) or password!");
        }
    }

    /**
     * go to register window
     *
     * @param event
     */
    @FXML
    public void registerOnClick(ActionEvent event) {
        ScreenController.loadRegister();
    }
}
