package storage;

import model.Juletræ;
import model.JuletræsGrossist;
import model.Salg;

import java.util.ArrayList;

public class Storage {
    // ----- Opret lister -----
    private ArrayList<JuletræsGrossist> juletræsGrossister = new ArrayList<>();
    private ArrayList<Juletræ> juletræer = new ArrayList<>();
    private ArrayList<Salg> salgs = new ArrayList<>();


    // ----- Metoder til at hente lister -----
    public ArrayList<JuletræsGrossist> getJuletræsGrossister() {
        return new ArrayList<>(juletræsGrossister);
    }

    public ArrayList<Juletræ> getJuletræer() {
        return new ArrayList<>(juletræer);
    }

    public ArrayList<Salg> getSalgs() {
        return new ArrayList<>(salgs);
    }


    // ----- Metoder til at gemme objekter fra klasser -----
    public void addJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        juletræsGrossister.add(juletræsGrossist);
    }

    public void addJuletræ(Juletræ juletræ) {
        juletræer.add(juletræ);
    }

    public void addSalg(Salg salg) {
        salgs.add(salg);
    }


    // ----- METODER TIL AT SLETTE OBJEKTER -----
    public void removeJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        if (juletræsGrossister.contains(juletræsGrossist)) {
            juletræsGrossister.remove(juletræsGrossist);
        }
    }

    public void removeJuletræ(Juletræ juletræ) {
        if (juletræer.contains(juletræ)) {
            juletræer.remove(juletræ);
        }
    }

    public void removeSalg(Salg salg) {
        if (salgs.contains(salg)) {
            salgs.remove(salg);
        }
    }
}
