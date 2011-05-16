
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
        ArrayList<Coup> tabCouleurAdverse = chercheCouleurAdverse();
        /*for(int i=0;i<tabCouleurAdverse.size();i++)
        {
            System.out.println("Ligne : " + tabCouleurAdverse.get(i).getLigne() + " Colonne : " + tabCouleurAdverse.get(i).getColonne());
        }*/


        ArrayList<Coup> tabCaseVide = chercheVideAutour(tabCouleurAdverse.get(1));
        for(int i=0;i<tabCaseVide.size();i++)
        {
            System.out.println("Ligne : " + tabCaseVide.get(i).getLigne() + " Colonne : " + tabCaseVide.get(i).getColonne());
        }
        
         return new Coup(4, 2);
        //throw new UnsupportedOperationException("Not supported yet.");
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
    
    //Fonction qui cherche les cases vides autour d'un pion passé en paramètre
    private ArrayList<Coup> chercheVideAutour (Coup coup)
    {
        ArrayList<Coup> tabCaseVide = new ArrayList<Coup>();
        Couleur[][] matricePlateau = this.plateau.getMatricePlateau();
        int lignePrecedente = coup.getLigne()-1;
        int ligneSuivante = coup.getLigne()+1;
        int colonnePrecedente = coup.getColonne()-1;
        int colonneSuivante = coup.getColonne()+1;

        for(int i=lignePrecedente; i<=ligneSuivante; i++)
        {
            for(int j=colonnePrecedente; j<=colonneSuivante; j++)
            {
                 if(matricePlateau[i][j] == Couleur.VIDE)
                {
                    tabCaseVide.add(new Coup(i, j));
                }
            }
        }
        return tabCaseVide;
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
