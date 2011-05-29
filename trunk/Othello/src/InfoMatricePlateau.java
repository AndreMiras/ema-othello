
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class InfoMatricePlateau {

    private Couleur[][] matricePlateau;
    private float valHeuristique;

    public InfoMatricePlateau()
    {
    }

    public InfoMatricePlateau(Couleur[][] matricePlateau)
    {
        this.matricePlateau = matricePlateau;
    }




    public Couleur[][] getMatricePlateau()
    {
        return matricePlateau;
    }

    public void setIdent(Couleur[][] matricePlateau)
    {
        this.matricePlateau = matricePlateau;
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
