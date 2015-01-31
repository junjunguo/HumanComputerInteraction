package appointment;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/** Created by GuoJunjun <junjunguo.com> on 30/01/15. */

public class ViewController implements Initializable {


    @FXML private ListView listView;


    public ViewController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        injectAppointments();
    }

    private void injectAppointments() {
        ArrayList<Appointment> appointments = DataManager.getAppointments();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Appointment a : appointments) {
            observableList.add(
                    a.getFormal() + "\n" + a.getDato().toString() + "     " + a.getFra().toString() + " - " +
                    a.getTil() + "      at " + a.getRom());
        }
        listView.setItems(observableList);
    }

    @FXML
    public void btnAdd(ActionEvent event) {
        ScreenController.loadEdit();
    }

    @FXML
    public void btnDelete(ActionEvent event) {

    }

    @FXML
    public void btnEdit(ActionEvent event) {

    }

    @FXML
    public void btnUndo(ActionEvent event) {

    }

    @FXML
    public void btnQuit(ActionEvent event) {
        DataManager.saveData();
        Platform.exit();
    }
}
