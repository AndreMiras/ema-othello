
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
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

        while(i<coups.size() && !coupEqual(c1, coups.get(i)))
        {
            i++;
        }
        return coupEqual(c1, coups.get(i));
    }

    
}
