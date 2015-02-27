package Calendar;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * Created by GuoJunjun <junjunguo.com> on 27/02/15.
 */
public class EditController implements Initializable {

    public static boolean editExist = false;
    public static int index;
    @FXML private Label labelDescription;
    @FXML private Label labelWhere;
    @FXML private Label labelDate;
    @FXML private Label labelRepeat;
    @FXML private Label labelTo;
    @FXML private Label labelHyphen;
    @FXML private TextArea textAreaDescription;
    @FXML private TextField textFieldBuildingName;
    @FXML private TextField textFieldStartTime;
    @FXML private TextField textFieldFinishTime;
    @FXML private DatePicker datePickerEvent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void btnCancel(ActionEvent event) {
        editExist = false;
        ScreenController.loadView();
    }

    @FXML
    public void btnSave(ActionEvent event) {
        if (inputValidate()) {
            saveAppointment();
            editExist = false;
            ScreenController.loadView();
        }
    }

    /**
     * read from input and save them to the Appointment object
     * <p/>
     * input must be validated before use this method: <li>repeat input must be integer</li> <li>time format</li>
     * <li>input must not null</li>
     */
    private void saveAppointment() {
    }


    /**
     * check if the input is valid
     */
    private boolean inputValidate() {
        boolean b = true;
        System.out.println("Text Area: " + textAreaDescription.getText());
        if (textAreaDescription.getText().length() < 1) {
            feedbackMessages(textAreaDescription, "Descriptions are empty !");
            b = false;
        }
        if (textFieldBuildingName.getText().length() < 1) {
            feedbackMessages(textFieldBuildingName, "building name!");
            b = false;
        }
        if (textFieldStartTime.getText().length() < 1) {
            feedbackMessages(textFieldStartTime, "start time!");
            b = false;
        } else if (!isvalidLocaTime(textFieldStartTime.getText())) {
            feedbackMessages(textFieldStartTime, "format: HH:MM");
            b = false;
        }
        if (textFieldFinishTime.getText().length() < 1) {
            feedbackMessages(textFieldFinishTime, "finish time!");
            b = false;
        } else if (!isvalidLocaTime(textFieldFinishTime.getText())) {
            feedbackMessages(textFieldFinishTime, "format: HH:MM");
            b = false;
        }
        if (datePickerEvent.getValue() == null) {
            final String style = datePickerEvent.getStyle();
            final String text = datePickerEvent.getPromptText();
            datePickerEvent.setPromptText("No date selected!");
            datePickerEvent.setStyle("-fx-text-fill: #0288D1");
            final FadeTransition fade = new FadeTransition(Duration.seconds(0.5), datePickerEvent);
            fade.setFromValue(0.2);
            fade.setToValue(1.0);
            fade.setCycleCount(5);
            fade.setAutoReverse(true);
            fade.play();
            fade.setOnFinished(
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            datePickerEvent.setPromptText(text);
                            datePickerEvent.setStyle(style);
                        }
                    });
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

    /**
     * parse a String to LocalTime
     *
     * @param s
     *
     * @return LocalTime
     */
    private LocalTime stringToLocalTime(String s) {
        //        DateTimeFormatter inputFormat = new DateTimeFormatter("HH:mm");
        LocalTime time = null;
        try {
            s = simpleInput(s);
            time = LocalTime.parse(s);
        } catch (Exception e) {
            System.out.println("parse string to localtime exceptions: " + e);
        }
        return time;
    }

    /**
     * simplify time input
     *
     * @param time
     *
     * @return
     */
    private String simpleInput(String time) {
        //simple input: HHMM
        if (time.length() == 4) {
            time = time.substring(0, 2) + ":" + time.substring(2, 4);
        } else if (time.length() == 1) {
            time = "0" + time + ":00";
        } else if (time.length() == 2) {
            time = time + ":00";
        }
        return time;
    }

    /**
     * check if input string is a valid local time
     *
     * @param s
     *
     * @return
     */
    private boolean isvalidLocaTime(String s) {
        try {
            s = simpleInput(s);
            LocalTime.parse(s);
            return true;
        } catch (Exception e) {
            System.out.println("parse string to localtime exceptions: " + e);
        }
        return false;
    }

    /**
     * check if input string is a positive integer
     *
     * @param value
     *
     * @return
     */
    private boolean isPositiveInteger(String value) {
        try {
            int v = Integer.parseInt(value);
            if (v < 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * check if the input string has a number in side
     *
     * @param value
     *
     * @return
     */
    private boolean containsAnumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) >= "0".charAt(0) && value.charAt(i) <= "9".charAt(0)) {
                return true;
            }
        }
        return false;
    }
}
