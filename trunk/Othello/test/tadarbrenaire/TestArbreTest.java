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
public class TestArbreTest {

    public TestArbreTest() {
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
     * Test of buildArbre method, of class TestArbre.
     */
    @Test
    public void testBuildArbre()
    {
        System.out.println("buildArbre");
        int profondeur = 2;
        int largeur = 3;
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArbreNaire arbre = TestArbre.buildArbre(profondeur, largeur);


        ArrayList<Integer> expResult = new ArrayList<Integer>();
        expResult.add(1);
        
        expResult.add(10);
        expResult.add(100);
        expResult.add(101);
        expResult.add(102);

        expResult.add(11);
        expResult.add(110);
        expResult.add(111);
        expResult.add(112);

        expResult.add(12);
        expResult.add(120);
        expResult.add(121);
        expResult.add(122);

        arbre.depthSearchToArrayList(values);
        assertEquals(expResult, values);
    }

    /**
     * Test of buildArbreMaClasse method, of class TestArbre.
     */
    @Test
    public void testBuildArbreMaClasse()
    {
        System.out.println("buildArbreMaClasse");
        int profondeur = 2;
        int largeur = 3;
        ArbreNaire arbre = TestArbre.buildArbreMaClasse(profondeur, largeur);
        assertTrue(arbre.getNbFils() == 3);
        assertTrue(arbre.isRacine());

        // going to the last child
        arbre.goToFils(0);
        arbre.goToFils(0);
        assertTrue(arbre.vue.isNoeudFeuille());
    }
}