/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbrenaire;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArbre
{

    /**
     * @param args the command line arguments
     */
    public static void DISABLEDmain(String[] args)
    {
        System.out.println("test arbre");

        ArbreNaire<Integer> a;
        a = buildArbre(3, 2);
        a.goToRacine();
        // depthSearch(a);

        System.out.println("Fin");
    }

    public static void DISABLEmain(String[] args)
    {
        System.out.println("test arbre");

        ArbreNaire<MaClasse> a;
        a = buildArbreMaClasse(2, 3);
        a.goToRacine();
        depthSearch(a);

        a.goToRacine();
        //Noeud<MaClasse> node = minMax(a.racine);
        float test = minMax(a.racine);
        //System.out.println("La valeur ident : " + node.getInfo().getIdent());
        System.out.println("La valeur heuristique : " + test);

        System.out.println("Fin");
    }

    //Fonction récursive pour créer un arbre de type entier
    public static ArbreNaire buildArbreRec(ArbreNaire<Integer> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;

        if (profondeur == 1)
        {
            for(int i = 0; i < largeur; i ++)
           {
               tmpInteger = arbre.vue.getInfo() * 10;
               tmpInteger += i;
               arbre.addFils(tmpInteger);
           }
        }
        else
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
    public static ArbreNaire buildArbreMaClasseRec(ArbreNaire<MaClasse> arbre, int profondeur, int largeur)
    {
        Double tmpDouble;
        Integer tmpInteger;
        MaClasse tmpMaClasse;

        /* Feuille */
        if (profondeur == 1)
        {
            for(int i = 0; i < largeur; i ++)
           {
               tmpInteger = arbre.vue.getInfo().getIdent() * 10;
               tmpInteger += i;
               tmpMaClasse = new MaClasse(tmpInteger);
               tmpMaClasse.setValRandomHeuristique();
               arbre.addFils(tmpMaClasse);
           }
        }
        else
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

    //Fonction pour afficher les valeurs des noeuds visités
    public static void depthSearch(ArbreNaire<MaClasse> arbre)
    {
        System.out.print(arbre.vue.getInfo() + "-");
        System.out.println(arbre.vue.getInfo().getValHeuristique());

        if(!arbre.isNoeudFeuille())
        {
            for(int i=0; i < arbre.getNbFils(); i++)
            {
                arbre.goToFils(i);
                depthSearch(arbre);
                arbre.goToPere();
            }
        }
    }

    public static void depthSearchToArrayList(ArbreNaire<MaClasse> arbre, ArrayList<MaClasse> list)
    {
        // System.out.print(arbre.vue.getInfo() + "-");
        // System.out.println(arbre.vue.getInfo().getValHeuristique());
        list.add(arbre.vue.getInfo());

        if(!arbre.isNoeudFeuille())
        {
            for(int i=0; i < arbre.getNbFils(); i++)
            {
                arbre.goToFils(i);
                depthSearchToArrayList(arbre, list);
                arbre.goToPere();
            }
        }
    }

    public static void depthSearchToArrayList2(ArbreNaire<Integer> arbre, ArrayList<Integer> list)
    {
        // System.out.print(arbre.vue.getInfo() + "-");
        // System.out.println(arbre.vue.getInfo().getValHeuristique());
        list.add(arbre.vue.getInfo());

        if(!arbre.isNoeudFeuille())
        {
            for(int i=0; i < arbre.getNbFils(); i++)
            {
                arbre.goToFils(i);
                depthSearchToArrayList2(arbre, list);
                arbre.goToPere();
            }
        }
    }

    public static float maxIndex(float[] tabFloat)
    {
        Arrays.sort(tabFloat);
        return tabFloat[tabFloat.length-1];
    }

    public static float max(float[] tabFloat)
    {
        Arrays.sort(tabFloat);
        return tabFloat[tabFloat.length-1];
    }

    public static float min(float[] tabFloat)
    {
        Arrays.sort(tabFloat);
        return tabFloat[0];
    }
    

    public static float valmax(Noeud<MaClasse> noeud)
    {
        float valeurLocale;
        
        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo().getValHeuristique();
        }
        else
        {
             float tabFloat[] = new float[noeud.getFils().size()];
             for (int i=0; i <= noeud.getFils().size(); i++)
            {
                 tabFloat[i] = valmin(noeud.getFils().get(i));
             }
             valeurLocale = max(tabFloat);
        }
        return valeurLocale;
    }

    public static float valmin(Noeud<MaClasse> noeud)
    {
        float valeurLocale;

        if (noeud.isNoeudFeuille())
        {
            valeurLocale = noeud.getInfo().getValHeuristique();
            
        }
        else
        {
             float tabFloat[] = new float[noeud.getFils().size()];
             for (int i=0; i < noeud.getFils().size(); i++)
            {
                 tabFloat[i] = valmax(noeud.getFils().get(i));
             }
             valeurLocale = min(tabFloat);
        }
        return valeurLocale;
    }

    //Finir la fonction pour retourner un noeud.
    //public static Noeud minMax(Noeud<MaClasse> noeud)
    public static float minMax(Noeud<MaClasse> noeud)
    {
        Noeud localNoeud = new Noeud();
        Noeud tmpNoeud;
        float valeurLocale;
        float tabFloat[] = new float[noeud.getFils().size()];
        

        for (int i=0; i < noeud.getFils().size(); i++)
        {
            tabFloat[i] = valmin(noeud.getFils().get(i));
            
        }

        valeurLocale = max(tabFloat);
       
        return valeurLocale;

        //return localNoeud;
    }

}
