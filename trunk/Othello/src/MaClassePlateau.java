/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;

/**
 *
 * @author ntomio
 */
public class MaClassePlateau {

    private Plateau plateau;
    private float valHeuristique;

    public MaClassePlateau()
    {
    }

    public MaClassePlateau(Plateau plateau)
    {
        this.plateau = plateau;
    }


    

    public Plateau getPlateau()
    {
        return plateau;
    }

    public void setIdent(Plateau plateau)
    {
        this.plateau = plateau;
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

    /*
    @Override
    public String toString()
    {
        return Integer.toString(plateau);
    }
     *
     */

    

}
