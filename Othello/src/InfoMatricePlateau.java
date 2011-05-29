/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class InfoMatricePlateau implements Comparable<InfoMatricePlateau>  {

    /*
     * nombre de case total dans le jeu
     */
    private int TOTAL_CASE = 8*8;
    
    private Couleur[][] matricePlateau;
    /*
     * La valeur heuristique correspond au rapport du nombre de pions retournes
     * sur le nombre de pions total.
     * Cette valeur est calculee a partir de la matrice Plateau puis conservee
     * pour ne pas avoir a refaire le calcul a chaque fois.
     */
    private Float valHeuristique;

    private Couleur color;
    private Coup coup;

    public InfoMatricePlateau()
    {
    }

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
     * calcul, enregistre puis retourne la valeur heuristique
     * @return: la valeur heuristique
     */
    public Float getValHeuristique()
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
    private Float computeHeuristicValue()
    {
        Float totalPion = new Float(0);
        for(int row = 0; row < matricePlateau.length; row++)
        {
           for(int col = 0; col < matricePlateau[row].length; col++)
           {
               if(matricePlateau[row][col] == color)
               {
                   totalPion++;
               }
           }
        }
        return (totalPion/TOTAL_CASE);
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
