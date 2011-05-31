/*
 * Main.java
 * Author : Miras Andre & Tomio Nicolas
 */

/**
 * 
 * Cette classe permet de mettre par défault le type Automate pour toutes les IA
 */
abstract public class AbstractJoueurIA extends AbstractJoueur {

    public AbstractJoueurIA(Couleur couleur, Plateau plateau)
    {
        // une IA est forcement un automate
        super(couleur, plateau, TypeJoueur.AUTOMATE);
    }

}
