/*
 * Author GuoJunjun <junjunguo.com>, created on 15.1.2015.
 */

package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    private double x, y;
    private char operation = ' ';
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
        if (operation != ' ') {
            setY(label.getText());
            label.setText((operate() + ""));
        }
    }

    @FXML
    public void btnC(ActionEvent event) {
        String s = label.getText();
        if (s.length() > 0) {
            label.setText(s.substring(0, s.length() - 1));
        } else {
            labelX.setText("");
            labelY.setText("");
            labelO.setText("");
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
        this.x = Double.parseDouble(x);
        label.setText("");
        labelX.setText("x: " + x);
    }

    /**
     * parse string to double and assign it to variable y
     * <p/>
     * pop out label text to labelY
     *
     * @param y
     */
    public void setY(String y) {
        this.y = Double.parseDouble(y);
        label.setText("");
        labelY.setText("y: " + y);
    }

    /**
     * set Operation Character
     * <p/>
     * and set label text to SetX()
     *
     * @param operation
     */
    public void setOperation(char operation) {
        this.operation = operation;
        String s = label.getText();
        if (s.length() > 0) {
            labelO.setText(operation + "");
            setX(s);
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
        return 0;
    }
}
