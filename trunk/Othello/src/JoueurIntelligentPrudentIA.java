
import java.util.ArrayList;
import java.util.Random;
import tadarbrenaire.ArbreNaire;
import tadarbrenaire.MinMax;
import tadarbrenaire.Noeud;

/*
 * JoueurIntelligentPrudentIA.java
 * Author : Miras Andre & Tomio Nicolas
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


        /*
         * Initialisation de la matrice plateau (avec les 4 pions de depart)
         */
        arbre = buildArbre(
                this.getPlateau().getMatricePlateau(), depth, this.getCouleur());

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
    public ArbreNaire<InfoMatricePlateau> buildArbre(Couleur[][] matricePlateau, int profondeur, Couleur color)
    {
        InfoMatricePlateau infoMatricePlateau =
                new InfoMatricePlateau(matricePlateau, color, null);
        ArbreNaire<InfoMatricePlateau> arbre =
                new ArbreNaire<InfoMatricePlateau>(infoMatricePlateau);


        arbre = buildArbreRec2(arbre, profondeur, color);
        return arbre;
    }


    /*
     * Creation de l'arbre en utilisant les fonction de retournement de pion custom
     */
    private ArbreNaire<InfoMatricePlateau> buildArbreRec2(ArbreNaire<InfoMatricePlateau> arbre, int profondeur, Couleur color)
    {
        InfoMatricePlateau infoMatricePlateau;

        Couleur[][] matricePlateau = arbre.getItem().getMatricePlateau();
                // new Couleur[plateau.getDimension()][plateau.getDimension()];
        // utilisee pour jouer les coups des fils
        Couleur[][] tmpMatricePlateau;
        
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(arbre.getItem().getMatricePlateau(), color);
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
                retournerPions(tmpMatricePlateau, color, coupPossible.get(i));
                // on ajoute le pion joue
                tmpMatricePlateau[coupPossible.get(i).getLigne()][coupPossible.get(i).getColonne()] =
                        color;

                infoMatricePlateau =
                        new InfoMatricePlateau(tmpMatricePlateau, color, coupPossible.get(i));
                // tmpMaClasse.setValRandomHeuristique();
                arbre.addFils(infoMatricePlateau);
            }
        } else
        {
            for (int i = 0; i < largeur2; i++)
            {
                tmpMatricePlateau = copieMatricePlateau(matricePlateau);
                retournerPions(tmpMatricePlateau, color, coupPossible.get(i));
                // on ajoute le pion joue
                tmpMatricePlateau[coupPossible.get(i).getLigne()][coupPossible.get(i).getColonne()] =
                        color;

                infoMatricePlateau =
                        new InfoMatricePlateau(tmpMatricePlateau, color, coupPossible.get(i));
                arbre.addFils(infoMatricePlateau);
                arbre.goToFils(i);
                buildArbreRec2(arbre, profondeur - 1, getOppositeCouleur(color));
                arbre.goToPere();
            }
        }
        return arbre;
    }
}
