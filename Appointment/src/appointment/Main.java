package appointment;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setTheStage(primaryStage);
        ScreenController.setTheParent(this);
                ScreenController.loadView();
//        ScreenController.loadEdit();
        ScreenController.showStage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
