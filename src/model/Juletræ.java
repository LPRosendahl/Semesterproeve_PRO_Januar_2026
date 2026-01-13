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

    public double prisPåDato(LocalDate salgsDato) {
        double pris = -1;
        int i = 0;
        while (pris == -1 && i < periodePriser.size()) {
            PeriodePris p = periodePriser.get(i);
            if (!salgsDato.isBefore(p.getFraDato()) && !salgsDato.isAfter(p.getTilDato())) {
                pris = p.getPris();
            } else {
                i++;
            }
        }

        if (pris == -1) {
            throw new RuntimeException("Der findes ingen pris for juletræet på datoen: " + salgsDato);
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
