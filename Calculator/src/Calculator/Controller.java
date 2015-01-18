/*
 * Author GuoJunjun <junjunguo.com>, created on 15.1.2015.
 */

package Calculator;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double x, y;
    private char operation = ' ';

    @FXML
    Button btnC;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    String s = label.getText();
                    if (s.length() > 0) {
                        label.setText(s.substring(0, s.length() - 1));
                    } else {
                        initValue();
                    }
                }
                if (event.getClickCount() == 2) {
                    initValue();
                }
            }
        });
    }

    @FXML
    Label warning;
    @FXML
    Label label;
    @FXML
    Label labelX;
    @FXML
    Label labelY;
    @FXML
    Label labelO;

    @FXML
    public void btn0(ActionEvent event) {
        setText("0");
    }

    @FXML
    public void btn1(ActionEvent event) {
        setText("1");
    }

    @FXML
    public void btn2(ActionEvent event) {
        setText("2");
    }

    @FXML
    public void btn3(ActionEvent event) {
        setText("3");
    }

    @FXML
    public void btn4(ActionEvent event) {
        setText("4");
    }

    @FXML
    public void btn5(ActionEvent event) {
        setText("5");
    }

    @FXML
    public void btn6(ActionEvent event) {
        setText("6");
    }

    @FXML
    public void btn7(ActionEvent event) {
        setText("7");
    }

    @FXML
    public void btn8(ActionEvent event) {
        setText("8");
    }

    @FXML
    public void btn9(ActionEvent event) {
        setText("9");
    }

    @FXML
    public void btnPlus(ActionEvent event) {
        setOperation('+');
    }

    @FXML
    public void btnMinus(ActionEvent event) {
        setOperation('-');
    }

    @FXML
    public void btnMutiply(ActionEvent event) {
        setOperation('*');
    }

    @FXML
    public void btnDivide(ActionEvent event) {
        setOperation('/');
    }

    @FXML
    public void btnMod(ActionEvent event) {
        setOperation('%');
    }

    @FXML
    public void btnEqual(ActionEvent event) {
        if (operation == ' ') {
            showWarning("No operation sign !", 2);
        } else if (label.getText() == "") {
            showWarning("No input found !", 2);
        } else {
            setY(label.getText());
            label.setText((operate() + ""));
        }
    }


    @FXML
    public void btnDot(ActionEvent event) {
        setText(".");
    }

    @FXML
    public void btnPDM(ActionEvent event) {
        String s = label.getText();
        if (s.length() > 0 && !s.equalsIgnoreCase("0")) {
            if (s.startsWith("-")) {
                label.setText(s.replace("-", ""));
            } else {
                label.setText("-" + s);
            }
        }
    }

    /**
     * parse string to double and assign it to variable x
     * <p/>
     * pop label text to labelX
     *
     * @param x
     */
    public void setX(String x) {
        if (x != "") {
            this.x = Double.parseDouble(x);
            label.setText("");
            labelX.setText("" + x);
        }
    }

    /**
     * parse string to double and assign it to variable y
     * <p/>
     * pop out label text to labelY
     *
     * @param y
     */
    public void setY(String y) {
        if (y != " ") {
            this.y = Double.parseDouble(y);
            label.setText("");
            labelY.setText("" + y);
        }
    }

    /**
     * set Operation Character
     * <p/>
     * and set label text to SetX()
     *
     * @param operation
     */
    public void setOperation(char operation) {
        //if first operation
        if (labelO.getText() == "") {
            System.out.println("first op");
            this.operation = operation;
            String s = label.getText();
            if (s.length() > 0) {
                labelO.setText(operation + "");
                setX(s);
            }
        } else if (labelY.getText() != "") { //reuse result:
            System.out.println("reuse result +");
            setX(label.getText());
            this.operation = operation;
            label.setText("");
        } else if (labelY.getText() == "" && label.getText() == "") {
            showWarning(x + " " + operation + " ? (lack of input)", 1);

        } else {// continue operation
            System.out.println("continue op ...");
            setY(label.getText());
            if (labelX.getText() != "" && labelY.getText() != "") {
                setX(operate() + "");
                this.operation = operation;
                labelY.setText("");
                label.setText("");
            }
        }
    }

    /**
     * append String s to label
     *
     * @param s String
     */
    private void setText(String s) {
        String l = label.getText();
        if (l.length() < 7) {
            if (l.equalsIgnoreCase("0")) {
                label.setText(l + "." + s);
            } else if (s.equalsIgnoreCase(".") && l.contains(".")) {
                // do nothing
            } else {
                label.setText(l + s);
            }
        }
    }

    /**
     * operate x and y by operation value
     *
     * @return double result
     */
    private double operate() {
        if (x == 0 && operation == '/') {
            showWarning("0 can not be divided !", 3);
        } else {
            switch (operation) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    return x / y;
                case '%':
                    return x % y;
            }
        }
        return 0;
    }

    /**
     * send a warning text at input area.
     *
     * @param s       String s will be showing
     * @param seconds duration in seconds
     */
    private void showWarning(String s, int seconds) {
        label.setVisible(false);
        warning.setVisible(true);
        warning.setText(s);
        FadeTransition fade = new FadeTransition(Duration.seconds(0.5), warning);
        fade.setFromValue(1.0);
        fade.setToValue(0.7);
        fade.setCycleCount((2 * seconds));
        fade.setAutoReverse(true);
        fade.play();
        fade.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setVisible(true);
                warning.setVisible(false);
            }
        });
    }

    /**
     * init all values: x, y, operation, and labels
     */
    private void initValue() {
        labelX.setText("");
        labelY.setText("");
        labelO.setText("");
        label.setText("");
        x = 0;
        y = 0;
        operation = ' ';
    }

}
