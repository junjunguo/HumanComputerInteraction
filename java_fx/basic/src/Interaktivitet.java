import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by GuoJunjun on 04.01.15.
 * <p/>
 * <p/>
 * Interaktivitet
 * <p/>
 * De mest interessante nodene er de som er interaktive, altså reagerer på input fra brukeren og brukes til å styre
 * applikasjonen og redigere applikasjonsdata.
 * <p/>
 * De interaktive komponentene har en felles måte å rapportere hva brukeren gjør, gjennom såkalte hendelser (eng:
 * event). Hendelsene kan fortelle om både elementære ting (såkalte leksikalske hendelser) som at muspekeren flyttes
 * eller at en tast trykkes ned, eller mer høynivå ting (såkalte syntaktiske hendelser) som at en knapp trykkes, meny-
 * eller liste-element velges, tekst redigeres osv. For å motta en hendelse, så må applikasjonen registrere såkalte
 * lyttere, dvs. objekter som implementerer spesifikke lytter-grensesnitt og som får beskjed om hendelsene ved at
 * spesifikke metoder kalles.
 * <p/>
 * Det er to hovedkategorier hendelser, interaksjonshendelser og dataendringshendelser, og disse bruker hver sine
 * lyttergrensesnitt og metoder for å registrere lyttere.
 */
public class Interaktivitet extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        final TextField textField = new TextField("Center");
        final Text textlytter = new Text("lytter:");
        final Text centerText = new Text(180, 180, textField.getText());

/*
Interaksjonshendelsen "action"
Når brukeren trykker return (for å angi at teksten er ferdigredigert), så genereres en interaksjonshendelser kalt
"action" av typen ActionEvent. Denne rapporteres til grensesnittet EventHandler<ActionEvent> og metoden handle
(ActionEvent). I praksis betyr dette at grensesnittet med tilhørende metode må implementeres av et objekt, og dette
objektet må registreres som lytter. Det vanlige er at lytteren implementeres vha. en såkalt anonym indreklasse, som
enkelt sagt er et enkeltobjekt som implementerer grensesnittet uten at en eksplisitt må opprette og navngi en ny klasse.
 */

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent args0) {
                centerText.setFill(Color.rgb(0, 0, 255, 0.8));
                centerText.setText(textField.getText().toUpperCase());
            }
        });
        /*
Denne lytter(grensesnitt-instans)en oppgis direkte som argument til metoden som registrerer lytteren. Det finnes to
(typer) metoder som brukes til dette:

en generell addEventHandler-metode, som tar inn en hendelsestype og lyttereren, i dette tilfellet addEventHandler
(ActionEvent.ACTION, new EventHandler<ActionEvent>() {... });
spesielle setOnXXX-metoder, som brukes for spesifikke hendelsestyper og tar inn en lytter, i dette tilfellet
setOnAction(, new EventHandler<ActionEvent>() {... })
         */


/*
Dataendringshendelse for "text"-egenskapen

Mens brukeren redigerer teksten i et tekstfelt, så genereres det kontinuerlig (for hver enkelt-endring) en
dataendringshendelser for "text"-egenskapen (eng: property) til tekstfeltet. En slik egenskap kan ses på som en verdi
 (i dette tilfellet en String) som er innkapslet av et objekt som lar en lese, endre og lytte til endringer. Dette er
  en generell teknikk som brukes av alle dataorienterte komponenter, for å bruke og redigere data. Denne typen
  hendelser rapporteres til grensesnittet ChangeListener spesialisert til typen data, i dette tilfellet
  ChangeListener<String> og metoden changed.
 */

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //                centerText.setText(textField.getText());
                textlytter.setFill(Color.rgb(0, 255, 255));
                textlytter.setText(textField.getText());
            }
        });

        root.setTop(textField);
        root.setCenter(textlytter);
        ImageView imageview = new ImageView();
        imageview.setImage(new Image("http://mw2.google.com/mw-panoramio/photos/medium/77233663.jpg"));
        imageview.setFitHeight(100);


        root.setBottom(imageview);
        root.setRight(centerText);

        Scene scene = new Scene(root, 500, 500);

        scene.getStylesheets().add("css/interaktivitet.css");
        stage.setScene(scene);
        stage.setTitle("Interaktivitet");
        stage.show();
    }
}
