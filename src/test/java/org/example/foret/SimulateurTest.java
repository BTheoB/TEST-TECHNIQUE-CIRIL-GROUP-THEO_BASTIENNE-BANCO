package org.example.foret;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SimulateurTest {

    // ---------- Etat initial ----------

    @Test
    void etatInitial_lesFoyersSontEnFeuEtLaSimulationNEstPasTerminee() {
        Foret foret = new Foret(3, 3);
        Simulateur sim = new Simulateur(foret, Set.of(new Position(1, 1)), 0.5);

        assertEquals(Cellule.BRULE, foret.getCelluleEtat(new Position(1, 1)));
        assertEquals(Cellule.ARBRE, foret.getCelluleEtat(new Position(0, 0)));
        assertFalse(sim.estFini());
    }

    @Test
    void estFini() {
    }

    @Test
    void etape() {
    }

    @Test
    void cendre_neSeRallumePas() {
        // 1x3 : le feu part du milieu, les deux extrémités brûlent à l'étape 1,
        // puis le milieu (cendre) ne doit pas se rallumer à l'étape 2
        Foret foret = new Foret(1, 3);
        Simulateur simulateur = new Simulateur(foret, Set.of(new Position(0, 1)), 1.0);

        simulateur.etape();
        simulateur.etape();

        assertEquals(Cellule.CENDRE, foret.getCelluleEtat(new Position(0, 1)));
        assertTrue(simulateur.estFini());
    }
}