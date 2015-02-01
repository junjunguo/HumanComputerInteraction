package GreenAppointment;

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

    private int deletedAppointmentIndex;
    private Appointment deletedApppointment;
    @FXML private ListView listView;


    public ViewController() {
        deletedAppointmentIndex = 0;
        //        deletedApppointment = new Appointment();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        injectAppointments();
    }

    private void injectAppointments() {
        ArrayList<Appointment> appointments = DataManager.getAppointments();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Appointment a : appointments) {
            int repeat = a.getRepetisjon();
            if (repeat == 0) {
                observableList.add(
                        a.getFormal() + "\n" + a.getDato().toString() + "     " + a.getFra().toString() + " - " +
                        a.getTil() + "      at " + a.getRom());
            } else {
                for (int i = 0; i <= repeat; i++) {
                    observableList.add(
                            a.getFormal() + "\n" + a.getDato().plusDays(i).toString() + "     " +
                            a.getFra().toString() + " - " +
                            a.getTil() + "      at " + a.getRom());
                }
            }
        }
        listView.setItems(observableList);
    }

    @FXML
    public void btnAdd(ActionEvent event) {
        ScreenController.loadEdit();
    }

    @FXML
    public void btnDelete(ActionEvent event) {
        if (listView.getSelectionModel() != null) {
            int index = calculateAppointmentsindex(listView.getSelectionModel().getSelectedIndex());
            deletedAppointmentIndex = index;
            deletedApppointment = DataManager.getAppointments().remove(index);
            injectAppointments();
        }
    }

    /**
     * Give index number from listView & find the Appointment object's index in the appointments list
     *
     * @param index from listView
     *
     * @return the Appointment objects index in appointments list; -1 if not found;
     */
    private int calculateAppointmentsindex(int index) {
        int appindex = 0;
        int nr = -1;
        for (Appointment a : DataManager.getAppointments()) {
            appindex++;
            nr++;
            int rep = a.getRepetisjon();
            nr += rep;
            if (index >= nr - rep && index <= nr) { // nr - rep <= index <= nr
                return appindex;
            }
        }
        System.out.println("Calculate appointments's index: NOT FOUND!");
        return -1;
    }

    @FXML
    public void btnEdit(ActionEvent event) {
        if (listView.getSelectionModel() != null) {
            editSelectedAppointment(calculateAppointmentsindex(listView.getSelectionModel().getSelectedIndex()));
        }
    }

    private void editSelectedAppointment(int index) {
        ScreenController.loadEdit();
        Appointment a = DataManager.getAppointments().get(index);

        // make a new window for edit ...
    }

    @FXML
    public void btnUndo(ActionEvent event) {
        if (deletedApppointment != null) {
            DataManager.getAppointments().add(deletedAppointmentIndex, deletedApppointment);
            deletedAppointmentIndex = 0;
            deletedApppointment = null;
            injectAppointments();
        }
    }

    @FXML
    public void btnQuit(ActionEvent event) {
        DataManager.saveData();
        Platform.exit();
    }
}
