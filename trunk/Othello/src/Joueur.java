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
    private Plateau plateau;
    private TypeJoueur typeJoueur;
    
    public Joueur(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
    {
        this.couleur = couleur;
        this.plateau = plateau;
        this.typeJoueur = typeJoueur;
    }

    public Coup joue()
    {
        // return new Coup(3, 2);
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
