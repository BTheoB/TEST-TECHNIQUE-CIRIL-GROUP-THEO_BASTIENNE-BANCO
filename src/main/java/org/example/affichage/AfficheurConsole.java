package org.example.affichage;

import org.example.foret.Cellule;
import org.example.foret.Foret;
import org.example.foret.Position;

public class AfficheurConsole implements Afficheur {


    @Override
    public void afficher(Foret foret, int etape) {

        StringBuilder affichage = new StringBuilder("======Etape " +  etape + "======\n");
        for(int h = 0; h < foret.getHauteur(); h++ ) {
            for(int l = 0; l < foret.getLargeur(); l++){
                affichage.append(correspondance(foret.getCelluleEtat(new Position(h,l))));
            }
            affichage.append("\n");
        }
        System.out.println(affichage);
    }


    // Correspondances des symboles à afficher
    private char correspondance(Cellule cellule) {

        return switch (cellule) {
            case ARBRE -> 'T';
            case BRULE -> '$';
            case CENDRE -> '_';

        };
    }
}
