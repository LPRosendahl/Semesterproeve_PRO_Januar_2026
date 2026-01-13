package model;

import java.time.LocalDate;

public class PeriodePris {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private double pris;

    public PeriodePris(LocalDate fraDato, LocalDate tilDato, double pris) {
        this.fraDato = fraDato;
        this.tilDato = tilDato;
        this.pris = pris;
    }

    // ----- GETTERS -----
    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public double getPris() {
        return pris;
    }
}
