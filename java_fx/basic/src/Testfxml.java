import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Created by GuoJunjun on 04.01.15.
 */
public class Testfxml extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(this);

        Parent root = fxmlLoader.load(this.getClass().getResource("fxml/testfxml.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

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
        imageright.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/58246420.jpg"));
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

    public static void main(String[] args) {
        launch(args);
    }
}
