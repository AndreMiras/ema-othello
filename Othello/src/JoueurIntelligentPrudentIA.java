
import java.util.ArrayList;
import java.util.Random;
import tadarbrenaire.ArbreNaire;
import tadarbrenaire.MinMax;
import tadarbrenaire.Noeud;

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
        int depth = 2;
        ArbreNaire<InfoMatricePlateau> arbre;
        MinMax<InfoMatricePlateau> minMaxInfoMatricePlateau;
        Noeud<InfoMatricePlateau> nodeMinMax;
        Noeud<InfoMatricePlateau> nodeToPlay;
        
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        // for tests
        arbre = buildArbre(depth);

        minMaxInfoMatricePlateau = new MinMax<InfoMatricePlateau>();

        /*
         * On fait remonter le noeud qui nous interesse via minMax
         */
        nodeMinMax = minMaxInfoMatricePlateau.minMaxNode(arbre.racine);

        /*
         * on recupere le premier noeud menant vers ce noeud
         */
        nodeToPlay = nodeMinMax;
        for(int i = 0; i < depth-1; i++)
        {
            nodeToPlay = nodeToPlay.getPere();
        }

        Coup coup = nodeToPlay.getInfo().getCoup();
        return coup;
    }

    /*
     * Fonction pour créer la racine de l'arbre maClasse et appel
     * la fonction récursive
     * TODO: remove the largeur parameter
     * TODO: faire le propre dans la construction de l'arbre
     */
    public ArbreNaire<InfoMatricePlateau> buildArbre(int profondeur)
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
                new InfoMatricePlateau(matricePlateau, this.getCouleur(), null);
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

        Couleur[][] matricePlateau = arbre.getItem().getMatricePlateau();
                // new Couleur[plateau.getDimension()][plateau.getDimension()];
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
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
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
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
                arbre.addFils(infoMatricePlateau);
                arbre.goToFils(i);
                buildArbreRec2(arbre, profondeur - 1);
                arbre.goToPere();
            }
        }
        return arbre;
    }
}
