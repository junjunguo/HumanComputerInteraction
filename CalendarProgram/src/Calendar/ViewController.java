package Calendar;

import Calendar.model.Appointment;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by GuoJunjun <junjunguo.com> on 27/02/15.
 */
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

    private void test() {
        ListCell<Appointment> test = new ListCell<Appointment>();
        TextFieldListCell textFieldListCell = new TextFieldListCell();
        ChoiceBoxListCell choiceBoxListCell = new ChoiceBoxListCell();
        listView.setCellFactory(TextFieldListCell.forListView());
        TableColumn tableColumn = new TableColumn();
        TreeItem treeItem = new TreeItem();
        //        bind binding
        //treeItem.valueProperty().bind(Bindings.multiply(1.8, (Double)treeItem.valueProperty().getValue()));
        /**
         * implement own binding
         */
        class CelciusFahreheitBinding extends DoubleBinding {
            @Override
            protected double computeValue() {
                ObservableValue<Double> fahrenheit;
                return 0.0;
            }

            public CelciusFahreheitBinding CFBinding(ObservableValue fahrenheit) {
                fahrenheit = fahrenheit;
                return this;
            }

        }
    }


    private void injectAppointments() {
    }

    @FXML
    public void btnAdd(ActionEvent event) {
        ScreenController.loadEdit();
    }

    @FXML
    public void btnConfirm(ActionEvent event) {
    }


    @FXML
    public void btnDecline(ActionEvent event) {
    }

    private void editSelectedAppointment(int index) {
        EditController.editExist = true;
        EditController.index = index;
        ScreenController.loadEdit();
    }
}
