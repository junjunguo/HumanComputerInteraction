import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by GuoJunjun on 03.01.15.
 */
public class MinimalApplication extends Application {// arve javafx.application

    /* .1
    JavaFX har en egen programklasse kalt Application (i pakken javafx.application) som en må arve fra.

    Denne definerer en del metoder som kalles når programmet initialiseres (init), starter (start) opp og stopper
    (stop).
    Av disse er det bare start-metoden som må defineres i din egen hovedprogramklasse.
     */
    @Override
    public void start(Stage stage) throws Exception {//Stage: javafx.stage-pakken
        /* .3 ^
        start-metoden tar inn et argument av typen Stage (i javafx.stage-pakken), som tilsvarer applikasjonsvinduet.
         */
        Pane root = new Pane(); //javafx.scene.layout: container-types: Pane, AnchorPane, BorderPane, GridPane ...
        /* .5 ^
        en instans av Pane (javafx.scene.layout), som gir oss et tomt panel. I tillegg til Pane-instansen så oppgir
        vi her også bredden og høyden Til slutt settes tittelen til applikasjonsvinduet og den vises frem.
         */
        Scene scene = new Scene(root, 500, 500); //
        /* .4 ^
        stage må knyttes til innhold ved at en oppretter en instans av Scene (javafx.scene) med selve innholdet i.
         */
        stage.setScene(scene);
        stage.setTitle("Minimal Application");
        stage.show();
    }

    /* .2
    Og for at det skal skje må du i main-metoden kalle den statiske metoden launch i Application-klassen med navnet
    til din egen klasse som første argument og programargumentene til din main-metode som launch-metoden sitt andre
    argument.
     */
    public static void main(String[] args) {
        launch(MinimalApplication.class, args);// launch minimalApplication
    }
}
