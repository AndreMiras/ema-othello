/*
 * InfoMatricePlateau.java
 * Author : Miras Andre & Tomio Nicolas
 */


/**
 * Cette classe correspond aux informations stockées dans un noeud
 */

/**
 * cette classe gère l'heuristique de suivante :
 * récupère la différence des pionds retournés (pions - pionsAdversaire)
 * le tout pondéré par un poid sur chaque case
 */
public class InfoMatricePlateau implements Comparable<InfoMatricePlateau>  {

    private int cornerHeuristicValue = 9;
    private int hedgeHeuristicValue = 3;

    /*
     * matrice de pondération, à chaque case un poid
     */
    private int ponderationMatrice[][] =
    {
        {cornerHeuristicValue, 1, 1, 1, 1, 1, 1,  cornerHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {hedgeHeuristicValue, 1, 1, 1, 1, 1, 1,  hedgeHeuristicValue},
        {cornerHeuristicValue, 1, 1, 1, 1, 1, 1,  cornerHeuristicValue}
    };

    
    protected Couleur[][] matricePlateau;
    /*
     * Cette valeur d'heuristique est calculee a partir de la matrice Plateau
     * puis conservee pour ne pas avoir a refaire le calcul a chaque fois.
     * Aussi la valeur heuristique n'est pas calculee dans le constructeur
     * pour reduire le temps de construction de l'arbre, en revanche
     * elle est calculee au moment du parcours de l'arbre par le minMax
     * voir getValHeuristique()
     */
    private Integer valHeuristique;

    protected Couleur color;
    private Coup coup;


    public InfoMatricePlateau(Couleur[][] matricePlateau, Couleur color, Coup coup)
    {
        this.matricePlateau = matricePlateau;
        this.color = color;
        this.coup = coup;
    }


    public Couleur[][] getMatricePlateau()
    {
        return matricePlateau;
    }

    public Coup getCoup()
    {
        return coup;
    }
    

    public void setIdent(Couleur[][] matricePlateau)
    {
        this.matricePlateau = matricePlateau;
    }

    /**
     * retourne la valeur heuristique si celle-ci a deja ete calculee, sinon
     * calcule, enregistre puis retourne la valeur heuristique
     * @return: la valeur heuristique
     */
    public Integer getValHeuristique()
    {
        /*
         * si la valeur Heuristique n'a pas encore ete calculee
         */
        if (valHeuristique == null)
        {
            valHeuristique = computeHeuristicValue();
        }
        return valHeuristique;
    }

    /**
     * calcule la valeur heuristique a partir d'une matrice de couleur
     * @return: calcul et retourne la valeur heuristique a partir d'une matrice de couleur
     */
    private Integer totalPionHeuristicValue()
    {
        int totalPieces = 0;
        int opponentTotalPieces = 0;
        Couleur opponentColor = Helper.getOppositeCouleur(color);

        for(int row = 0; row < matricePlateau.length; row++)
        {
           for(int col = 0; col < matricePlateau[row].length; col++)
           {
               if(matricePlateau[row][col] == color)
               {
                   totalPieces++;
               }
               else if (matricePlateau[row][col] == opponentColor)
               {
                   opponentTotalPieces++;
               }
           }
        }

        return totalPieces - opponentTotalPieces;
    }

    /**
     * pondère les cotés et les coins
     * @return: le coefficient de ponderation de l'heuristique générale
     */
    private int pondereHeuristicValue()
    {
        /*
        int poids = 1;
        if (coup.getLigne() == 0 || coup.getLigne() == 7)
        {
            poids *= borderHeuristicValue;
        }
        if (coup.getColonne() == 0 || coup.getColonne() == 7)
        {
            poids *= borderHeuristicValue;
        }
         * 
         */
        
        return ponderationMatrice[coup.getLigne()][coup.getColonne()];
    }

    private int computeHeuristicValue()
    {
        return totalPionHeuristicValue() * pondereHeuristicValue();
    }

    public int compareTo(InfoMatricePlateau t)
    {
        return getValHeuristique().compareTo(t.getValHeuristique());
    }

    /*
    @Override
    public String toString()
    {
        return Integer.toString(plateau);
    }
     *
     */
}
