package timer;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller {
    private static int timeSecond = 0, timeMinute = 0, timeHour = 0;
    private static boolean running = false;
    private final Timeline timeline = new Timeline();
    @FXML
    TextField hoursField;
    @FXML
    TextField minutesField;
    @FXML
    TextField secondsField;

    @FXML
    Text warning;
    @FXML
    Button btn10 = new Button(), btnDelete = new Button(), btnCancle = new Button(), btnSet = new Button();


    public Controller() {
        final int TEXTLIMIT = 2;
        hoursField = new TextField();
        minutesField = new TextField();
        secondsField = new TextField();

//        System.out.println("controller called");

        
        secondsField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("setonkeytyped handle called");
                String s = secondsField.getText();
                if (s.length() > TEXTLIMIT) {
                    secondsField.setText((String) s.subSequence(s.length() - TEXTLIMIT, s.length()));
                }
            }
        });

//        System.out.printf("controller called 2");
        hoursField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("changed;");
                System.out.println(observable.getValue());
                System.out.println("old: " + oldValue);
                System.out.println("new: " + newValue);
            }
        });
    }


    @FXML
    public void btnCancle(ActionEvent actionEvent) {
        if (running) {
            timeline.stop();
            running = false;
        } else {
            hoursField.setText("00");
            minutesField.setText("00");
            secondsField.setText("00");
        }
        hoursField.setEditable(true);
        minutesField.setEditable(true);
        secondsField.setEditable(true);
    }

    @FXML
    public void btnSet(ActionEvent event) {
        System.out.println("getcursor: "+secondsField.getCursor());
        
        if (!running) {
            if (!isInteger(hoursField.getText()) || !isInteger(minutesField.getText()) || !isInteger(secondsField.getText())) {
                warning.setText("Input must be Integers !");
            } else {
                timeHour = Integer.parseInt(hoursField.getText());
                timeMinute = Integer.parseInt(minutesField.getText());
                timeSecond = Integer.parseInt(secondsField.getText());
                if (timeHour == 0 && timeMinute == 0 && timeSecond == 0) {
                    warning.setText("Oops Remember Input !");
                } else {
                    warning.setText("");
                    startTimer();
                    hoursField.setEditable(false);
                    minutesField.setEditable(false);
                    secondsField.setEditable(false);
                    running = true;
                }
            }
        }
    }

    @FXML
    public void btnDelete(ActionEvent actionEvent) {

    }

    @FXML
    public void btn0(ActionEvent actionEvent) {

    }

    @FXML
    public void btn1(ActionEvent actionEvent) {

    }

    @FXML
    public void btn2(ActionEvent actionEvent) {

    }

    @FXML
    public void btn3(ActionEvent actionEvent) {

    }

    @FXML
    public void btn4(ActionEvent actionEvent) {

    }

    @FXML
    public void btn5(ActionEvent actionEvent) {

    }

    @FXML
    public void btn6(ActionEvent actionEvent) {

    }

    @FXML
    public void btn7(ActionEvent actionEvent) {

    }

    @FXML
    public void btn8(ActionEvent actionEvent) {

    }

    @FXML
    public void btn9(ActionEvent actionEvent) {

    }

    /**
     * call the startTimer method to build a Timeline and start counting down animation
     */
    private void startTimer() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (timeSecond == 0) {
                    if (timeMinute > 0) {
                        timeSecond = 60;
                        timeMinute--;
                        minutesField.setText(setText(timeSecond));
                    } else {
                        if (timeHour > 0) {
                            timeMinute = 60;
                            timeHour--;
                            hoursField.setText(setText(timeHour));

                            timeSecond = 60;
                            timeMinute--;
                            minutesField.setText(setText(timeMinute));
                        } else { // s=0; m=0; h=0
                            timeline.stop();
                            // finish animation:


                            hoursField.setEditable(true);
                            minutesField.setEditable(true);
                            secondsField.setEditable(true);
                            running = false;

                            // blink text when finished
                            FadeTransition fade = new FadeTransition(Duration.seconds(0.6), hoursField);
                            fade.setFromValue(1.0);
                            fade.setToValue(0.3);
                            fade.setCycleCount(10);
                            fade.setAutoReverse(true);
                            fade.play();

                            FadeTransition fade2 = new FadeTransition(Duration.seconds(0.6), minutesField);
                            fade2.setFromValue(1.0);
                            fade2.setToValue(0.3);
                            fade2.setCycleCount(10);
                            fade2.setAutoReverse(true);
                            fade2.play();

                            FadeTransition fade3 = new FadeTransition(Duration.seconds(0.6), secondsField);
                            fade3.setFromValue(1.0);
                            fade3.setToValue(0.3);
                            fade3.setCycleCount(10);
                            fade3.setAutoReverse(true);
                            fade3.play();

                            return;
                        }
                    }
                }
                timeSecond--;
                secondsField.setText(setText(timeSecond));
            }
        }));
        timeline.play();
    }

    /**
     * @param s a String
     * @return true if String s is a number
     */
    private boolean isInteger(String s) {
        if (s.charAt(0) == '0') {
            s = s.substring(1);
        }
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * @param n a number
     * @return a to character string
     */
    private String setText(int n) {
        return n < 10 ? "0" + n : "" + n;
    }
}
