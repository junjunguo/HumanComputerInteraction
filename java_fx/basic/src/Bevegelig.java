import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by GuoJunjun on 05.01.15.
 */
public class Bevegelig extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new BevegeligController());
        Parent root = loader.load(this.getClass().getResource("fxml/bevegelig.fxml"));

        primaryStage.setTitle("Bevegelig Grafikk");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
