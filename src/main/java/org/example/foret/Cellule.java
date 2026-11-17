package org.example.foret;

public enum Cellule {
    ARBRE, BRULE, CENDRE;

    public boolean isFlammable() {
        return this == ARBRE;
    }
}
