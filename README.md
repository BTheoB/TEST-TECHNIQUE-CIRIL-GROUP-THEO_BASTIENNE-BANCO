# TEST-TECHNIQUE-CIRIL-GROUP-THEO_BASTIENNE-BANCO

# Simulation de propagation d'un feu de forêt

Simulation étape par étape de la propagation d'un feu dans une forêt représentée par une grille `hauteur x largeur`
, réalisée en Java dans le cadre d'un test technique pour l'entreprise Ciril Group.

## Règles de la simulation

- La forêt est une grille de cases. Chaque case est un **arbre**, un **feu** ou de la **cendre**.
- Au départ, une ou plusieurs cases sont en feu.
- Si une case est en feu à l'étape `t`, alors à l'étape `t+1` :
    - le feu s'éteint dans cette case, cela devient de la cendre et ne peut plus brûler ;
    - Les 4 cases collées à celle qui Brule (haut, bas, gauche, droite) s'enflamme ou non avec une probabilité `p`, à
      condition que ce soit un arbre.
- La simulation s'arrête quand plus aucune case n'est en feu.

## Prérequis

- Java 21
- Maven 3.9+

## Lancer le projet

```bash
# Compiler
mvn clean package
 
# Lancer la simulation
java -jar target/simulateurDeFeu.jar

```

## Configuration

Les paramètres sont lus dans un fichier JSON :

```json
{
  "hauteur": 10,
  "largeur": 10,
  "probabilite": 0.6,
  "positionInitialFeu": [
    {
      "x": 0,
      "y": 0
    },
    {
      "x": 2,
      "y": 4
    }
  ]
}
```

| Paramètre            | Description                                              |
|----------------------|----------------------------------------------------------|
| `hauteur`, `largeur` | Dimensions de la grille                                  |
| `probabilite`        | Probabilité de propagation à chaque voisin, entre 0 et 1 |
| `positionInitialFeu` | Liste des positions initiale de feu                      |

La configuration est testé et validé au chargement de celle-ci.

## Affichage console

```
=== Étape 3 ===
TTTTTTTTTT
TTT_$_TTTT
TT_$$$_TTT
TTT_$_TTTT
```

| Symbole | Signification |
|---------|---------------|
| `T`     | Arbre         |
| ` $`    | Case en feu   |
| `_`     | Cendre        |

## Architecture

```
src/main/java/com/example/foret
├── Main.java                  Point d'entrée : charge la config, lance la boucle
├── domain
│   ├── Cellule                Enum des états : ARBRE, FEU, CENDRE
│   ├── Position               Record (ligne, colonne)
│   ├── Foret                  Grille, accès aux états, calcul des voisins
│   └── Simulation             Règles de propagation, avancement étape par étape
├── configuration
│   ├── ConfigSimulateur       Record des paramètres + validation
│   └── ConfigLoader           Lecture du fichier JSON
└── affichage
    ├── Afficheur              Interface d'affichage
    └── AfficheurConsole       Implementation d'affichage caractère ASCII dans la console
```
- **foret** : la logique et modèle métier. Partie testée en priorité.
- **configuration** : lecture et validation de la configuration.
- **affichage** : tout ce qui concerne l'affichage, derrière une interface permettant de changer de type d'affichage
  dans un futur possible.

## Pistes d'amélioration

- Interface graphique (Swing ou JavaFX).
- Plus de tests pour couvrir des cas particuliers.
 
