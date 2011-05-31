/*
 * Main.java
 * Author : Miras Andre & Tomio Nicolas
 */

/**
 * 
 * Cette classe permet de mettre en commun le code de toutes les IA
 */
abstract public class JoueurIA extends AbstractJoueur {

    public JoueurIA(Couleur couleur, Plateau plateau)
    {
        // une IA est forcement un automate
        super(couleur, plateau, TypeJoueur.AUTOMATE);
    }

}
