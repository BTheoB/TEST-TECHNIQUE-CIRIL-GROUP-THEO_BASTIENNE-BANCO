package org.example.foret;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ForetTest {

    private Foret foret;

    @BeforeEach
    void setUp() {
        foret = new Foret(3, 3);
    }

    @org.junit.jupiter.api.Test
    void positionDansGrille() {
        assertTrue(foret.estDedans(new Position(1,1)));
    }

    @org.junit.jupiter.api.Test
    void positionHorsGrille() {
        assertThrows(IllegalArgumentException.class,
                () -> foret.getCelluleEtat(new Position(5, 5)));
    }


    @org.junit.jupiter.api.Test
    void getCellule() {

    }

    @org.junit.jupiter.api.Test
    void setCellule() {
    }
    //Voisin de la case 0,0 sont :
    // 0,1 et 1,0
    @org.junit.jupiter.api.Test
    void getVoisins() {
        ArrayList<Position> voisins = new ArrayList<>();
        voisins.add(new Position(0,1));
        voisins.add(new Position(1,0));

        assertEquals(voisins, foret.getVoisins(new Position(0,0)));
    }
}