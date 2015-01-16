import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/** Created by GuoJunjun <junjunguo.com> on 16.01.15. */

public class Utility {
    private Label currency1 = new Label();
    private Label currency2 = new Label();
    private Label currency3 = new Label();
    private Label currency4 = new Label();

    /**
     * @return a flow pane with all information in side
     */
    public static FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(0, 0, 0, 0));
        flow.setVgap(0);
        flow.setHgap(0);
        flow.setPrefWrapLength(720); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: #DBC0AD;");
        flow.getChildren().addAll(GP1(), GP2(), GP3(), GP4());
        return flow;
    }

    private static GridPane GP1() {

        GridPane gp1 = addGridPane();

        return gp1;
    }

    private static GridPane GP2() {
        GridPane gp2 = addGridPane();

        return gp2;
    }

    private static GridPane GP3() {
        GridPane gp3 = addGridPane();

        return gp3;
    }

    private static GridPane GP4() {
        GridPane gp4 = addGridPane();

        return gp4;
    }

    /**
     * *
     *
     * @return a universal grid pane with general information
     */
    private static GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setPrefSize(360, 125);
        grid.setStyle(
                "-fx-background-color:  #BDA48A,#DBC0AD,#C9AF95;-fx-background-insets: 0,1,1;" +
                "-fx-background-radius: 0,0,0");
        //        grid.setStyle("-fx-border-color: rgb(210,180,160); -fx-border-insets: 0.5");
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);
        // set column rows:
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(90);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(40);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(230);
        col3.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().addAll(col1, col2, col3);

        // column 1, row 1 ----------------->
        ImageView imageView = new ImageView();

        imageView.setFitWidth(65);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        grid.add(imageView, 0, 0);

        //  column 2, row 1 ----------------->
        Label exchange = new Label(); // for column 3

        Label currency = new Label();
        final ComboBox comboBox = Countries.addComboBox();
        comboBox.getSelectionModel().select((int) Math.random() * 10);
        currency.textProperty().bind(comboBox.getSelectionModel().selectedItemProperty());
        currency.visibleProperty().bind(comboBox.visibleProperty().not());
        comboBox.setVisible(false);
        currency.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboBox.setVisible(true);
                comboBox.showingProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean
                            newValue) {
                        if (!comboBox.isShowing()) {
                            comboBox.setVisible(false);
                        }
                    }
                });
            }
        });
        comboBox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!comboBox.isShowing()) {
                    comboBox.setVisible(false);
                }
            }
        });
        grid.add(comboBox, 1, 0);
        grid.add(currency, 1, 0);
        exchange.setText("0.0"); // for column 3
        imageView.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/25721204.jpg"));//for column 1


        //  column 3, row 1 ----------------->
        exchange.setAlignment(Pos.CENTER_RIGHT);
        exchange.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(exchange, 2, 0);
        return grid;
    }


}
