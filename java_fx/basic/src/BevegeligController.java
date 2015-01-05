import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Created by GuoJunjun on 05.01.15.
 */
public class BevegeligController {
    @FXML
    Node stickMan, armsAndLegs1, armsAndLegs2;
    @FXML
    Shape eye;

    boolean step = true;

    @FXML
    public void initialize() {
        update();
    }

    @FXML
    public void walk() {
        step = !step;
        stickMan.setLayoutX((stickMan.getLayoutX() + 5));
        update();
    }

    void update() {
        if (step) {
            eye.setFill(Color.BROWN);
        } else {
            eye.setFill(Color.WHITE);
        }
        armsAndLegs1.setVisible(step);
        armsAndLegs2.setVisible(!step);
    }
}
