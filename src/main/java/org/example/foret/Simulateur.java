package org.example.foret;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;

public class Simulateur {

    private final Foret foret;
    private int etape;
    private final double probabilite;
    private Set<Position> celluleQuiBrule = new HashSet<>();
    private final RandomGenerator random;

    public Simulateur(Foret foret, Set<Position> positionInitialFeu, double probabilite) {
        this.probabilite = probabilite;
        this.etape = 1;
        this.foret = foret;
        initFeu(positionInitialFeu);
        random = new Random();
    }

    public int getEtape() {
        return etape;
    }

    public void initFeu(Set<Position> positions) {
        for (Position p : positions) {
            foret.setCellule(p, Cellule.BRULE);
            celluleQuiBrule.add(p);
        }
    }

    public boolean estFini() {
        return celluleQuiBrule.isEmpty();
    }

    /**
     * Fait avancer la simulation d'une étape (t -> t+1).
     */
    public void etape() {
        Set<Position> celluleQuiVaBrule = new HashSet<>();

        for (Position p : celluleQuiBrule) {
            foret.setCellule(p, Cellule.CENDRE);

            for (Position p2 : foret.getVoisins(p)) {

                if (foret.getCelluleEtat(p2).peutBruler() && !celluleQuiBrule.contains(p2) && random.nextDouble() < probabilite) {
                    foret.setCellule(p2, Cellule.BRULE);
                    celluleQuiVaBrule.add(p2);
                }
            }
        }
        celluleQuiBrule = celluleQuiVaBrule;
        etape++;
    }
}
