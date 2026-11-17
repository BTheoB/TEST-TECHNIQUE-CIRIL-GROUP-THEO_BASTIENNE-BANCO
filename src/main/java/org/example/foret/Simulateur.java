package org.example.foret;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Simulateur {

    private final Foret foret;
    private int etape;
    private float probabilite;
    private Set<Position> celluleQuiBrule =  new HashSet<Position>();

    public Simulateur(float probabilite, int etape, Foret foret, int nombreFeu) {
        this.probabilite = probabilite;
        this.etape = 1;
        this.foret = foret;
        initFeu(nombreFeu);
    }

    public int getEtape() {
        return etape;
    }

    public void initFeu(int nombreFeu) {

        Random rand = new Random();
        int h;
        int l;

        for (int i = 0; i < nombreFeu; i++) {
            h = rand.nextInt(foret.getHauteur());
            l = rand.nextInt(foret.getLargeur());
            Position p = new Position(h, l);
            foret.setCellule(p, Cellule.BRULE);
            celluleQuiBrule.add(p);
        }
    }

    public boolean estFini(){
        return celluleQuiBrule.isEmpty();
    }

    public void Etape (){

        Set<Position> prochainBruler = new HashSet<>();
        for(Position p : celluleQuiBrule){

            for(Position p2 : foret.getVoisins(p)){}


        }
    }
}
