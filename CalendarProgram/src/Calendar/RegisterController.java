package Calendar;

import Calendar.model.Query;
import Calendar.model.Utility;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class RegisterController {
    @FXML private TextField emailField;
    @FXML private TextField firstnameField;
    @FXML private TextField surnameField;
    @FXML private TextField mobileField;
    @FXML private TextField passwordField;
    @FXML private Text warningText;

    public void loginOnClicked(ActionEvent event) {
        ScreenController.loadLogin();
    }

    /**
     * <li>Validate input information <li>Register user if input is valid.
     *
     * @param event
     */
    @FXML
    protected void registerOnClicked(ActionEvent event) {
        if (isInputValid()) {
            String dbRegister = registerUser();
            if (dbRegister.equalsIgnoreCase("succeed")) {
                warningText.setFill(Color.valueOf("#0288D1"));
                warningText.setText("Congratulations! You are successfully registered!");
                try {
                    //                    Thread.currentThread().wait(2000);
                    ScreenController.loadLogin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                warningText.setFill(Color.valueOf("#0277BD"));
                warningText.setText(dbRegister);
            }
        }
    }

    /**
     * Register the user in database
     *
     * @return Register result message
     */
    private String registerUser() {
        String firstname;
        String surname;
        int mobile;
        String pass;
        String email;

        firstname = firstnameField.getText();
        surname = surnameField.getText();
        mobile = Integer.parseInt(mobileField.getText());
        pass = passwordField.getText();
        email = emailField.getText();
        return Query.addUser(email, firstname, surname, mobile, pass);
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true or false
     */
    private boolean isInputValid() {
        boolean b = true;

        if (firstnameField.getText() == null || firstnameField.getText().length() == 0) {
            feedbackMessages(firstnameField, "Not valid first name!");
            b = false;
        }
        if (surnameField.getText() == null || surnameField.getText().length() == 0) {
            feedbackMessages(surnameField, "Not valid last name!");
            b = false;
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            feedbackMessages(emailField, "Not valid email!");
            b = false;
        } else if (!Utility.isValidEmailAddress(emailField.getText())) {
            feedbackMessages(emailField, "Not valid email address!");
            b = false;
        }
        if (mobileField.getText() == null || mobileField.getText().length() == 0) {
            feedbackMessages(mobileField, "Not valid mobile number!");
            b = false;
        } else if (!Utility.isInteger(mobileField.getText())) {
            feedbackMessages(mobileField, "Not valid mobile: use integer!");
            b = false;
        }
        if (passwordField.getText() == null || passwordField.getText().length() < 4) {
            feedbackMessages(passwordField, "Not valid password!");
            b = false;
        }
        return b;
    }

    /**
     * a smart feedback method: Input: a TextInputControl data type and and message Output: blink the given message in
     * the given TextInputControl
     *
     * @param textinput
     * @param message
     */
    private void feedbackMessages(TextInputControl textinput, String message) {
        final TextInputControl tic = textinput;
        final String style = tic.getStyle();
        tic.setText(message);
        tic.setStyle("-fx-text-fill: #0288D1");
        // blink text
        final FadeTransition fade = new FadeTransition(Duration.seconds(0.5), tic);
        fade.setFromValue(0.2);
        fade.setToValue(1.0);
        fade.setCycleCount(5);
        fade.setAutoReverse(true);
        fade.play();
        fade.setOnFinished(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tic.clear();
                        tic.setStyle(style);
                    }
                });
    }
}
