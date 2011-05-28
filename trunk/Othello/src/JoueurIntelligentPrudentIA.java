
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
                chercheCoupPossible(this.getPlateau().getMatricePlateau(), this.getCouleur());

        // for tests
        buildArbreMaClasse(2, 3);

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
     * TODO: remove the largeur parameter
     */
    public ArbreNaire buildArbreMaClasse(int profondeur, int largeur)
    {
        // TODO: init plateau with the correct plateau
        // Plateau testPlateau = this.getPlateau(); // = new Plateau();

        /*
         * Initialisation de la matrice plateau (avec les 4 pions de depart)
         */
        Couleur[][] matricePlateau = this.getPlateau().getMatricePlateau();
        // MaClassePlateau maClasse = new MaClassePlateau(testPlateau);

        // ArbreNaire<MaClassePlateau> a = new ArbreNaire<MaClassePlateau>(maClasse);

        MaClasseMatricePlateau maClasse = new MaClasseMatricePlateau(matricePlateau);
        ArbreNaire<MaClasseMatricePlateau> a = new ArbreNaire<MaClasseMatricePlateau>(maClasse);

        
        a = buildArbreMaClasseRec2(a, profondeur, largeur);
        return a;
    }


    /*
     * Creation de l'arbre en utilisant les fonction de retournement de pion custom
     */
    public ArbreNaire buildArbreMaClasseRec2(ArbreNaire<MaClasseMatricePlateau> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;
        MaClasseMatricePlateau tmpMaClasse;

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
               tmpMaClasse = new MaClasseMatricePlateau(matricePlateau);
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


    /*
     * Creation de l'arbre en utilisant la fonction de retournement de pion fournie
     * TODO: finish up
     * should this be static?
     * TODO: ability of creating a new plateau copy from a given one
     */
     public ArbreNaire buildArbreMaClasseRec(ArbreNaire<MaClassePlateau> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;
        MaClassePlateau tmpMaClasse;

        Plateau testPlateau = new Plateau();
        ArrayList<Coup> coupPossible =
                chercheCoupPossible(arbre.getItem().getPlateau().getMatricePlateau(), this.getCouleur());
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
               tmpMaClasse = new MaClassePlateau(testPlateau);
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
