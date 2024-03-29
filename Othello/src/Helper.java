
import java.util.ArrayList;

/*
 * Helper.java
 * Author : Miras Andre & Tomio Nicolas
 */

/**
 * Cette classe permet de faire des comparaisons sur des coups
 * et de trouver la couleur adverse
 * 
 */
public class Helper {

        /**
     * Retourne vrai si les deux coups (lignes et colonnes sont egaux)
     * @param c1: coup 1
     * @param c2: coup 2
     * @return: vrai si les deux coups (lignes et colonnes sont egaux)
     */
    public static boolean coupEqual(Coup c1, Coup c2)
    {
        return ((c1.getLigne() == c2.getLigne())
                && (c1.getColonne() == c2.getColonne()));
    }

    /**
     *
     * @param c1: le coup don't on veut tester l'appartenance a la liste de coups
     * @param coups: une liste de coups
     * @return: vrai si c1 appartient a la liste de  coups
     */
    public static boolean coupIn(Coup c1, ArrayList<Coup> coups)
    {
        int i = 0;

        if (coups.isEmpty())
        {
            return false;
        }
        
        while(i<coups.size()-1 && !coupEqual(c1, coups.get(i)))
        {
            i++;
        }
        return coupEqual(c1, coups.get(i));
    }

    public static String coupToString(Coup coup)
    {
        return "(" + coup.getLigne() + "," + coup.getColonne() + ")";
    }



    public static Couleur getOppositeCouleur(Couleur color)
    {
        if (color == Couleur.BLANC)
        {
            return Couleur.NOIR;
        }
        return Couleur.BLANC;
    }

    
}
