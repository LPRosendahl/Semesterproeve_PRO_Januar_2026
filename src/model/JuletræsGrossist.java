package model;

import java.util.ArrayList;

public class JuletræsGrossist {
    private String navn;
    private String cvr;
    private double fragtPrisPrPalle;
    private ArrayList<Juletræ> juletræer = new ArrayList<>();

    public JuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        this.navn = navn;
        this.cvr = cvr;
        this.fragtPrisPrPalle = fragtPrisPrPalle;
    }

    // ----- GETTERS -----
    public String getNavn() {
        return navn;
    }

    public String getCvr() {
        return cvr;
    }

    public double getFragtPrisPrPalle() {
        return fragtPrisPrPalle;
    }

    public ArrayList<Juletræ> getJuletræer() {
        return new ArrayList<>(juletræer);
    }

    // ----- SAMMENHÆNGSMETODER -----
    public void addJuletræ(Juletræ juletræ) {
        if (!juletræer.contains(juletræ)) {
            juletræer.add(juletræ);
            juletræ.setJuletræsGrossist(this);
        }
    }

    public void removeJuletræ(Juletræ juletræ) {
        if (juletræer.contains(juletræ)) {
            juletræer.remove(juletræ);
            juletræ.setJuletræsGrossist(null);
        }

    }

    @Override
    public String toString() {
        return navn;
    }
}
