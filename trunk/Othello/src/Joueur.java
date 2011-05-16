
import java.util.ArrayList;

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
    
    
    //Fonction qui retourne la position des pions de couleurs adverses
    private ArrayList<Coup> chercheCouleurAdverse()
    {
        ArrayList<Coup> tabCouleurAdverse = new ArrayList<Coup>();
        Couleur[][] matricePlateau = this.plateau.getMatricePlateau();
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if (matricePlateau[i][j]!=this.couleur && matricePlateau[i][j]!=Couleur.VIDE)
                {
                    tabCouleurAdverse.add(new Coup(i, j));
                }
            }
        }
        return tabCouleurAdverse;
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
