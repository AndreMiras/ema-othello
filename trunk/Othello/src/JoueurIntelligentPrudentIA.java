
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
     * Joue un coup intelligent et prudent (MinMax)
     */
    @Override
    public Coup joue()
    {
        System.out.println("Coup possible : ");
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        // for tests
        buildArbre(2, 3);

        Coup coup = null;
        return coup;
    }

    /*
     * Fonction pour créer la racine de l'arbre maClasse et appel
     * la fonction récursive
     * TODO: remove the largeur parameter
     */
    public ArbreNaire buildArbre(int profondeur, int largeur)
    {
        // TODO: init plateau with the correct plateau
        // Plateau testPlateau = this.getPlateau(); // = new Plateau();

        /*
         * Initialisation de la matrice plateau (avec les 4 pions de depart)
         */
        Couleur[][] matricePlateau = this.getPlateau().getMatricePlateau();
        // MaClassePlateau maClasse = new MaClassePlateau(testPlateau);

        // ArbreNaire<MaClassePlateau> a = new ArbreNaire<MaClassePlateau>(maClasse);

        InfoMatricePlateau infoMatricePlateau = new InfoMatricePlateau(matricePlateau);
        ArbreNaire<InfoMatricePlateau> arbre =
                new ArbreNaire<InfoMatricePlateau>(infoMatricePlateau);

        
        arbre = buildArbreRec2(arbre, profondeur, largeur);
        return arbre;
    }


    /*
     * Creation de l'arbre en utilisant les fonction de retournement de pion custom
     */
    public ArbreNaire buildArbreRec2(ArbreNaire<InfoMatricePlateau> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;
        InfoMatricePlateau tmpMaClasse;

        Couleur[][] matricePlateau =
                new Couleur[plateau.getDimension()][plateau.getDimension()];
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(arbre.getItem().getMatricePlateau(), this.getCouleur());
        int largeur2 = coupPossible.size();

        /* Feuille */
        // TODO: the if and for statements are to be redone/removed to only be recursive
        if (profondeur == 1)
        {
            for(int i = 0; i < largeur; i ++)
           {
               /*
               tmpInteger = arbre.vue.getInfo().getIdent() * 10;
               tmpInteger += i;
                */
               tmpMaClasse = new InfoMatricePlateau(matricePlateau);
               tmpMaClasse.setValRandomHeuristique();
               arbre.addFils(tmpMaClasse);
           }
        }
        else
        {
            for (int i = 0; i < largeur2; i++)
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
