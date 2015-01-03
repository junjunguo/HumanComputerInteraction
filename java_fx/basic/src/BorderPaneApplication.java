import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by GuoJunjun on 03.01.15.
 */
public class BorderPaneApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {// stage tilsvar appplications vidu
        //container type (layout):
        /*
        Her er en liste av de vanligste container-typene (nærmere beskrevet i http://docs.oracle
        .com/javafx/2/layout/builtin_layouts.htm):

HBox og VBox - legger ut elementene horisontalt (x-dimensjonen, dvs. bortover) eller vertikalt (y-dimensjonen, dvs.
nedover) og gjør dem like store i den andre dimensjonen.
GridPane og TilePane - plasserer elementene i et rutenett, TilePane gjør alle ruten like store, mens GridPane er mer
fleksibel.
BorderPane - fordeler elementene i regioner, midten (for hovedinnholdet), top, bunn, venstre og høyre, og passer for
hovedinnholdet i applikasjonen.
AnchorPane - henger elementene fast i punkter knyttet til en eller flere av sidene
Pane - generell container uten spesifikk layout, så posisjonen på elementer må settes manuelt.
         */
        BorderPane root = new BorderPane();
        root.setTop(new Text("top node text"));// set in node value
        root.setBottom(new Text("bottom node text"));
        root.setCenter(new ImageView(new Image("http://mw2.google.com/mw-panoramio/photos/medium/58246420.jpg")));
        // scene
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Border Pane Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(BorderPaneApplication.class, args);
    }
}
