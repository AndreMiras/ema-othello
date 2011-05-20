
import java.util.ArrayList;
import java.util.Random;
import tadarbrenaire.ArbreNaire;

/*
 * Ce joueur automatique se contente de joueur un coup aleatoire parmis
 * les coups possibles
 */
/**
 *
 * @author andre
 */
public class JoueurIntelligentPrudentIA extends AbstractJoueur
{


    public JoueurIntelligentPrudentIA(Couleur couleur, Plateau plateau, TypeJoueur typeJoueur)
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
                chercheCoupPossible(this.getPlateau(), this.getCouleur());

        for (int i = 0; i < coupPossible.size(); i++)
        {
            System.out.println("Ligne : " + coupPossible.get(i).getLigne() + " Colonne : " + coupPossible.get(i).getColonne());
        }

        Random r = new Random();


        int valeur = r.nextInt(coupPossible.size());

        Coup coup = coupPossible.get(valeur);
        return coup;
    }

    /*
     * Fonction pour créer la racine de l'arbre maClasse et appel
     * la fonction récursive
     */
    public static ArbreNaire buildArbreMaClasse(int profondeur, int largeur)
    {
        // TODO: init plateau with the correct plateau
        Plateau testPlateau = new Plateau();
        MaClasse maClasse = new MaClasse(testPlateau);

        ArbreNaire<MaClasse> a = new ArbreNaire<MaClasse>(maClasse);
        a = buildArbreMaClasseRec(a, profondeur, largeur);
        return a;
    }


    /*
     * Creation de l'arbre
     * TODO: finish up
     */
     public static ArbreNaire buildArbreMaClasseRec(ArbreNaire<MaClasse> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;
        MaClasse tmpMaClasse;

        Plateau testPlateau = new Plateau();

        /* Feuille */
        if (profondeur == 1)
        {
            for(int i = 0; i < largeur; i ++)
           {
               /*
               tmpInteger = arbre.vue.getInfo().getIdent() * 10;
               tmpInteger += i;
                */
               tmpMaClasse = new MaClasse(testPlateau);
               tmpMaClasse.setValRandomHeuristique();
               arbre.addFils(tmpMaClasse);
           }
        }
        else
        {
            for (int i = 0; i < largeur; i++)
            {
                /*
                tmpInteger = arbre.vue.getInfo().getIdent() * 10;
                tmpInteger += i;
                tmpMaClasse = new MaClasse(tmpInteger);
                arbre.addFils(tmpMaClasse);
                arbre.goToFils(i);
                buildArbreMaClasseRec(arbre, profondeur - 1, largeur);
                arbre.goToPere();
                *
                */
            }
        }
        return arbre;
    }


}
