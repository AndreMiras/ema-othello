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
     * Test of max method, of class MinMax.
     */
    // @Test
    public void testMax()
    {
        System.out.println("max");
        ArrayList<Integer> tab = null;
        MinMax instance = new MinMax();
        Object expResult = null;
        Object result = instance.max(tab);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class MinMax.
     */
    // @Test
    public void testMin()
    {
        System.out.println("min");
        ArrayList<Integer> tab = null;
        MinMax instance = new MinMax();
        Object expResult = null;
        Object result = instance.min(tab);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minMax method, of class MinMax.
     */
    @Test
    public void testMinMax()
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