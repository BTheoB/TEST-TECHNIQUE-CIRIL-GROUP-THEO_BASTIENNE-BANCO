package org.example.foret;

public enum Cellule {
    ARBRE, BRULE, CENDRE;

    public boolean peutBruler() {
        return this == ARBRE;
    }
}
