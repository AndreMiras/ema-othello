/*
 * Main.java
 * Author : Miras Andre & Tomio Nicolas
 */


public class HumanPlayer extends AbstractJoueur {

    public HumanPlayer(Couleur couleur, Plateau plateau)
    {
        super(couleur, plateau, TypeJoueur.HUMAIN);
    }

    @Override
    public Coup joue()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
