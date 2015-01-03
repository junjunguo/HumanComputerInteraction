import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;


/**
 * Created by GuoJunjun on 03.01.15.
 */
public class BorderPaneApp extends Application {
    /*
 liste av de vanligste container-typene (nærmere beskrevet i http://docs.oracle.com/javafx/2/layout/builtin_layouts
 .htm):

HBox og VBox - legger ut elementene horisontalt (x-dimensjonen, dvs. bortover) eller vertikalt (y-dimensjonen, dvs.
nedover) og gjør dem like store i den andre dimensjonen.

GridPane og TilePane - plasserer elementene i et rutenett, TilePane gjør alle ruten like store, mens GridPane er mer
fleksibel.

BorderPane - fordeler elementene i regioner, midten (for hovedinnholdet), top, bunn, venstre og høyre, og passer for
hovedinnholdet i applikasjonen.

AnchorPane - henger elementene fast i punkter knyttet til en eller flere av sidene

Pane - generell container uten spesifikk layout, så posisjonen på elementer må settes manuelt.


Alle container-objektene har en liste med elementer i sin children-liste (hentes ut med getChildren()), som igjen kan
 være container-objekter, om en ønsker, f.eks. en GridPane inni en AnchorPane inni en BorderPane. Hele denne
 strukturen legges så inn i en Scene i en Stage.

Det er generelt to metoder for å legge til barn:

container.getChildren().add(node); // legger til én node
container.getChildren.addAll(node1, node2, node3,....); // legger til flere noder

Noen container-klasser har egne metoder for å legge inn noder, f.eks. har BorderPane én metode for hver av de fem
regionene som den deler panelet inn i.
     */

    /*
Noder

Det finnes noen fellestrekk som gjelder for alle nodene man bruker i JavaFX. Alle noder, utenom rotnoden, legges til
i grafen ved å legge dem inn i children-lista til en Parent-instans. En node kan bare være ett sted i hierarkiet og
dersom man forsøker å legge til et objekt som allerede er i hierarkiet til en annen/ny container, så vil objektet
fjernes fra dens forrige, før den legges til den nye.


Alle noder har en x,y-posisjon og størrelse (desimaltall) i et koordinatsystem med økende verdier mot høyre på
x-aksen, og økende verdier nedover på y-aksen. Med dette er altså (0,0) øverst til venstre. Denne x,y-posisjonen
angis imidlertid ikke direkte, men er kombinasjonen av ulike typer transformasjoner:

translateX og translateY - forskyver noden i x- og y-retningen
rotate - roterer noden et antall grader rundt et gitt referansepunkt.
scaleX og scaleY - skalerer størrelen med en x- og y-faktor og settes med scale-metoden
layoutX og layoutY - gir en ekstra forskyving i x- og y-retning og brukes gjerne i forbindelse med midlertidige
justeringer, f.eks. drag'n drop
Det går også an å lage egne transformasjonsobjekter, hvor disse effektene kan kombineres, og som kan knyttes til noder.
     */


    /*
Figurer

Det finnes en rekke standard-figurer som kan brukes for rent grafisk innhold. Disse er alle subklasser av
Shape-klassen (javafx.scene.shape), som får dermed en del felles egenskaper:

fyll (fill) - fargen eller effekten (av typen Paint) som fyller figuren
strek (stroke) - fargen eller effekten som brukes for å tegne figuren
strek-tykkelse (strokeWidth), plassering (strokeType), stipling (strokeDashOffset) og hjørne/endehåndtering
(strokeLineJoin og strokeLineCap)
Nyttige figurer er strek (Line), rektangel (Rectangle), sirkel og ellipse (Circle og Ellipse), buesegment (Arc),
polygon (Polygon), segmentert figur (Path) og tekst (Text). I tillegg er det en egen klasse for bilder (ImageView som
 viser et Image, som ikke er en Shape). Noen av disse er vist i eksemplet under, hvor center-regionen er fylt med et
 Pane-objekt med noen figurer i, med ulike grafiske effekter.
     */
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        root.setTop(new Text("top"));
        root.setLeft(new Text("bottom"));
        //        root.setCenter(new Text("center"));
        root.setRight(new Text("right"));
        root.setBottom(new ImageView(new Image("http://mw2.google.com/mw-panoramio/photos/medium/78489820.jpg")));

        Pane pane = new Pane();
        pane.setPrefSize(300, 300);
        Line line = new Line(15, 15, 100, 100);
        line.getStrokeDashArray().setAll(10.0d, 10.0d);
        Rectangle rectangle = new Rectangle(150, 10, 50, 90);
        rectangle.setFill(Color.color(1.0, 0, 0, 0.5));
        Ellipse ellipse = new Ellipse(400, 180, 30, 45);
        ellipse.setStroke(Color.rgb(0, 255, 0, 0.7));
        ellipse.setStrokeWidth(5);
        ellipse.setFill(Color.rgb(0, 0, 255, 0.6));

        Text text = new Text(180, 180, "center");
        List<String> fonts = Font.getFamilies();
        text.setFont(new Font(fonts.get((int) (Math.random() * fonts.size())), 32));

        pane.getChildren().setAll(line, rectangle, ellipse, text);

        root.setCenter(pane);


        Scene scene = new Scene(root, 500, 500);

        stage.setScene(scene);
        stage.setTitle("Border pane application 2");
        stage.show();
    }
}
