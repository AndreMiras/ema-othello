
import java.util.ArrayList;
import java.util.Random;

/*
 * JoueurRandomIA.java
 * Author : Miras Andre & Tomio Nicolas
 */

/*
 * Ce joueur automatique se contente de joueur un coup aleatoire parmis
 * les coups possibles
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
        /*
         * On récupère tous les coups possibles
         */
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        /*
         * On affiche les coups possibles dans la sortie stadard
         */
        System.out.println("Coup possible : ");
        for (int i = 0; i < coupPossible.size(); i++)
        {
            System.out.println("Ligne : " + coupPossible.get(i).getLigne() + " Colonne : " + coupPossible.get(i).getColonne());
        }

        /*
         * On génère un chiffre aléatoirement
         */
        Random r = new Random();
        int valeur = r.nextInt(coupPossible.size());

        /*
         * On joue le coup correspondant au chiffre généré
         */
        Coup coup = coupPossible.get(valeur);
        return coup;
    }
}
