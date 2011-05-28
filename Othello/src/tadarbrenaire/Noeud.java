package tadarbrenaire;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;

/**
 *
 * @author ntomio
 */
class Noeud<T> {

    private T info;
    private Noeud<T> pere;
    private ArrayList<Noeud<T>> fils;

    public Noeud()
    {
        this(null);
    }

    public Noeud(T info)
    {
        this.info = info;
        this.pere = null;
        this.fils = new ArrayList<Noeud<T>>();
    }

    public ArrayList<Noeud<T>> getFils()
    {
        return fils;
    }

    public T getInfo()
    {
        return info;
    }

    public String toString ()
    {
        return getInfo().toString();
    }

    public Noeud<T> getPere()
    {
        return pere;
    }

    public void setPere(Noeud<T> pere)
    {
        this.pere = pere;
    }

    public boolean isNoeudFeuille()
    {
        return getFils().isEmpty();
    }

}
