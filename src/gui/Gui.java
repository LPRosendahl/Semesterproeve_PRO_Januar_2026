package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Juletræ;
import model.JuletræsGrossist;

public class Gui extends Application {


    private static Controller controller;

    public static void setController(Controller controller) {
        Gui.controller = controller;
    }

    // ----- INSTANS VARIABLER -----
    private ListView<JuletræsGrossist> listViewGrossister = new ListView<>();
    private ListView<Juletræ> listViewJuletræ = new ListView<>();
    private TextArea textAreaHøjdeSorteredeJuletræer = new TextArea();
    private Button buttonSorter = new Button("Alle juletræer sorteret efter højde");
    private Button buttonPrisPrDato = new Button("Pris på dato");
    private TextField textFieldDato = new TextField();
    private TextField textFieldPris = new TextField();


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Juletræsgrossist");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(15);
        pane.setVgap(10);

        this.initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initContent(GridPane pane) {
        // ----- LABELS -----
        pane.add(new Label("Juletræsgrossister"), 0, 0);
        pane.add(new Label("Juletræer"), 2,0);



        // ----- ADD LISTVIEW -----
        pane.add(listViewGrossister,0,1,2,1);
        pane.add(listViewJuletræ,2,1,3,1);

        listViewGrossister.getItems().addAll(controller.getJuletræsgrossist());
        listViewJuletræ.getItems().addAll(controller.getJuletræer());

        listViewGrossister.getSelectionModel().selectFirst();
        listViewJuletræ.getSelectionModel().selectFirst();

        // -----  ADD TEXTAREA -----
        pane.add(textAreaHøjdeSorteredeJuletræer, 0, 4,2,1);

        // ----- ADD TEXTFIELDS -----
        pane.add(textFieldDato, 3,2);
        pane.add(textFieldPris,4,2);

        // ----- ADD BUTTONS -----
        pane.add(buttonSorter,0,3);
        pane.add(buttonPrisPrDato,2,2);




        // ----- Når man trykker på noget i LiseView, så gøre den noget i hjælpemetoden -----
        listViewGrossister.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldEks, newEks) -> this.selectedEksempelChanged(newEks)
        );
    }

    // Hjælpemetode
    private void selectedEksempelChanged(JuletræsGrossist juletræ) {
        // Opdater tekstfelter her
    }
}

