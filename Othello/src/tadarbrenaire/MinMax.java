/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbrenaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author andre
 */
public class MinMax<T>
{
    
    public MinMax()
    {
    }

    /**
     *
     * @param tab: tableau de valeurs pour lequel on veut connaitre le max
     * @return: valeur maximum du tableau tab
     */
    public T max(ArrayList<T> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(0);
    }

    /**
     *
     * @param tab: tableau de valeurs pour lequel on veut connaitre le min
     * @return: valeur minimum du tableau tab
     */
    public T min(ArrayList<T> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(tab.size() - 1);
    }

    private T valMax(Noeud<T> noeud)
    {
        T valeurLocale;

        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo();
        } else
        {
            ArrayList<T> tab = new ArrayList<T>();
            for (int i = 0; i <= noeud.getFils().size(); i++)
            {
                tab.add(valMin(noeud.getFils().get(i)));
            }
            valeurLocale = max(tab);
        }
        return valeurLocale;
    }

    private T valMin(Noeud<T> noeud)
    {
        T valeurLocale;

        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo();

        } else
        {
            ArrayList<T> tab = new ArrayList<T>();
            for (int i = 0; i < noeud.getFils().size(); i++)
            {
                tab.add(valMax(noeud.getFils().get(i)));
            }
            valeurLocale = min(tab);
        }
        return valeurLocale;
    }

    /**
     * 
     * @param noeud: noeud de depart de l'algo minMax
     * @return: la valeur de la feuille min(max(min(...)))
     */
    public T minMax(Noeud<T> noeud)
    {
        Noeud localNoeud = new Noeud();
        Noeud tmpNoeud;
        T valeurLocale;
        ArrayList<T> tab = new ArrayList<T>();


        for (int i = 0; i < noeud.getFils().size(); i++)
        {
            tab.add(valMin(noeud.getFils().get(i)));

        }

        valeurLocale = max(tab);

        return valeurLocale;
    }
}
