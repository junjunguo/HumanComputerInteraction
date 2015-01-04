import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by GuoJunjun on 04.01.15.
 */
public class Controller {

    @FXML
    private TextField url;

    @FXML
    private TextField filetype;

    @FXML
    private TextField filelocation;

    @FXML
    private TextArea filename;

    @FXML
    private TextArea process;
    @FXML
    private ProgressBar pbs = new ProgressBar(0);


    @FXML
    public void handleStartDownloadAction(ActionEvent event) {
        String urla = url.getText();
        String ftype = (String) (filetype.getText().startsWith(".") ? filetype.getText() : "." + filetype.getText());
        String flocation = filelocation.getText();
        if (flocation.contains(" ")) {// delete empty spaces in location
            flocation = flocation.replaceAll("\\s", "");
        }
        if (ftype.contains(" ")) {// delete empty spaces in ftype
            ftype = ftype.replaceAll("\\s", "");
        }
        System.out.println("1 " + ftype);
        process.clear();
        String[] files = filename.getText().split(",");
        //        pbs = new ProgressBar[files.length];
        for (int i = 0; i < files.length; i++) {
            String fname = files[i];
            System.out.println("2 " + fname);
            if (fname.contains(" ")) {// delete empty spaces in fname
                fname = fname.replaceAll("\\s", "");
            }
            System.out.println("3 " + fname);
            if (fname != "" || fname != " ") {
                System.out.println("download: " + urla);
                String s = DownloadFiles.Download(fname, urla + fname + ftype, ftype, flocation);
                process.setText(s += "\n");
            }
            //            ProgressBar pb = pbs[i] = new ProgressBar();
            pbs.setProgress(i / 50);
        }
    }

}
