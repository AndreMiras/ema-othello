/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tadarbrenaire.ArbreNaire;
import tadarbrenaire.MinMax;
import tadarbrenaire.Noeud;

/**
 *
 * @author andre
 */
public class JoueurIntelligentPrudentIATest {

    public JoueurIntelligentPrudentIATest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }



    /**
     * Test of buildArbre method, of class JoueurIntelligentPrudentIA.
     */
    @Test
    public void testBuildArbre1()
    {
        System.out.println("buildArbre");
        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        int profondeur = 2;
        Plateau plateau = new Plateau();
        Couleur color = Couleur.BLANC;
        JoueurIntelligentPrudentIA instance =
                new JoueurIntelligentPrudentIA(color, plateau, 4);
        ArbreNaire expResult = null;
        ArbreNaire arbre = instance.buildArbre(matricePlateau, profondeur, color);

        Noeud<InfoMatricePlateau> nodeMinMax;
        MinMax<InfoMatricePlateau> minMaxInfoMatricePlateau =
                new MinMax<InfoMatricePlateau>();
        nodeMinMax = minMaxInfoMatricePlateau.minMaxNode(arbre.racine);


        assertNotNull(nodeMinMax);
    }

    /**
     * Test pour le ticket #19 MinMax bug on unexpected depth (empty child).
     */
    @Test
    public void testBuildArbre2()
    {
        System.out.println("buildArbre");
        Couleur[][] matricePlateau = {
            {Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC},
            {Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC},
            {Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC},
            {Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR},
            {Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.NOIR},
            {Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.VIDE, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR},
            {Couleur.VIDE, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        int profondeur = 2;
        Plateau plateau = new Plateau();
        Couleur color = Couleur.BLANC;
        JoueurIntelligentPrudentIA instance =
                new JoueurIntelligentPrudentIA(color, plateau, 4);
        ArbreNaire arbre = instance.buildArbre(matricePlateau, profondeur, color);

        Noeud<InfoMatricePlateau> nodeMinMax;
        MinMax<InfoMatricePlateau> minMaxInfoMatricePlateau =
                new MinMax<InfoMatricePlateau>();
        nodeMinMax = minMaxInfoMatricePlateau.minMaxNode(arbre.racine);

        assertNotNull(nodeMinMax);
    }

    /**
     * Test avec une profondeur de 4.
     */
    @Test
    public void testBuildArbre3()
    {
        System.out.println("buildArbre");
        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        int profondeur = 4;
        Plateau plateau = new Plateau();
        Couleur color = Couleur.BLANC;
        JoueurIntelligentPrudentIA instance =
                new JoueurIntelligentPrudentIA(color, plateau, 4);
        ArbreNaire arbre = instance.buildArbre(matricePlateau, profondeur, color);

        Noeud<InfoMatricePlateau> nodeMinMax;
        MinMax<InfoMatricePlateau> minMaxInfoMatricePlateau =
                new MinMax<InfoMatricePlateau>();
        nodeMinMax = minMaxInfoMatricePlateau.minMaxNode(arbre.racine);

        assertNotNull(nodeMinMax);
    }

}