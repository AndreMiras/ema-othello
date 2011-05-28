/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tadarbrenaire;

import java.util.Arrays;

/**
 *
 * @author andre
 */
public class MinMax {



    public static int max(int[] tab)
    {
        Arrays.sort(tab);
        return tab[tab.length-1];
    }


    public static int min(int[] tab)
    {
        Arrays.sort(tab);
        return tab[0];
    }

    public static int valmax2(Noeud<Integer> noeud)
    {
        int valeurLocale;

        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo();
        }
        else
        {
             int tab[] = new int[noeud.getFils().size()];
             for (int i=0; i <= noeud.getFils().size(); i++)
            {
                 tab[i] = valmin2(noeud.getFils().get(i));
             }
             valeurLocale = max(tab);
        }
        return valeurLocale;
    }


    public static int valmin2(Noeud<Integer> noeud)
    {
        int valeurLocale;

        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo();

        }
        else
        {
             int tab[] = new int[noeud.getFils().size()];
             for (int i=0; i < noeud.getFils().size(); i++)
            {
                 tab[i] = valmax2(noeud.getFils().get(i));
             }
             valeurLocale = min(tab);
        }
        return valeurLocale;
    }

    public static int minMax2(Noeud<Integer> noeud)
    {
        Noeud localNoeud = new Noeud();
        Noeud tmpNoeud;
        int valeurLocale;
        int tab[] = new int[noeud.getFils().size()];


        for (int i=0; i < noeud.getFils().size(); i++)
        {
            tab[i] = valmin2(noeud.getFils().get(i));

        }

        valeurLocale = max(tab);

        return valeurLocale;

        //return localNoeud;
    }

}
