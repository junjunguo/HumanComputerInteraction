import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import org.json.JSONException;
import org.json.JSONObject;

/** Created by GuoJunjun <junjunguo.com> on 16.01.15. */

public class Utility {
    private static TextField exchange1 = new TextField();
    private static Label     exchange2 = new Label();
    private static Label     exchange3 = new Label();
    private static Label     exchange4 = new Label();

    private static String curreny1, curreny2, curreny3, curreny4;
//    private static double inputValue;

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
        final Label currency = new Label();
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();
        GridPane gp = addGridPane(true, null, comboBox, imageView, currency);
        return gp;
    }

    private static GridPane GP2() {
        final Label currency = new Label();
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();

        GridPane gp = addGridPane(false, exchange2, comboBox, imageView, currency);
        return gp;
    }

    private static GridPane GP3() {
        final Label currency = new Label();
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();

        GridPane gp = addGridPane(false, exchange3, comboBox, imageView, currency);
        return gp;
    }

    private static GridPane GP4() {
        final Label currency = new Label();
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();

        GridPane gp = addGridPane(false, exchange4, comboBox, imageView, currency);

        // listener currency changed
        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                setExchangeImage(exchange4, imageView, newValue.toString());
            }
        });
        //            Label exchange = new Label();
        exchange4.setAlignment(Pos.CENTER_RIGHT);

        //            restcbb(comboBox);
        gp.add(exchange4, 2, 0);


        return gp;
    }

    /**
     * *
     *
     * @return a universal grid pane with general information
     */
    private static GridPane addGridPane(Boolean first, final Label exchange, final ComboBox comboBox, ImageView
            imageView, final Label currency) {
        GridPane grid = initGridPane();

        // column 1, row 1 ----------------->
        imageView.setFitWidth(64);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        grid.add(imageView, 0, 0);

        //  column 2, row 1 ----------------->
        comboBox.getSelectionModel().select((int) (Math.random() * 18));

        // auto hide combo box
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
        if (first) {
        } else {
            //set exchange
//            exchange.setText((getExchange(curreny1, comboBox.getValue().toString().substring(0,3), getInputValue())));
        }
        grid.add(comboBox, 1, 0);
        grid.add(currency, 1, 0);
        return grid;
    }

    /**
     * init grid pane
     *
     * @return grid pane with 1 row & 3 columns
     */
    private static GridPane initGridPane() {
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
        col2.setPrefWidth(60);
        col2.setHalignment(HPos.CENTER);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(210);
        col3.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().addAll(col1, col2, col3);
        return grid;
    }

    /**
     * @param fromCurrency
     * @param toCurrency
     * @param value
     * @return calculated exchange result as a string
     */
    private static String getExchange(String fromCurrency, String toCurrency, double value) {
        try {
            JSONObject currencyrate = new JSONObject(JsonReader.getCurrency(fromCurrency, toCurrency));
            System.out.println(currencyrate);

        } catch (JSONException e) {
            System.out.println(" getExchange: " + e);
        }
        return null;
    }

    /**
     * get TextField value
     *
     * @return double value
     */
    private static double getInputValue() {
        if (isDouble(exchange1.getText())) {
            return Double.parseDouble(exchange1.getText());
        }
        return 0.0;
    }

    /**
     * @param s a String
     * @return true if String s is a number
     */
    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * set image and exchange value in to the given variable
     *
     * @param exchange
     * @param imageView
     * @param item
     */
    private static void setExchangeImage(Label exchange, ImageView imageView, String item) {
        String[] table = item.toString().split(" - ");
        System.out.println("flags/" + table[2] + ".png");
        imageView.setImage(new Image("flags/" + table[2] + ".png"));
        exchange.setText(getExchange(curreny1, curreny2, getInputValue()));
    }
}
