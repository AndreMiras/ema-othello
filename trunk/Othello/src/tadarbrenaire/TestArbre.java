/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbrenaire;

import java.util.ArrayList;

public class TestArbre
{

    /**
     * @param args the command line arguments
     */
    public static void DISABLEDmain(String[] args)
    {
        System.out.println("test arbre");

        ArbreNaire<Integer> a;
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        
        a = buildArbre(3, 2);
        a.goToRacine();
        a.depthSearchToArrayList(nodeList);

        System.out.println("Fin");
    }

    public static void DISABLEmain(String[] args)
    {
        System.out.println("test arbre");

        ArbreNaire<MaClasse> a;
        MinMax<MaClasse> minMax = new MinMax<MaClasse>();
        ArrayList<MaClasse> nodeList = new ArrayList<MaClasse>();
        
        a = buildArbreMaClasse(2, 3);
        a.goToRacine();
        a.depthSearchToArrayList(nodeList);

        a.goToRacine();
        //Noeud<MaClasse> node = minMax(a.racine);
        MaClasse test = minMax.minMax(a.racine);
        //System.out.println("La valeur ident : " + node.getInfo().getIdent());
        System.out.println("La valeur heuristique : " + test.getValHeuristique());
        System.out.println("Fin");
    }

    //Fonction récursive pour créer un arbre de type entier
    private static ArbreNaire buildArbreRec(ArbreNaire<Integer> arbre, int profondeur, int largeur)
    {
        Integer tmpInteger;

        if (profondeur == 1)
        {
            for (int i = 0; i < largeur; i++)
            {
                tmpInteger = arbre.vue.getInfo() * 10;
                tmpInteger += i;
                arbre.addFils(tmpInteger);
            }
        } else
        {
            for (int i = 0; i < largeur; i++)
            {
                tmpInteger = arbre.vue.getInfo() * 10;
                tmpInteger += i;
                arbre.addFils(tmpInteger);
                arbre.goToFils(i);
                buildArbreRec(arbre, profondeur - 1, largeur);
                arbre.goToPere();
            }
        }
        return arbre;
    }

    //Fonction récursive pour créer un arbre de type ma classe
    private static ArbreNaire buildArbreMaClasseRec(ArbreNaire<MaClasse> arbre, int profondeur, int largeur)
    {
        Integer tmpInteger;
        MaClasse tmpMaClasse;

        /* Feuille */
        if (profondeur == 1)
        {
            for (int i = 0; i < largeur; i++)
            {
                tmpInteger = arbre.vue.getInfo().getIdent() * 10;
                tmpInteger += i;
                tmpMaClasse = new MaClasse(tmpInteger);
                tmpMaClasse.setValRandomHeuristique();
                arbre.addFils(tmpMaClasse);
            }
        } else
        {
            for (int i = 0; i < largeur; i++)
            {
                tmpInteger = arbre.vue.getInfo().getIdent() * 10;
                tmpInteger += i;
                tmpMaClasse = new MaClasse(tmpInteger);
                arbre.addFils(tmpMaClasse);
                arbre.goToFils(i);
                buildArbreMaClasseRec(arbre, profondeur - 1, largeur);
                arbre.goToPere();
            }
        }
        return arbre;
    }

    //Fonction pour créer la racine de l'arbre int et appel la fonction récursive
    public static ArbreNaire buildArbre(int profondeur, int largeur)
    {
        Integer filsValue = 1;
        ArbreNaire<Integer> a = new ArbreNaire<Integer>(filsValue);
        a = buildArbreRec(a, profondeur, largeur);
        return a;
    }

    //Fonction pour créer la racine de l'arbre maClasse et appel la fonction récursive
    public static ArbreNaire buildArbreMaClasse(int profondeur, int largeur)
    {
        Integer filsValue = 1;
        MaClasse maClasse = new MaClasse(filsValue);

        ArbreNaire<MaClasse> a = new ArbreNaire<MaClasse>(maClasse);
        a = buildArbreMaClasseRec(a, profondeur, largeur);
        return a;
    }
}
