package org.example.configuration;

import org.example.foret.Position;

import java.util.Set;

public record ConfigSimulateur(int hauteur, int largeur, double probabilite, Set<Position> positionInitialFeu) {

    public ConfigSimulateur {
        if (hauteur <= 0 || largeur <= 0) {
            throw new IllegalArgumentException("La hauter et la largeur doivent être > 0");
        }
        if (probabilite < 0 || probabilite > 1) {
            throw new IllegalArgumentException("La probabilité doit être entre 0 et 1");
        }
        if (positionInitialFeu == null || positionInitialFeu.isEmpty()) {
            throw new IllegalArgumentException("Au moins un feu initial est requis");
        }
        for (Position p : positionInitialFeu) {
            if (p.x() < 0 || p.x() >= hauteur || p.y() < 0 || p.y() >= largeur) {
                throw new IllegalArgumentException("Feu hors de la grille : " + p);
            }
        }

    }
}
