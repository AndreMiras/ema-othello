
import java.util.ArrayList;

/*
 * AbstractJoueur.java
 * Author : Miras Andre & Tomio Nicolas
 */

/**
 * Dans la classe abstraite, AbstractJoueur, nous retrouvons deux fonction principales : chercheCoupPossible 
 * et retournePions, et différentes petites fonction permettant la réalisation des deux principales.
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
        Couleur oppositeColor = Helper.getOppositeCouleur(couleur);
        int boardDimension = plateau.getDimension();

        //On parcourt le tableau
        for(int i=0; i<boardDimension; i++)
        {
            for(int j=0; j<boardDimension; j++)
            {
                //Si la couleur correspond au joueur adverse
                if (matricePlateau[i][j] == oppositeColor)
                {
                    //On l'ajoute au tableau
                    tabCouleurAdverse.add(new Coup(i, j));
                }
            }
        }
        return tabCouleurAdverse;
    }
    
    /*
     * Pour un plateau donne et une couleur, retourne les coups possibles
     */
    protected ArrayList<Coup> chercheCoupPossible(Couleur[][] matricePlateau, Couleur couleur)
    {
        //Tableau dans lequel seront stockés les coups possibles
        ArrayList<Coup> coupPossible = new ArrayList<Coup>();
        Coup coupAComparer;

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
            ArrayList<Coup> tabCaseVide = chercheVideAutour(matricePlateau, tabCouleurAdverse.get(i));
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
                while(pointColonne>=0 && pointColonne<plateau.getDimension() && pointLigne>=0 && pointLigne<plateau.getDimension() && flag==true)
                {
                    //On cherche une case de la couleur du joueur, si on en trouve
                    //une, c'est un coup possible
                    if(matricePlateau[pointLigne][pointColonne] == couleur)
                    {
                        // on verifie que le coup n'a pas deja ete ajoute avant de l'ajouter
                        coupAComparer = new Coup(tabCaseVide.get(j).getLigne(), tabCaseVide.get(j).getColonne());
                        if (!Helper.coupIn(coupAComparer, coupPossible))
                        {
                            coupPossible.add(coupAComparer);
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
        }  
             
        return coupPossible;
    }
    
    /**
     * 
     * @param matricePlateau: la matrice a copier
     * @return: une copie de matricePlateau
     */
    public Couleur[][] copieMatricePlateau(Couleur[][] matricePlateau)
    {
        Couleur newMatricePlateau[][] =
                new Couleur[matricePlateau.length][matricePlateau[0].length];
        
        for (int i=0; i<matricePlateau.length; i++)
        {
            System.arraycopy(matricePlateau[i], 0, newMatricePlateau[i], 0, matricePlateau.length);
        }    
        
        return newMatricePlateau;
    }
    
    
    public int retournerPions(Couleur[][] matricePlateau, Couleur couleur, Coup coup)
    {
        int nbPionsRetournes = 0;
        int x = 0; //Variable qui determine la direction horizontale
        int y = 0; //Variable qui determine la direction verticale
        //Variables pour analyser les cases
        int pointLigne;
        int pointColonne;
  
        //Condition pour sortir de boucle
        boolean flag = true;

        
        ArrayList<Coup> tabCaseAdverseAutour = chercheCouleurAdverseAutour(matricePlateau, couleur, coup);
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
                if(matricePlateau[pointLigne][pointColonne] == couleur)
                {
                    pointColonne = pointColonne -x;
                    pointLigne = pointLigne - y;
                    /*
                     * On retourne effectivement les pions de la matrice
                     */
                    while(pointColonne != coup.getColonne() || pointLigne != coup.getLigne())
                    {
                        matricePlateau[pointLigne][pointColonne] = couleur;
                        pointColonne = pointColonne -x;
                        pointLigne = pointLigne - y;
                        nbPionsRetournes++;
                    }
                    flag = false;
                    
                }
                //Si on tombe sur une case vide, on sort de la boucle
                else if(matricePlateau[pointLigne][pointColonne] == Couleur.VIDE)
                {
                    flag = false;
                }
                //On déplace la case à traiter
                pointColonne=pointColonne+x;
                pointLigne=pointLigne+y;
            }
        }  
             
        return nbPionsRetournes;
    }


    /**
     *
     * @param matricePlateau
     * @param coup
     * @return: retourne les cases vides autour d'un pion passe en parametre
     */
    private ArrayList<Coup> chercheVideAutour(Couleur[][] matricePlateau, Coup coup)
    {
        return getNeighborWithColor(matricePlateau, Couleur.VIDE, coup);
    }

    
    /**
     * 
     * @param matricePlateau
     * @param couleur
     * @param coup
     * @return: un tableau avec tout les pion de la couleur passee en param autour du coup passe en param
     */
    private ArrayList<Coup> getNeighborWithColor(Couleur[][] matricePlateau, Couleur couleur, Coup coup)
    {
        ArrayList<Coup> tabCaseCouleurAdverse = new ArrayList<Coup>();
        
        int lignePrecedente = coup.getLigne()-1;
        int ligneSuivante = coup.getLigne()+1;
        int colonnePrecedente = coup.getColonne()-1;
        int colonneSuivante = coup.getColonne()+1;

        int ligne;
        int colonne;
                
        ligne = lignePrecedente;
        while (ligne<=ligneSuivante)
        {
           /*
            * Si la ligne choisie est dans les bornes du plateau
            */
            if ((ligne >= 0) && (ligne < plateau.getDimension()))
            {
               colonne = colonnePrecedente;
               while (colonne<=colonneSuivante)
               {
                   /*
                    * Si la colonne choisie est dans les bornes du plateau
                    */
                   if ((colonne >= 0) && (colonne < plateau.getDimension()))
                   {
                        if(matricePlateau[ligne][colonne] == couleur)
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
    
    
    private ArrayList<Coup> chercheCouleurAdverseAutour(Couleur[][] matricePlateau, Couleur couleur, Coup coup)
    {
        Couleur opponentColor = Helper.getOppositeCouleur(couleur);

        return getNeighborWithColor(matricePlateau, opponentColor, coup);
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
