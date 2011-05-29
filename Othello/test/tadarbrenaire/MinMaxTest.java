/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tadarbrenaire;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class MinMaxTest {

    public MinMaxTest() {
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
     * Test of minMax method, of class MinMax with Integer as generic type.
     */
    @Test
    public void testMinMax1()
    {
        System.out.println("minMax");

        int result;
        int expResult = 120;

        int profondeur = 2;
        int largeur = 3;

        ArbreNaire arbre = TestArbre.buildArbre(profondeur, largeur);
        MinMax<Integer> minMaxInteger = new MinMax<Integer>();

        result = minMaxInteger.minMax(arbre.racine);
        assertEquals(expResult, result);
    }


    /**
     * Test of minMax method, of class TestArbre with MaClasse as generic type.
     */
    @Test
    public void testMinMax2()
    {
        System.out.println("minMax");

        Noeud<MaClasse> resultNode;
        ArbreNaire<MaClasse> arbre;
        MinMax<MaClasse> minMaxMaClasse;

        arbre = TestArbre.buildArbreMaClasse(2, 3);

        minMaxMaClasse = new MinMax<MaClasse>();
        resultNode = minMaxMaClasse.minMaxNode(arbre.racine);

        /*
         * Le noeud remonte devrait etre un noeud feuille
         */
        assertTrue(resultNode.isNoeudFeuille());
    }

    /**
     * Test of minMaxNode method, of class MinMax.
     */
    @Test
    public void testMinMaxNode()
    {
        System.out.println("minMaxNode");

        Noeud<Integer> result;
        Integer expResult = 120;

        int profondeur = 2;
        int largeur = 3;

        ArbreNaire arbre = TestArbre.buildArbre(profondeur, largeur);
        MinMax<Integer> minMaxInteger = new MinMax<Integer>();

        result = minMaxInteger.minMaxNode(arbre.racine);
        assertEquals(expResult, result.getInfo());
    }

}