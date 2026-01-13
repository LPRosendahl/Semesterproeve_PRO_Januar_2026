package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    // Storage skal kunne gemme objekter, så vi laver en instans-variabel af Storage.
    private final Storage storage;
    // ----- Konstruktør -----
    public Controller(Storage storage) {
        this.storage = storage;
    }



    // Metoder til at oprette objekter. Hver metode skal oprette, tilføje til storage og returnere objektet.
    public Juletræ opretJuletræ(Sort sort, int højde, int antalPrPalle, JuletræsGrossist juletræsGrossist, PeriodePris periodePris) {
        Juletræ juletræ = new Juletræ(sort, højde, antalPrPalle, juletræsGrossist, periodePris);
        storage.addJuletræ(juletræ); // HER kaldes storage
        return juletræ;
    }

    public JuletræsGrossist opretJuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        JuletræsGrossist juletræsGrossist = new JuletræsGrossist(navn, cvr, fragtPrisPrPalle);
        storage.addJuletræsGrossist(juletræsGrossist);
        return juletræsGrossist;
    }

    public PeriodePris opretPeriodePris(LocalDate fraDato, LocalDate tilDato, double pris) {
        PeriodePris periodePris = new PeriodePris(fraDato, tilDato, pris);
        return periodePris;
    }

    public Salgslinje opretSalgslinje(int antal, double antaltRabatPrTræ, Juletræ juletræ, Salg salg) {
        Salgslinje salgslinje = new Salgslinje(antal, antaltRabatPrTræ, juletræ, salg);
        return salgslinje;
    }


    public Salg opretSalg(String kunde, LocalDate salgsDato) {
        Salg salg = new Salg(kunde, salgsDato);
        storage.addSalg(salg);
        return salg;
    }

    public ArrayList<JuletræsGrossist> getJuletræsgrossist() {
        return storage.getJuletræsGrossister();
    }

    public ArrayList<Juletræ> getJuletræer() {
        return storage.getJuletræer();
    }


    // Hvis der er en opgave hvor man skal skrive til en tekstfil
    public void gemJuletræsInfoTilFil(String filnavn) {
        try (PrintWriter writer = new PrintWriter(new File(filnavn))) {
            // for-loop her
            for (Juletræ juletræ : storage.getJuletræer()) {
                for (PeriodePris periodePris : juletræ.getPeriodePriser()) {
                    writer.printf("%s, %s, %s, %s, %s, %s",
                            juletræ.getJuletræsGrossist().getNavn(), juletræ.getSort(), juletræ.getHøjde(),
                            periodePris.getFraDato(), periodePris.getTilDato(), periodePris.getPris());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fil ikke fundet: " + e.getMessage());
        }
    }


}
