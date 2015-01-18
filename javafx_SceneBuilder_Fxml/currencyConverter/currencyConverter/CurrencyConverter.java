import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Created by GuoJunjun <junjunguo.com> on 16.01.15. */

public class CurrencyConverter extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent gridPane = Program.addFlowPane();

        Scene scene = new Scene(gridPane,360,500);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
