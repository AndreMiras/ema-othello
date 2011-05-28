
import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

abstract class AbstractJoueur implements InterfaceJoueur
{

    private Couleur couleur;
    protected Plateau plateau;
    private TypeJoueur typeJoueur;
    
    public AbstractJoueur(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
    {
        this.couleur = couleur;
        this.plateau = plateau;
        this.typeJoueur = typeJoueur;
    }

    
    abstract public Coup joue();
   
    
    /*
     * Fonction qui retourne la position des pions de couleurs adverses
     */
    private ArrayList<Coup> chercheCouleurAdverse(Couleur[][] matricePlateau, Couleur couleur)
    {
        //Tableau dans lequel on va stockée les pions de l'adversaire
        ArrayList<Coup> tabCouleurAdverse = new ArrayList<Coup>();
        //On parcourt le tableau
        for(int i=0; i<plateau.getDimension(); i++)
        {
            for(int j=0; j<plateau.getDimension(); j++)
            {
                //Si la couleur correspond au joueur adverse
                if (matricePlateau[i][j]!=couleur && matricePlateau[i][j]!= Couleur.VIDE)
                {
                    //On l'ajoute au tableau
                    tabCouleurAdverse.add(new Coup(i, j));
                }
            }
        }
        return tabCouleurAdverse;
    }
    
    //Fonction qui cherche les cases vides autour d'un pion passé en paramètre
    private ArrayList<Coup> chercheVideAutour(Coup coup)
    {
        ArrayList<Coup> tabCaseVide = new ArrayList<Coup>();
        Couleur[][] matricePlateau = this.plateau.getMatricePlateau();
        int lignePrecedente = coup.getLigne()-1;
        int ligneSuivante = coup.getLigne()+1;
        int colonnePrecedente = coup.getColonne()-1;
        int colonneSuivante = coup.getColonne()+1;

        int ligne;
        int colonne;
        boolean lignePossible = true;
        boolean colonnePossible = true;
        
        
        ligne = lignePrecedente;
        while (ligne<=ligneSuivante && lignePossible)
        {
            if(ligne<0)
            {
                lignePossible=false;
            }
            else if(ligne >=plateau.getDimension())
            {
                lignePossible=false;
            }
            else
            {
               colonnePossible=true;
               colonne = colonnePrecedente;
               while (colonne<=colonneSuivante && colonnePossible)
               {
                   
                   if(colonne<0)
                   {
                       colonnePossible=false;
                   }
                   else if(colonne >= plateau.getDimension())
                   {
                       colonnePossible=false;
                   }
                   else
                   {
                        if(matricePlateau[ligne][colonne] == Couleur.VIDE)
                        {
                            tabCaseVide.add(new Coup(ligne, colonne));
                        }
                   }
                   colonne++;
               }
            }
            ligne++;
        } 

        return tabCaseVide;
    }

    /*
     * Pour un plateau donne et une couleur, retourne les coups possibles
     */
    protected ArrayList<Coup> chercheCoupPossible(Couleur[][] matricePlateau, Couleur couleur)
    {
        //Tableau dans lequel seront stockés les coups possibles
        ArrayList<Coup> coupPossible = new ArrayList<Coup>();
        int x = 0; //Variable qui determine la direction horizontale
        int y = 0; //Variable qui determine la direction verticale
        //Variables pour analyser les cases
        int pointLigne;
        int pointColonne;
        //On récupère les pions de l'adversaire
        ArrayList<Coup> tabCouleurAdverse =
                chercheCouleurAdverse(matricePlateau, couleur);
        
        //Condition pour sortir de boucle
        boolean flag = true;

        //On fait un traitement pour chaque pion adverse du tableau
        for(int i=0;i<tabCouleurAdverse.size();i++)
        {
            ArrayList<Coup> tabCaseVide = chercheVideAutour(tabCouleurAdverse.get(i));
            for (int j=0; j<tabCaseVide.size();j++)
            {
                // On cherche la direction en x et y
                x=-(tabCaseVide.get(j).getColonne()-tabCouleurAdverse.get(i).getColonne());
                y=-(tabCaseVide.get(j).getLigne()-tabCouleurAdverse.get(i).getLigne());

                //On fixe la case à traiter
                pointColonne = tabCouleurAdverse.get(i).getColonne()+x;
                pointLigne = tabCouleurAdverse.get(i).getLigne()+y;
                //On boucle tant qu'on est dans le tableau
                flag = true;
                while(pointColonne>0 && pointColonne<plateau.getDimension() && pointLigne>0 && pointLigne<plateau.getDimension() && flag==true)
                {
                    //On cherche une case de la couleur du joueur, si on en trouve
                    //une, c'est un coup possible
                    if(matricePlateau[pointLigne][pointColonne] == this.couleur)
                    {
                        coupPossible.add(new Coup(tabCaseVide.get(j).getLigne(), tabCaseVide.get(j).getColonne()));
                        flag=false;
                    }
                    //Si on tombe sur une case vide, on sort de la boucle
                    if(matricePlateau[pointLigne][pointColonne] == Couleur.VIDE)
                    {
                        flag=false;
                    }
                    //On déplace la case à traiter
                    pointColonne=pointColonne+x;
                    pointLigne=pointLigne+y;
                }
            }
        }  
             
        return coupPossible;
    }
    
    //Fonction pour recopier un tableau
    public Couleur[][] copieTableau (Plateau plateau)
    {
        Couleur newPlateau[][] = new Couleur[plateau.getDimension()][plateau.getDimension()];
        
        for (int i=0; i<plateau.getDimension(); i++)
        {
            System.arraycopy(plateau.getMatricePlateau()[i], 0, newPlateau[i], 0, plateau.getDimension());
        }    
        
        return newPlateau;
    }
    
    
    public int retournerPions (Couleur[][] matricePlateau, Couleur couleur, Coup coup)
    {
        int nbPionsRetournes = 0;
        int x = 0; //Variable qui determine la direction horizontale
        int y = 0; //Variable qui determine la direction verticale
        //Variables pour analyser les cases
        int pointLigne;
        int pointColonne;
  
        //Condition pour sortir de boucle
        boolean flag = true;

        
        ArrayList<Coup> tabCaseAdverseAutour = chercheCouleurAdverseAutour(coup, matricePlateau); 
        for (int j=0; j<tabCaseAdverseAutour.size();j++)
        {
            // On cherche la direction en x et y
            x=-(coup.getColonne()-tabCaseAdverseAutour.get(j).getColonne());
            y=-(coup.getLigne()-tabCaseAdverseAutour.get(j).getLigne());

            //On fixe la case à traiter
            pointColonne = coup.getColonne()+x;
            pointLigne = coup.getLigne()+y;
            //On boucle tant qu'on est dans le tableau
            flag = true;
            while(pointColonne>0 && pointColonne<matricePlateau.length && pointLigne>0 && pointLigne<matricePlateau.length && flag==true)
            {
                //On cherche une case de la couleur du joueur, si on en trouve
                //une, on fait marche arriere pour retourner les pions
                if(matricePlateau[pointLigne][pointColonne] == this.couleur)
                {
                    pointColonne = pointColonne -x;
                    pointLigne = pointLigne - y;
                    /*
                     * On retourne effectivement les pions de la matrice
                     */
                    while(pointColonne != coup.getColonne() && pointLigne != coup.getLigne())
                    {
                        matricePlateau[pointLigne][pointColonne] = this.couleur;
                        pointColonne = pointColonne -x;
                        pointLigne = pointLigne - y;
                        nbPionsRetournes++;
                    }
                    flag = false;
                    
                }
                //Si on tombe sur une case vide, on sort de la boucle
                else if(matricePlateau[pointLigne][pointColonne] == Couleur.VIDE)
                {
                    flag=false;
                }
                //On déplace la case à traiter
                pointColonne=pointColonne+x;
                pointLigne=pointLigne+y;
            }
        }  
             
        return nbPionsRetournes;
    }
    
        //Fonction qui retourne un tableau des couleur adverse autour d'un pion
    private ArrayList<Coup> chercheCouleurAdverseAutour(Coup coup, Couleur[][] matricePlateau)
    {
        ArrayList<Coup> tabCaseCouleurAdverse = new ArrayList<Coup>();
        
        int lignePrecedente = coup.getLigne()-1;
        int ligneSuivante = coup.getLigne()+1;
        int colonnePrecedente = coup.getColonne()-1;
        int colonneSuivante = coup.getColonne()+1;

        int ligne;
        int colonne;
        boolean lignePossible = true;
        boolean colonnePossible = true;
                
        ligne = lignePrecedente;
        while (ligne<=ligneSuivante && lignePossible)
        {
            if(ligne<0)
            {
                lignePossible=false;
            }
            else if(ligne >=plateau.getDimension())
            {
                lignePossible=false;
            }
            else
            {
               colonnePossible=true;
               colonne = colonnePrecedente;
               while (colonne<=colonneSuivante && colonnePossible)
               {
                   
                   if(colonne<0)
                   {
                       colonnePossible=false;
                   }
                   else if(colonne >= plateau.getDimension())
                   {
                       colonnePossible=false;
                   }
                   else
                   {
                        if(matricePlateau[ligne][colonne] != this.couleur && matricePlateau[ligne][colonne] != Couleur.VIDE)
                        {
                            tabCaseCouleurAdverse.add(new Coup(ligne, colonne));
                        }
                   }
                   colonne++;
               }
            }
            ligne++;
        } 

        return tabCaseCouleurAdverse;
    }
    
    
    
    

    
    public TypeJoueur getType()
    {
        return typeJoueur;
    }

    public Couleur getCouleur()
    {
        return couleur;
    }

    public Plateau getPlateau()
    {
        return plateau;
    }


}
