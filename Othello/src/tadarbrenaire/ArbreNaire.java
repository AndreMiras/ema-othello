package tadarbrenaire;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class ArbreNaire<T>
{

    public Noeud<T> racine;
    public Noeud<T> vue;

    public ArbreNaire()
    {
        this.racine = null;
        this.vue = null;
    }

    public ArbreNaire(T info)
    {
        /*
        this.racine = racine;
        this.vue = racine;
         */
        initRacine(info);
    }

    public void initRacine(T info)
    {
        Noeud node = new Noeud(info);
        this.racine = node;
        this.vue = this.racine;
    }

    public void addFils(T item)
    {
        Noeud noeud = new Noeud(item);
        vue.getFils().add(noeud);
        noeud.setPere(vue);
    }

    public T getItem()
    {
        return vue.getInfo();
    }

    public boolean isRacine()
    {
        return (vue == racine);
    }

    public boolean isNoeudFeuille()
    {
        return vue.getFils() == null;
    }

    public int getNbFils()
    {
        return vue.getFils().size();
    }

    public void goToRacine()
    {
        this.vue = this.racine;
    }

    public void goToFils(int i)
    {
        this.vue = this.vue.getFils().get(i);
    }

    public void goToPere()
    {
        this.vue = this.vue.getPere();
    }

    public void suppressNoeud()
    {
    }


    public void depthSearchToArrayList(ArrayList<T> list)
    {
        list.add(vue.getInfo());

        if(!isNoeudFeuille())
        {
            for(int i=0; i < getNbFils(); i++)
            {
                goToFils(i);
                depthSearchToArrayList(list);
                goToPere();
            }
        }
    }
}
