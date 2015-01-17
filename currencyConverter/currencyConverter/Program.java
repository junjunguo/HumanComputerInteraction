import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.plaf.basic.BasicColorChooserUI;
import java.text.DecimalFormat;

/** Created by GuoJunjun <junjunguo.com> on 16.01.15. */

public class Program {
    private static       TextField exchange1 = new TextField();
    private static       Label     exchange2 = new Label();
    private static       Label     exchange3 = new Label();
    private static       Label     exchange4 = new Label();
    private static final Label     currency1 = new Label();
    private static final Label     currency2 = new Label();
    private static final Label     currency3 = new Label();
    private static final Label     currency4 = new Label();
    private static       double    rate12    = 0, rate13 = 0, rate14 = 0;
    private static int           anumber = 0;
    private static DecimalFormat df      = new DecimalFormat("#0.000");

    /**
     * @return a flow pane with all information in side
     */
    public static FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(0, 0, 0, 0));
        flow.setVgap(0);
        flow.setHgap(0);
        flow.setPrefWrapLength(720); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: #C6AC93;");
        flow.getChildren().addAll(GP1(), GP2(), GP3(), GP4());
        return flow;
    }

    private static GridPane GP1() {
        exchange1.setFont(Font.font("-fx-font-family: sans-serif", 30));
        exchange1.setStyle("-fx-text-fill: #C4554B; -fx-background-color: #CFB398 ");
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();
        GridPane gp = addGridPane(comboBox, imageView, currency1);
        gp.setStyle("-fx-background-color: #CFB398");
        imageView.setImage(new
                                   Image(
                "flags/" + comboBox.getSelectionModel().getSelectedItem().toString().split(" - " +
                                                                                           "")
                        [2] + ".png"));
        // listener currency changed
        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String[] table = newValue.toString().split(" - ");
                imageView.setImage(new Image("flags/" + table[2] + ".png"));

                rate12 = getExchangeRate(
                        comboBox.getSelectionModel().getSelectedItem().toString()
                                .substring(0, 3), currency2.getText().substring(0, 3));
                exchange2.setText(df.format(rate12 *
                                            getInputValue()) + "");

                rate13 = getExchangeRate(
                        comboBox.getSelectionModel().getSelectedItem().toString()
                                .substring(0, 3), currency3.getText().substring(0, 3));
                exchange3.setText(df.format(rate13 *
                                            getInputValue()) + "");

                rate14 = getExchangeRate(
                        comboBox.getSelectionModel().getSelectedItem().toString()
                                .substring(0, 3), currency4.getText().substring(0, 3));
                exchange4.setText(df.format(rate14 *
                                            getInputValue()) + "");
            }
        });
        exchange1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (isDouble(newValue)) {
                    double value = Double.parseDouble(newValue);
                    exchange2.setText(df.format(value * rate12));
                    exchange3.setText(df.format(value * rate13));
                    exchange4.setText(df.format(value * rate14));
                }
            }
        });
        exchange1.setAlignment(Pos.CENTER_RIGHT);
        gp.add(exchange1, 2, 0);
        return gp;
    }

    private static GridPane GP2() {
        exchange2.setFont(Font.font("-fx-font-family: sans-serif", 30));
        exchange2.setTextFill(Paint.valueOf("#32281F"));
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();

        GridPane gp = addGridPane(comboBox, imageView, currency2);
        imageView.setImage(new Image(
                "flags/" + comboBox.getSelectionModel().getSelectedItem().toString().split(" - ")[2] + ".png"));
        rate12 = getExchangeRate(currency1.getText().substring(0, 3),
                                 comboBox.getSelectionModel().getSelectedItem().toString()
                                         .substring(0, 3));
        exchange2.setText(df.format(rate12 *
                          getInputValue()) + "");
        // listener currency changed
        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                imageView.setImage(new Image("flags/" + newValue.toString().split(" - ")[2] + ".png"));
                rate12 = getExchangeRate(currency1.getText().substring(0, 3), newValue.toString().substring(0, 3));
                exchange2.setText(df.format(rate12 *
                                  getInputValue()) + "");
            }
        });
        exchange2.setAlignment(Pos.CENTER_RIGHT);
        gp.add(exchange2, 2, 0);
        return gp;
    }

    private static GridPane GP3() {
        exchange3.setFont(Font.font("-fx-font-family: sans-serif", 30));
        exchange3.setTextFill(Paint.valueOf("#32281F"));
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();
        GridPane gp = addGridPane(comboBox, imageView, currency3);
        imageView.setImage(new Image(
                "flags/" + comboBox.getSelectionModel().getSelectedItem().toString().split(" - ")[2] + ".png"));
        rate13 = getExchangeRate(currency1.getText().substring(0, 3),
                                 comboBox.getSelectionModel().getSelectedItem().toString()
                                         .substring(0, 3));
        exchange3.setText(df.format(rate13 *
                          getInputValue()) + "");
        // listener currency changed
        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                imageView.setImage(new Image("flags/" + newValue.toString().split(" - ")[2] + ".png"));
                rate13 = getExchangeRate(currency1.getText().substring(0, 3), newValue.toString().substring(0, 3));
                exchange3.setText(df.format(rate13 *
                                  getInputValue()) + "");
            }
        });
        exchange3.setAlignment(Pos.CENTER_RIGHT);
        gp.add(exchange3, 2, 0);
        return gp;
    }

    private static GridPane GP4() {
        exchange4.setFont(Font.font("-fx-font-family: sans-serif", 30));
        exchange4.setTextFill(Paint.valueOf("#32281F"));
        final ImageView imageView = new ImageView();
        final ComboBox comboBox = Countries.addComboBox();
        GridPane gp = addGridPane(comboBox, imageView, currency4);
        imageView.setImage(new Image(
                "flags/" + comboBox.getSelectionModel().getSelectedItem().toString().split(" - ")[2] + ".png"));
        rate14 = getExchangeRate(currency1.getText().substring(0, 3),
                                 comboBox.getSelectionModel().getSelectedItem().toString()
                                         .substring(0, 3));
        exchange4.setText(df.format(rate14 *
                          getInputValue()) + "");

        // listener currency changed
        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                imageView.setImage(new Image("flags/" + newValue.toString().split(" - ")[2] + ".png"));
                rate14 = getExchangeRate(currency1.getText().substring(0, 3), newValue.toString().substring(0, 3));
                exchange4.setText(df.format(rate14 *
                                  getInputValue()) + "");
            }
        });
        exchange4.setAlignment(Pos.CENTER_RIGHT);
        gp.add(exchange4, 2, 0);
        return gp;
    }

    /**
     * *
     *
     * @return a universal grid pane with general information
     */
    private static GridPane addGridPane(final ComboBox comboBox, ImageView imageView, final Label currency) {
        GridPane grid = initGridPane();

        // column 1, row 1 ----------------->
        imageView.setFitWidth(64);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        grid.add(imageView, 0, 0);

        //  column 2, row 1 ----------------->

        comboBox.setCellFactory(
                new Callback<ListView<String>, ListCell<String>>() {
                    @Override public ListCell<String> call(ListView<String> param) {
                        final ListCell<String> cell = new ListCell<String>() {
                            {
//                                super.setPrefWidth(360);
                                
                            }
                            @Override public void updateItem(String item,
                                                             boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    setText(item);
                                    setTextFill(Paint.valueOf("#7c5d34"));

//                                    setStyle("-fx-background-color: #C6AC93;" +
//                                             "-fx-highlight-fill: #7C5D34;" +
//                                             "-fx-highlight-text-fill: #C6BBAC;" +
//                                             "");
                                }
                            }
                        };
                        return cell;
                    }

                });
        
        
        
        comboBox.getSelectionModel().select((int) (Math.random() * 3) + anumber);
        anumber += 5;
        // auto hide combo box
        currency.setFont(Font.font("-fx-font-family: sans-serif", 15));
        currency.setTextFill(Paint.valueOf("#7c5d34"));

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
                "-fx-background-color:  #BDA48A,#DBC0AD,#C6AC93;-fx-background-insets: 0,1,1;" +
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
     * *
     *
     * @param fromCurrency
     * @param toCurrency
     * @return double rate
     */
    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            return new JSONObject(JsonReader.getCurrency(fromCurrency, toCurrency)).getDouble("rate");
        } catch (JSONException e) {
        }
        return 0;
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
}
