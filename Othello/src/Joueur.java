/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ntomio
 */
class Joueur implements InterfaceJoueur
{

    private Couleur couleur;
    private TypeJoueur typeJoueur;
    
    public Joueur(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
    {
        this.couleur = couleur;
    }

    public Coup joue()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TypeJoueur getType()
    {
        return typeJoueur;
    }

    public Couleur getCouleur()
    {
        return couleur;
    }
    
}
