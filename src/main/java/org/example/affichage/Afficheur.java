package org.example.affichage;

import org.example.foret.Foret;
//Cette interface permet de gerer plusieurs type d'afficheur
public interface Afficheur {
    void afficher(Foret foret, int etape);
}
