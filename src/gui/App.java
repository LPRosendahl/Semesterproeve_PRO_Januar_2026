package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import storage.Storage;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Controller controller = new Controller(storage);

        initStorage(controller);

        Gui.setController(controller);
        Application.launch(Gui.class);
    }

    private static void initStorage(Controller controller) {
        // ----- Opret initiel data gennem controllerens metoder -----

        // ----- GROSSISTER -----
        JuletræsGrossist hammel = controller.opretJuletræsGrossist("Hammel Juletræe", "2316", 150);
        JuletræsGrossist sommersminde = controller.opretJuletræsGrossist("Sommersminde Juletræsplantage", "34343", 140);


        // ----- JULETRÆER -----
        // Periodepris
        PeriodePris periodePris1 = controller.opretPeriodePris(LocalDate.of(2025,11,1), LocalDate.of(2025,11,30), 50);
        PeriodePris periodePris2 = controller.opretPeriodePris(LocalDate.of(2025,12,1), LocalDate.of(2025,12,24), 200);


        // Hammel juletræer
        Juletræ nordmannsgranHammelFørstePeriode = controller.opretJuletræ(Sort.NORDMANNSGRAN, 200, 100, hammel, periodePris1);
        Juletræ nordmannsgranHammelAndenPeriode = controller.opretJuletræ(Sort.NORDMANNSGRAN, 200, 100, hammel, periodePris2);
        Juletræ rødgranHammelFørstePeriode = controller.opretJuletræ(Sort.RØDGRAN, 170, 140, hammel, periodePris1);
        Juletræ rødgranHammelAndenPeriode = controller.opretJuletræ(Sort.RØDGRAN, 170, 140, hammel, periodePris2);

        // Sommersminde juletræer
        Juletræ nobilisSommersmindeFørstePeriode = controller.opretJuletræ(Sort.NOBILIS, 170, 140, sommersminde, periodePris1);
        Juletræ nobilisSommersmindeAndenPeriode = controller.opretJuletræ(Sort.NOBILIS, 170, 140, sommersminde, periodePris2);
        Juletræ nordmannsgranSommersmindeFørstePeriode = controller.opretJuletræ(Sort.NORDMANNSGRAN, 160, 144, sommersminde, periodePris1);
        Juletræ nordmannsgranSommersmindeAndenPeriode = controller.opretJuletræ(Sort.NORDMANNSGRAN, 160, 144, sommersminde, periodePris2);


        // ----- SALG -----
        Salg fdfViby = controller.opretSalg("FDF Viby", LocalDate.of(2025,11,2));
        Salgslinje nordmannsgran = controller.opretSalgslinje(333, 5, nordmannsgranHammelFørstePeriode, fdfViby);
        Salgslinje rødgran = controller.opretSalgslinje(250, 3, rødgranHammelFørstePeriode, fdfViby);


    }


}


