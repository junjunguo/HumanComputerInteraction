import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by GuoJunjun on 04.01.15.
 */
public class TestfxmlV1Controller {


    @FXML
    private ImageView imageright;
    @FXML
    private ImageView imageleft;
    @FXML
    private ImageView imagecenter;
    @FXML
    private ImageView imagebottom;

    @FXML
    public TextField textField;

    @FXML
    public void handleUpcaseAction(ActionEvent event) {
        textField.setText(textField.getText().toUpperCase());
    }

    @FXML
    public void handleRightImgAction(ActionEvent event) {
        if (imageright.getImage() == null) {
            imageright.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/58246420.jpg"));
        } else
            imageright.setImage(null);
    }

    @FXML
    public void handleLeftImgAction(ActionEvent event) {
        imageleft.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/77835780.jpg"));
    }

    @FXML
    public void handleCenterImgAction(ActionEvent event) {
        imagecenter.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/53278802.jpg"));
    }

    @FXML
    public void handleBottomImgAction(ActionEvent event) {
        imagebottom.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/78489820.jpg"));
    }
}
