
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
        ArbreNaire<InfoMatricePlateau> arbre;
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        // for tests
        arbre = buildArbre(2, 3);

        Coup coup = null;
        return coup;
    }

    /*
     * Fonction pour créer la racine de l'arbre maClasse et appel
     * la fonction récursive
     * TODO: remove the largeur parameter
     * TODO: faire le propre dans la construction de l'arbre
     */
    public ArbreNaire<InfoMatricePlateau> buildArbre(int profondeur, int largeur)
    {
        // TODO: init plateau with the correct plateau
        // Plateau testPlateau = this.getPlateau(); // = new Plateau();

        /*
         * Initialisation de la matrice plateau (avec les 4 pions de depart)
         */
        Couleur[][] matricePlateau = this.getPlateau().getMatricePlateau();
        // MaClassePlateau maClasse = new MaClassePlateau(testPlateau);

        // ArbreNaire<MaClassePlateau> a = new ArbreNaire<MaClassePlateau>(maClasse);

        InfoMatricePlateau infoMatricePlateau =
                new InfoMatricePlateau(matricePlateau, this.getCouleur());
        ArbreNaire<InfoMatricePlateau> arbre =
                new ArbreNaire<InfoMatricePlateau>(infoMatricePlateau);


        arbre = buildArbreRec2(arbre, profondeur);
        return arbre;
    }


    /*
     * Creation de l'arbre en utilisant les fonction de retournement de pion custom
     */
    public ArbreNaire<InfoMatricePlateau> buildArbreRec2(ArbreNaire<InfoMatricePlateau> arbre, int profondeur)
    {
        InfoMatricePlateau infoMatricePlateau;

        Couleur[][] matricePlateau =
                new Couleur[plateau.getDimension()][plateau.getDimension()];
        // utilisee pour jouer les coups des fils
        Couleur[][] tmpMatricePlateau;
        
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(arbre.getItem().getMatricePlateau(), this.getCouleur());
        int largeur2 = coupPossible.size();

        /* Feuille */
        // TODO: the if and for statements are to be redone/removed to only be recursive
        if (profondeur == 1)
        {
            for (int i = 0; i < largeur2; i++)
            {
                /*
                tmpInteger = arbre.vue.getInfo().getIdent() * 10;
                tmpInteger += i;
                 */
                tmpMatricePlateau = copieMatricePlateau(matricePlateau);
                retournerPions(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
                // on ajoute le pion joue
                tmpMatricePlateau[coupPossible.get(i).getLigne()][coupPossible.get(i).getColonne()] =
                        this.getCouleur();
                // TODO: il faut changer de couleur un coup sur deux
                infoMatricePlateau =
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur());
                // tmpMaClasse.setValRandomHeuristique();
                arbre.addFils(infoMatricePlateau);
            }
        } else
        {
            for (int i = 0; i < largeur2; i++)
            {
                tmpMatricePlateau = copieMatricePlateau(matricePlateau);
                retournerPions(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
                // on ajoute le pion joue
                tmpMatricePlateau[coupPossible.get(i).getLigne()][coupPossible.get(i).getColonne()] =
                        this.getCouleur();

                // TODO: il faut changer de couleur un coup sur deux
                infoMatricePlateau =
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur());
                arbre.addFils(infoMatricePlateau);
                arbre.goToFils(i);
                buildArbreRec2(arbre, profondeur - 1);
                arbre.goToPere();
            }
        }
        return arbre;
    }
}
