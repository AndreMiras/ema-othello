/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbrenaire;

import java.util.ArrayList;
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
     * @return: retourne la node qui a la valeur maximum du tableau tab
     */
    public Noeud<T> maxNode(ArrayList<Noeud<T>> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(0);
    }

    /**
     *
     * @param tab: tableau de valeurs pour lequel on veut connaitre le min
     * @return: retourne la node qui a la valeur minimum du tableau tab
     */
    public Noeud<T> minNode(ArrayList<Noeud<T>> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(tab.size() - 1);
    }

    private Noeud<T> valMaxNode(Noeud<T> noeud)
    {
        Noeud<T> localNode;

        if (noeud.isNoeudFeuille())
        {
            localNode = noeud;
        } else
        {
            ArrayList<Noeud<T>> tab = new ArrayList<Noeud<T>>();
            for (int i = 0; i <= noeud.getFils().size(); i++)
            {
                tab.add(valMinNode(noeud.getFils().get(i)));
            }
            localNode = maxNode(tab);
        }
        return localNode;
    }

    private Noeud<T> valMinNode(Noeud<T> noeud)
    {
        Noeud<T> localNode;

        if (noeud.isNoeudFeuille())
        {
            localNode = noeud;

        } else
        {
            ArrayList<Noeud<T>> tab = new ArrayList<Noeud<T>>();
            for (int i = 0; i < noeud.getFils().size(); i++)
            {
                tab.add(valMaxNode(noeud.getFils().get(i)));
            }
            localNode = minNode(tab);
        }
        return localNode;
    }

    /**
     * 
     * @param noeud: noeud de depart de l'algo minMax
     * @return: la valeur de la feuille min(max(min(...)))
     */
    public T minMax(Noeud<T> noeud)
    {
        return minMaxNode(noeud).getInfo();
    }

    /**
     *
     * @param noeud: noeud de depart de l'algo minMax
     * @return: le noeud feille min(max(min(...)))
     */
    public Noeud<T> minMaxNode(Noeud<T> noeud)
    {
        Noeud<T> localNode;
        T valeurLocale;
        ArrayList<Noeud<T>> tab = new ArrayList<Noeud<T>>();


        for (int i = 0; i < noeud.getFils().size(); i++)
        {
            tab.add(valMinNode(noeud.getFils().get(i)));

        }

        localNode = maxNode(tab);

        return localNode;
    }
}
