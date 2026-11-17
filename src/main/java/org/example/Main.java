package org.example;


import org.example.affichage.Afficheur;
import org.example.affichage.AfficheurConsole;
import org.example.configuration.ConfigLoader;
import org.example.configuration.ConfigSimulateur;
import org.example.foret.Foret;
import org.example.foret.Simulateur;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Path configPath = Path.of("configuration.json");
        ConfigSimulateur configSimulateur = ConfigLoader.load(configPath);

        Foret foret = new Foret(configSimulateur.hauteur(), configSimulateur.largeur());
        Simulateur simulateur = new Simulateur(foret, configSimulateur.positionInitialFeu(), configSimulateur.probabilite());
        Afficheur afficheur = new AfficheurConsole();

        System.out.println("===== Début de la simulation de feu de foret =====");
        afficheur.afficher(foret, simulateur.getEtape());
        while (!simulateur.estFini()) {
            simulateur.etape();
            afficheur.afficher(foret, simulateur.getEtape());
        }

        System.out.println("===== Fin de la simulation de feu de foret =====");
    }
}