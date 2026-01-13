package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private String kunde;
    private LocalDate salgsDato;
    private ArrayList<Salgslinje> salgslinjer = new ArrayList<>();

    public Salg(String kunde, LocalDate salgsDato) {
        this.kunde = kunde;
        this.salgsDato = salgsDato;
    }

    // ----- GETTERS -----
    public String getKunde() {
        return kunde;
    }

    public LocalDate getSalgsDato() {
        return salgsDato;
    }

    public ArrayList<Salgslinje> getSalgslinjer() {
        return new ArrayList<>(salgslinjer);
    }

    // ----- SAMMENHÆNGS METODER -----
    public Salgslinje createSalgslinje(int antal, double antaltRabatPrTræ, Juletræ juletræ, Salg salg) {
        Salgslinje salgslinje = new Salgslinje(antal, antaltRabatPrTræ, juletræ, salg);
        salgslinjer.add(salgslinje);
        return salgslinje;
    }

    public void addSalgslinje(Salgslinje salgslinje) {
        if (!salgslinjer.contains(salgslinje)) {
            salgslinjer.add(salgslinje);
        }
    }

    public void removeSalgslinje(Salgslinje salgslinje) {
        if (salgslinjer.contains(salgslinje)) {
            salgslinjer.remove(salgslinje);
        }
    }

    public double prisExclusivFragt() {
        double prisExclusivFragt = 0;
        for (Salgslinje salgslinje : salgslinjer) {
            prisExclusivFragt += salgslinje.getSalgslinjePris();
        }
        return prisExclusivFragt;
    }

    public double prisInclusivFragt() {
        double fragtPris = 0;
        int antalPrPalle = 0;
        int antalKøbteJuletræer = 0;

        for (Salgslinje salgslinje : salgslinjer) {
            antalPrPalle = salgslinje.getJuletræ().getAntalPrPalle();
            antalKøbteJuletræer = salgslinje.getAntal();
            fragtPris = salgslinje.getJuletræ().getJuletræsGrossist().getFragtPrisPrPalle();
        }

        return antalKøbteJuletræer / antalPrPalle * fragtPris + prisExclusivFragt();
    }
}
