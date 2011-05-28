package tadarbrenaire;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;

/**
 *
 * @author ntomio
 */
public class MaClasse implements Comparable<MaClasse> {

    private int ident;
    private float valHeuristique;

    public MaClasse()
    {
    }

    public MaClasse(int ident)
    {
        this.ident = ident;
    }


    

    public int getIdent()
    {
        return ident;
    }

    public void setIdent(int ident)
    {
        this.ident = ident;
    }

    public float getValHeuristique()
    {
        return valHeuristique;
    }

    public void setValHeuristique(float valHeuristique)
    {
        this.valHeuristique = valHeuristique;
    }

    public void setValRandomHeuristique()
    {
        Random r = new Random();
        setValHeuristique(r.nextFloat());
    }

    public int compareTo(MaClasse t)
    {
        return ((Float)valHeuristique).compareTo(t.getValHeuristique());
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
