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
public class Noeud<T> implements Comparable<Noeud> {

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

    public Noeud<T> getFils(int i)
    {
        return fils.get(i);
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

    public int compareTo(Noeud otherNode)
    {
        if (!(otherNode.getInfo() instanceof Comparable))
        {
            throw new ClassCastException("A Comparable object expected.");
        }
        Comparable comparableObject = ((Comparable) otherNode.getInfo());
        return ((Comparable)getInfo()).compareTo(comparableObject);
    }

}
