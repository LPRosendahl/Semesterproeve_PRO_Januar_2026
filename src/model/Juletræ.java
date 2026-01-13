package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Juletræ {
    private Sort sort;
    private int højde;
    private int antalPrPalle;
    private JuletræsGrossist juletræsGrossist;
    private ArrayList<PeriodePris> periodePriser = new ArrayList<>();
    private ArrayList<Salgslinje> salgslinjer = new ArrayList<>();

    public Juletræ(Sort sort, int højde, int antalPrPalle, JuletræsGrossist juletræsGrossist, PeriodePris periodePris) {
        this.sort = sort;
        this.højde = højde;
        this.antalPrPalle = antalPrPalle;
        this.juletræsGrossist = juletræsGrossist;
        this.addPeriodePris(periodePris);
    }

    // ----- GETTERS -----

    public Sort getSort() {
        return sort;
    }

    public int getHøjde() {
        return højde;
    }

    public int getAntalPrPalle() {
        return antalPrPalle;
    }

    public JuletræsGrossist getJuletræsGrossist() {
        return juletræsGrossist;
    }

    public ArrayList<PeriodePris> getPeriodePriser() {
        return new ArrayList<>(periodePriser);
    }

    public ArrayList<Salgslinje> getSalgslinjer() {
        return new ArrayList<>(salgslinjer);
    }

    // ----- SAMMENHÆNGSMETODER ------
    // JuletræsGrossist
    public void setJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        if (this.juletræsGrossist != juletræsGrossist) {
            JuletræsGrossist gammelJuletræsGrossist = this.juletræsGrossist;
            if (gammelJuletræsGrossist != null) {
                gammelJuletræsGrossist.removeJuletræ(this);
            }
            this.juletræsGrossist = juletræsGrossist;
            if (juletræsGrossist != null) {
                juletræsGrossist.addJuletræ(this);
            }
        }
    }

    // PeriodePris
    public PeriodePris createPeriodePris(LocalDate fraDato, LocalDate tilDato, double pris) {
        PeriodePris periodePris = new PeriodePris(fraDato, tilDato, pris);
        periodePriser.add(periodePris);
        return periodePris;
    }

    public void addPeriodePris(PeriodePris periodePris) {
        if (!periodePriser.contains(periodePris)) {
            periodePriser.add(periodePris);
        }
    }


    public void removePeriodePris(PeriodePris periodePris) {
        if (periodePriser.contains(periodePris)) {
            periodePriser.remove(periodePris);
        }
    }

    public double prisPåDato(ArrayList<PeriodePris> periodePrises, LocalDate salgsDato) {
        double pris = 0;
        int index = -1;
        int i = 0;
        try {
            while (index == -1 && i < periodePrises.size()) {
                PeriodePris dato = periodePrises.get(i);
                if (!dato.getFraDato().isAfter(salgsDato) && !dato.getTilDato().isBefore(salgsDato)) {
                    index = i;
                    pris = dato.getPris();
                } else {
                    i++;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return pris;
    }

    @Override
    public String toString() {
        return sort +
                " " + højde +
                " cm. Maks. " + antalPrPalle +
                " på en palle";
    }
}
