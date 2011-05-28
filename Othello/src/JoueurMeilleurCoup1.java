
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
public class JoueurMeilleurCoup1 extends AbstractJoueur
{


    public JoueurMeilleurCoup1(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
    {
        super(couleur, plateau, typeJoueur);
    }

    /*
     * la visibilite de la fonction est passee en public pour pouvoir etre utilisee
     * dans les tests unitaires
     */
    public Coup meilleurCoupImmediat(Couleur[][] matricePlateau, Couleur couleur)
    {
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(matricePlateau, couleur);
        ArrayList<Integer> nbPionsRetournes = new ArrayList<Integer>();

        /*
         * Pour chaque coup possible, calcul le nombre de pions qui seraient retournes
         */
        for (int i = 0; i < coupPossible.size(); i++)
        {
            nbPionsRetournes.add(
                    retournerPions(
                    copieMatricePlateau(matricePlateau),
                    couleur,
                    coupPossible.get(i)));
        }

        /*
         * Recupere l'index du coup possible qui retourne le plus de pions
         */
        int index = 0;
        for (int i = 1; i < coupPossible.size(); i++)
        {
            if(nbPionsRetournes.get(i) > nbPionsRetournes.get(index))
            {
                index = i;
            }
        }

        Coup coup = coupPossible.get(index);
        return coup;
    }

    /*
     * Joue le coup qui retourne immediatement le plus de pions
     */
    @Override
    public Coup joue()
    {
        return meilleurCoupImmediat(this.plateau.getMatricePlateau(), this.getCouleur());
    }
}
