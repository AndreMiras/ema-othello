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

    public T max(ArrayList<T> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(0);
    }

    public T min(ArrayList<T> tab)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(tab, comparator);
        return tab.get(tab.size() - 1);
    }

    public T valmax2(Noeud<T> noeud)
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
                tab.add(valmin2(noeud.getFils().get(i)));
            }
            valeurLocale = max(tab);
        }
        return valeurLocale;
    }

    public T valmin2(Noeud<T> noeud)
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
                tab.add(valmax2(noeud.getFils().get(i)));
            }
            valeurLocale = min(tab);
        }
        return valeurLocale;
    }

    public T minMax2(Noeud<T> noeud)
    {
        Noeud localNoeud = new Noeud();
        Noeud tmpNoeud;
        T valeurLocale;
        ArrayList<T> tab = new ArrayList<T>();


        for (int i = 0; i < noeud.getFils().size(); i++)
        {
            tab.add(valmin2(noeud.getFils().get(i)));

        }

        valeurLocale = max(tab);

        return valeurLocale;

        //return localNoeud;
    }
}
