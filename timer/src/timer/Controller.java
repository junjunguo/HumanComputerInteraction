/*
 * Created by GuoJunjun <junjunguo.com> on 16.1.2015.
 *
 * This file is part of timer
 */

package timer;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static int timeSecond = 0, timeMinute = 0, timeHour = 0;
    private static boolean  running  = false;
    private final  Timeline timeline = new Timeline();
    private TextField activeTextField;
    private final int TEXTLIMIT = 2;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        hoursField.setText("00");
        minutesField.setText("00");
        secondsField.setText("00");

        hoursField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    activeTextField = hoursField;
                }
            }
        });

        minutesField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    activeTextField = minutesField;
                }
            }
        });
        secondsField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    activeTextField = secondsField;
                }
            }
        });
    }

    @FXML
    public void btnDelete(ActionEvent actionEvent) {
        if (activeTextField != null) {
            if (activeTextField.getText().length() > 0) {
                activeTextField.setText(activeTextField.getText().substring(0, activeTextField.getText().length() - 1));
            }
        }
    }

    @FXML
    public void btnCancle(ActionEvent actionEvent) {
        if (running) {
            timeline.pause();
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
        if (!running) {
            if (!isInteger(hoursField.getText()) || !isInteger(minutesField.getText()) ||
                !isInteger(secondsField.getText())) {
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
    public void btn0(ActionEvent actionEvent) {
        addNumber(0);
    }

    @FXML
    public void btn1(ActionEvent actionEvent) {
        addNumber(1);
    }

    @FXML
    public void btn2(ActionEvent actionEvent) {
        addNumber(2);
    }

    @FXML
    public void btn3(ActionEvent actionEvent) {
        addNumber(3);
    }

    @FXML
    public void btn4(ActionEvent actionEvent) {
        addNumber(4);
    }

    @FXML
    public void btn5(ActionEvent actionEvent) {
        addNumber(5);
    }

    @FXML
    public void btn6(ActionEvent actionEvent) {
        addNumber(6);
    }

    @FXML
    public void btn7(ActionEvent actionEvent) {
        addNumber(7);
    }

    @FXML
    public void btn8(ActionEvent actionEvent) {
        addNumber(8);
    }

    @FXML
    public void btn9(ActionEvent actionEvent) {
        addNumber(9);
    }

    private void addNumber(int nr) {
        if (activeTextField != null) {
            String s = activeTextField.getText();
            if (s.length() == TEXTLIMIT) {
                if (s.startsWith("0")) {
                    activeTextField.setText(s.substring(1, s.length()) + nr);
                }
            } else {
                activeTextField.setText(s + nr);
            }
        }
    }

    /**
     * call the startTimer method to build a Timeline and start counting down animation
     */
    private void startTimer() {
        if (timeline.getStatus().toString().equalsIgnoreCase("PAUSED")) {
            timeline.play();
        } else {
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (timeSecond == 0) {
                        if (timeMinute > 0) {
                            timeSecond = 60;
                            timeMinute--;
                            minutesField.setText(setText(timeMinute));
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
