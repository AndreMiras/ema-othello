
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
        System.out.println("Coup possible : ");
        ArrayList<Coup> coupPossible = chercheCoupPossible();
        
        for (int i=0;i<coupPossible.size();i++)
        {
            System.out.println("Ligne : " + coupPossible.get(i).getLigne() + " Colonne : " + coupPossible.get(i).getColonne());
        }

        Random r = new Random();

      
        int valeur;
        try
        {
            valeur = r.nextInt(coupPossible.size());
        }
        catch(java.lang.IllegalArgumentException e)
        {
            int foo = coupPossible.size();
            System.out.println("fou: "+ foo);
            coupPossible = chercheCoupPossible();
            valeur = 0;
        }
       
        Coup coup = coupPossible.get(valeur);
        return coup;
        //return new Coup(4, 2);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
   
    
    //Fonction qui retourne la position des pions de couleurs adverses
    private ArrayList<Coup> chercheCouleurAdverse()
    {
        //Tableau dans lequel on va stockée les pions de l'adversaire
        ArrayList<Coup> tabCouleurAdverse = new ArrayList<Coup>();
        //On parcourt le tableau
        for(int i=0; i<plateau.getDimension(); i++)
        {
            for(int j=0; j<plateau.getDimension(); j++)
            {
                //Si la couleur correspond au joueur adverse
                if (plateau.plateau[i][j]!=this.couleur && plateau.plateau[i][j]!=Couleur.VIDE)
                {
                    //On l'ajoute au tableau
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
                if(i<0){break;}
                if(i>=plateau.getDimension()){break;}
            for(int j=colonnePrecedente; j<=colonneSuivante; j++)
            {
                if(j<0){break;}
                if(j>=plateau.getDimension()){break;}
                if(matricePlateau[i][j] == Couleur.VIDE)
                {
                    tabCaseVide.add(new Coup(i, j));
                }
            }
        }

        return tabCaseVide;
    }
    
    private ArrayList<Coup> chercheCoupPossible ()
    {
        //Tableau dans lequel seront stockés les coups possibles
        ArrayList<Coup> coupPossible = new ArrayList<Coup>();
        int x = 0; //Variable qui determine la direction horizontale
        int y = 0; //Variable qui determine la direction verticale
        //Variables pour analyser les cases
        int pointX;
        int pointY;
        //On récupère les pions de l'adversaire
        ArrayList<Coup> tabCouleurAdverse = chercheCouleurAdverse();
        
        //Condition pour sortir de boucle
        boolean flag = true;

        //On fait un traitement pour chaque pion du tableau
        for(int i=0;i<tabCouleurAdverse.size();i++)
        {
            ArrayList<Coup> tabCaseVide = chercheVideAutour(tabCouleurAdverse.get(i));
            for (int j=0; j<tabCaseVide.size();j++)
            {
                //On cherche la direction en x et y                 
                x=-(tabCaseVide.get(j).getColonne()-tabCouleurAdverse.get(i).getColonne());
                y=-(tabCaseVide.get(j).getLigne()-tabCouleurAdverse.get(i).getLigne());

                //On fixe la case à traiter
                pointX = tabCouleurAdverse.get(i).getColonne()+x;
                pointY = tabCouleurAdverse.get(i).getLigne()+y;
                //On boucle tant qu'on est dans le tableau
                flag = true;
                while(pointX>0 && pointX<plateau.getDimension() && pointY>0 && pointY<plateau.getDimension() && flag==true)
                {
                    //On cherche une case de la couleur du joueur, si on en trouve
                    //une, c'est un coup possible
                    if(plateau.plateau[pointX][pointY] == this.couleur)
                    {
                        coupPossible.add(new Coup(tabCaseVide.get(j).getLigne(), tabCaseVide.get(j).getColonne()));
                        flag=false;
                    }
                    //Si on tombe sur une case vide, on sort de la boucle
                    if(plateau.plateau[pointX][pointY] == Couleur.VIDE)
                    {
                        flag=false;
                    }
                    //On déplace la case à traiter
                    pointX=pointX+x;
                    pointY=pointY+y;
                }
            }
        }  
             
        return coupPossible;
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
