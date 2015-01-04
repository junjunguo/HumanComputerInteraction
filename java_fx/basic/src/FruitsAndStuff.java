import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FruitsAndStuff extends Application {

    // Defines the rootnode as a field, which enables the lookup(String)-method from anywhere in the class
    private BorderPane componentLayout = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Example GUI");

        // Padding defines how close this nodes' borders can be another ones'
        // Insets' parameters defines the distance for top,right,bottom,left
        componentLayout.setPadding(new Insets(20, 20, 20, 20));

        // Sets the different areas in the borderpane
        componentLayout.setTop(createTop());
        componentLayout.setCenter(createCenter());
        componentLayout.setBottom(createBottom());

        // Adds the root of the scene graph to the scene, and sets the scene to the stage
        Scene appScene = new Scene(componentLayout, 500, 500);
        primaryStage.setScene(appScene);
        primaryStage.show();
    }

    private Node createCenter() {

        final FlowPane listPane = new FlowPane();

        // Sets id to make the flowpane reachable
        listPane.setId("list_pane_center");

        // Defines the distance between components in the flowpane
        listPane.setHgap(100);

        Label listLbl = new Label("Vegetables");

        ListView<String> vegetables = new ListView<String>(FXCollections.observableArrayList("Asparagus", "Beans",
                "Broccoli", "Cabbage", "Carrot", "Celery", "Cucumber", "Leek", "Mushroom", "Pepper", "Radish",
                "Shallot", "Spinach", "Swede", "Turnip"));

        vegetables.setMaxHeight(300);

        // Sets id to make the listview reachable
        vegetables.setId("vegetables_center");

        listPane.getChildren().addAll(listLbl, vegetables);
        listPane.setVisible(false);

        return listPane;
    }

    private Node createTop() {

        final FlowPane choicePane = new FlowPane();

        // Sets id to make the flowpane reachable
        choicePane.setId("choice_pane_top");
        choicePane.setHgap(100);

        Label choiceLbl = new Label("Fruits");

        ChoiceBox<String> fruits = new ChoiceBox<String>(FXCollections.observableArrayList("Apple", "Apricot",
                "Banana", "Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));

        fruits.setId("fruits_top");

        choicePane.getChildren().addAll(choiceLbl, fruits);

        return choicePane;
    }

    private Node createBottom() {

        StackPane sp = new StackPane();
        sp.setPadding(new Insets(10, 10, 10, 10));

        // setStyle is given a CSS-text to set background color
        sp.setStyle("-fx-background-color: #336699;");

        Button vegFruitBut = new Button("Fruit or Veg");

        vegFruitBut.setOnAction(new EventHandler<ActionEvent>() {

            // Implements the handle "inline" with a anonymous inner class
            @Override
            public void handle(ActionEvent event) {

                // Uses the root to the scene graph, and retrieves the references through the object id. Lookup is
                // given CSS-text.
                Node choicePane = componentLayout.lookup("#choice_pane_top");
                Node listPane = componentLayout.lookup("#list_pane_center");

                choicePane.setVisible(!choicePane.isVisible());
                listPane.setVisible(!listPane.isVisible());
            }
        });

        Button regBut = new Button("Register");

        regBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Node choicePane = componentLayout.lookup("#choice_pane_top");

                if (choicePane.isVisible()) {
                    ChoiceBox<String> fruits = (ChoiceBox<String>) componentLayout.lookup("#fruits_top");

                    // Retrieves and prints the selected fruit
                    System.out.println(fruits.getSelectionModel().getSelectedItem());
                } else {
                    ListView<String> vegetables = (ListView<String>) componentLayout.lookup("#vegetables_center");
                    System.out.println(vegetables.getSelectionModel().getSelectedItem());
                }
            }
        });

        sp.getChildren().addAll(vegFruitBut, regBut);

        // Aligns the buttons in the stackpane
        StackPane.setAlignment(vegFruitBut, Pos.CENTER_LEFT);
        StackPane.setAlignment(regBut, Pos.CENTER_RIGHT);

        return sp;
    }
}