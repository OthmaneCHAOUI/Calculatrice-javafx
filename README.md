# Calculatrice JavaFX

Ce projet est une simple **application de calculatrice** réalisée avec **JavaFX**, proposant une interface graphique élégante stylisée par un fichier **CSS**.

## Contenu du projet

- `Main.java` : Code principal de l'application JavaFX (création de l'interface, gestion des événements, calculs...).
- `style.css` : Feuille de style appliquée à l'interface pour une meilleure apparence.

## Fonctionnalités

- **Opérations basiques** : Addition, Soustraction, Multiplication, Division.
- **Interface responsive** utilisant `GridPane`.
- **Affichage dynamique** des entrées et du résultat.
- **Bouton "C"** pour réinitialiser la calculatrice.
- **Style CSS** différenciant boutons de chiffres, opérateurs et bouton égal `=`.
  
## Technologies utilisées

- Java 17+ (ou version compatible avec JavaFX)
- JavaFX SDK
- CSS pour le style graphique

## Prérequis

- Java Development Kit (JDK) installé.
- JavaFX configuré dans votre environnement de développement.
  
**Lien utile pour configurer JavaFX :**
- [Documentation JavaFX](https://openjfx.io/)

## Lancer le projet

1. Assurez-vous d'avoir le JDK et JavaFX installés.
2. Compilez le projet :
   ```bash
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml main/Main.java
   ```
3. Exécutez le projet :
   ```bash
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml main.Main
   ```
   Remplacez `/path/to/javafx-sdk/lib` par le chemin vers votre dossier JavaFX.# Calculatrice-java-javafx