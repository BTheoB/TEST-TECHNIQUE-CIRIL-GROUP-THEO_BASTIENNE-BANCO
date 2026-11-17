package org.example.foret;

import java.util.ArrayList;
import java.util.List;

public class Foret {

    private final Cellule[][] grilleArbre;
    private final int hauteur;
    private final int largeur;

    public Foret(int hauteur, int largeur) {
        if (hauteur <= 0 || largeur <= 0) {
            throw new IllegalArgumentException("Les dimensions doivent être strictement positives");
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grilleArbre = new Cellule[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grilleArbre[i][j] = Cellule.ARBRE;
            }
        }
    }

    public Cellule[][] getGrilleArbre() {
        return grilleArbre;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public boolean estDedans(Position p) {
        return p.x() >= 0 && p.x() <= hauteur && p.y() >= 0 && p.y() <= largeur;
    }

    public Cellule getCelluleEtat(Position p) {
        if (estDedans(p)) {
            return grilleArbre[p.x()][p.y()];
        }
        throw new IllegalArgumentException("Les dimensions doivent être strictement positives");
    }


    public void setCellule(Position p, Cellule cellule) {
        if (estDedans(p)) {
            grilleArbre[p.x()][p.y()] = cellule;
        }
        throw new IllegalArgumentException("Les dimensions doivent être strictement positives");
    }

    public List<Position> getVoisins(Position p) {

        List<Position> positions = new ArrayList<>(4);
        Position tampon =  new Position(p.x() - 1, p.y());
        //Voisin du dessus
        if (estDedans(tampon)) {
            positions.add(tampon);
        }

        tampon =  new Position(p.x(), p.y() + 1);
        //Voisin de droite
        if (estDedans(tampon)) {
            positions.add(tampon);
        }

        tampon =  new Position(p.x() + 1, p.y());
        //Voisin du bas
        if (estDedans(tampon)) {
            positions.add(tampon);
        }

        tampon =  new Position(p.x(), p.y() - 1);
        //Voisin de gauche
        if (estDedans(tampon)) {
            positions.add(tampon);
        }
        return positions;
    }
}
