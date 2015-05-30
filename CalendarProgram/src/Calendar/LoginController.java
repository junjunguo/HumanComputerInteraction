package Calendar;

import Calendar.model.CheckUser;
import Calendar.model.Query;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class LoginController implements Initializable {
    @FXML private Text warningText;

    @FXML private TextField userName;
    @FXML private PasswordField userPassword;
    @FXML private Button loginbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //1. use any bean property to add listener create new inner class ChangeListener to handle the changes

        //2. use create inner class EventHandler to handle the ActionEvent

        //3. tag an onAction at FXML use this bean property to handle the action

        loginbtn.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
                                                         @Override
                                                         public void changed(
                                                                 ObservableValue<? extends Boolean> observable,
                                                                 Boolean oldValue, Boolean newValue) {

                                                         }
                                                     });
        //textProperty() gives us access to the Property.
        //Since we will use this class only once, it's a bit overkill to create a normal class.
        // Instead we can use a short form of creating a class and instantiating it.
        // This is called an Anonymous Inner Class as it does not have a name.
        userName.textProperty().addListener(new ChangeListener<String>() {
                                                @Override
                                                public void changed(
                                                        ObservableValue<? extends String> observable, String oldValue,
                                                        String newValue) {

                                                }
                                            });

        loginbtn.setOnAction(new EventHandler<ActionEvent>() {
                                 @Override
                                 public void handle(ActionEvent event) {
                                     String email = userName.getText();
                                     String pass = userPassword.getText();
                                     if (CheckUser.canLogin(email, pass)) {
                                         //        if (true) {
                                         warningText.setFill(Color.CORNFLOWERBLUE);

                                         warningText.setText(
                                                 "Welcome back: " + Query.getUserName(email));
                                         ScreenController.loadView();
                                     } else {
                                         warningText.setFill(Color.valueOf("#0277BD"));
                                         warningText.setText("Wrong id(Email address) or password!");
                                     }
                                 }
                             });
    }


    /**
     * handle users and administration to login
     *
     * @param event
     */
    @FXML
    public void loginOnclick(ActionEvent event) {
//        String email = userName.getText();
//        String pass = userPassword.getText();
//        if (CheckUser.canLogin(email, pass)) {
//            //        if (true) {
//            warningText.setFill(Color.CORNFLOWERBLUE);
//
//            warningText.setText(
//                    "Welcome back: " + Query.getUserName(email));
//            ScreenController.loadView();
//        } else {
//            warningText.setFill(Color.valueOf("#0277BD"));
//            warningText.setText("Wrong id(Email address) or password!");
//        }
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
