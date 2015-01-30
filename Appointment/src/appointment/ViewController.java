package appointment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** Created by GuoJunjun <junjunguo.com> on 30/01/15. */

public class ViewController implements Initializable {

    @FXML ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setCellFactory((Callback<ListView, ListCell>) new GridPane());
        injectAppointments();
    }

    private void injectAppointments() {

    }

    private GridPane setGridPane() {
        GridPane gridpane = null;
        try {
            gridpane = FXMLLoader.load(getClass().getResource("gridpanecell.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gridpane;
    }
}
