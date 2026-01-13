package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgslinje {
    private int antal;
    private double antaltRabatPrTræ;
    private Juletræ juletræ;
    private Salg salg;

    public Salgslinje(int antal, double antaltRabatPrTræ, Juletræ juletræ, Salg salg) {
        this.antal = antal;
        this.antaltRabatPrTræ = antaltRabatPrTræ;
        this.juletræ = juletræ;
        salg.addSalgslinje(this);
    }

    // ----- GETTERS -----
    public int getAntal() {
        return antal;
    }

    public double getAntaltRabatPrTræ() {
        return antaltRabatPrTræ;
    }

    public Juletræ getJuletræ() {
        return juletræ;
    }

    public Salg getSalg() {
        return salg;
    }

    // ----- SAMMENHÆNGS METODER -----
    public void setJuletræ(Juletræ juletræ) {
        if (this.juletræ != juletræ) {
            this.juletræ = juletræ;
        }
    }

    // ----- HJÆLPE METODER -----
//    public double getSalgslinjePris(ArrayList<PeriodePris> periodePris) {
//        double samletPris = antal * juletræ.prisPåDato(periodePris, ) - (antal * antaltRabatPrTræ);
//
//        // samletPris = antal * pris - (antal * antalRabatPåTræ);
//
//
//        return samletPris;
//    }


}
