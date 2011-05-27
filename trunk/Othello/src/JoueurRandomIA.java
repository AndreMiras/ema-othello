
import java.util.ArrayList;
import java.util.Random;

/*
 * Ce joueur automatique se contente de joueur un coup aleatoire parmis
 * les coups possibles
 */
/**
 *
 * @author andre
 */
public class JoueurRandomIA extends AbstractJoueur
{


    public JoueurRandomIA(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
    {
        super(couleur, plateau, typeJoueur);
    }

    /*
     * Joue un coup aleatoire parmis les coups possibles
     */
    @Override
    public Coup joue()
    {
        System.out.println("Coup possible : ");
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        for (int i = 0; i < coupPossible.size(); i++)
        {
            System.out.println("Ligne : " + coupPossible.get(i).getLigne() + " Colonne : " + coupPossible.get(i).getColonne());
        }

        Random r = new Random();


        int valeur = r.nextInt(coupPossible.size());

        Coup coup = coupPossible.get(valeur);
        return coup;
    }
}
