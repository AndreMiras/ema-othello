import java.util.Random;

/*
 * MaClassePlateau.java
 * Author : Miras Andre & Tomio Nicolas
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
