
import java.util.ArrayList;
import tadarbrenaire.ArbreNaire;
import tadarbrenaire.MinMax;
import tadarbrenaire.Noeud;

/*
 * JoueurIntelligentPrudentIA.java
 * Author : Miras Andre & Tomio Nicolas
 */



public class JoueurIntelligentPrudentIA extends AbstractJoueurIA
{
    private int depth;

    public JoueurIntelligentPrudentIA(Couleur couleur, Plateau plateau, int depth)
    {
        super(couleur, plateau);
        this.depth = depth;
    }

    /*
     * Joue un coup intelligent et prudent (MinMax)
     */
    @Override
    public Coup joue()
    {
        ArbreNaire<InfoMatricePlateau> arbre;
        MinMax<InfoMatricePlateau> minMaxInfoMatricePlateau;
        Noeud<InfoMatricePlateau> nodeMinMax;
        Noeud<InfoMatricePlateau> nodeToPlay;
        Noeud<InfoMatricePlateau> nodeToPlayParent;
        

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
         * on remonte le premier noeud menant vers ce noeud
         */
        nodeToPlayParent = nodeMinMax;
        nodeToPlay = nodeToPlayParent;
        while(nodeToPlayParent.getPere() != null)
        {
            nodeToPlay = nodeToPlayParent;
            nodeToPlayParent = nodeToPlayParent.getPere();
        }

        Coup coup = nodeToPlay.getInfo().getCoup();
        System.out.println("nodeToPlay (heuristic): " + nodeToPlay.getInfo().getValHeuristique());
        System.out.println("nodeMinMax (coup): " +
                Helper.coupToString(nodeMinMax.getInfo().getCoup()));
        return coup;
    }

    /**
     * Fonction pour créer la racine de l'arbre de type générique InfoMatricePlateau 
     * et appel la fonction récursive
     * @param matricePlateau: la matrice plateau
     * @param profondeur: la profondeur de l'arbre
     * @param color: la couleur qui joue
     * @return: l'arbre en question
     */
    public ArbreNaire<InfoMatricePlateau> buildArbre(Couleur[][] matricePlateau, int profondeur, Couleur color)
    {
        InfoMatricePlateau infoMatricePlateau =
                new InfoMatricePlateau(matricePlateau, this.getCouleur(), null);
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
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
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
                        new InfoMatricePlateau(tmpMatricePlateau, this.getCouleur(), coupPossible.get(i));
                arbre.addFils(infoMatricePlateau);
                arbre.goToFils(i);
                buildArbreRec2(arbre, profondeur - 1, Helper.getOppositeCouleur(color));
                arbre.goToPere();
            }
        }
        return arbre;
    }
}
