/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tadarbrenaire;

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
     * Test of DISABLEDmain method, of class TestArbre.
     */
    @Test
    public void testDISABLEDmain()
    {
        System.out.println("DISABLEDmain");
        String[] args = null;
        TestArbre.DISABLEDmain(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DISABLEmain method, of class TestArbre.
     */
    @Test
    public void testDISABLEmain()
    {
        System.out.println("DISABLEmain");
        String[] args = null;
        TestArbre.DISABLEmain(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildArbreRec method, of class TestArbre.
     */
    @Test
    public void testBuildArbreRec()
    {
        System.out.println("buildArbreRec");
        ArbreNaire<Integer> arbre = null;
        int profondeur = 0;
        int largeur = 0;
        ArbreNaire expResult = null;
        ArbreNaire result = TestArbre.buildArbreRec(arbre, profondeur, largeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildArbreMaClasseRec method, of class TestArbre.
     */
    @Test
    public void testBuildArbreMaClasseRec()
    {
        System.out.println("buildArbreMaClasseRec");
        ArbreNaire<MaClasse> arbre = null;
        int profondeur = 0;
        int largeur = 0;
        ArbreNaire expResult = null;
        ArbreNaire result = TestArbre.buildArbreMaClasseRec(arbre, profondeur, largeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildArbre method, of class TestArbre.
     */
    @Test
    public void testBuildArbre()
    {
        System.out.println("buildArbre");
        int profondeur = 0;
        int largeur = 0;
        ArbreNaire expResult = null;
        ArbreNaire result = TestArbre.buildArbre(profondeur, largeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildArbreMaClasse method, of class TestArbre.
     */
    @Test
    public void testBuildArbreMaClasse()
    {
        System.out.println("buildArbreMaClasse");
        int profondeur = 0;
        int largeur = 0;
        ArbreNaire expResult = null;
        ArbreNaire result = TestArbre.buildArbreMaClasse(profondeur, largeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depthSearch method, of class TestArbre.
     */
    @Test
    public void testDepthSearch()
    {
        System.out.println("depthSearch");
        ArbreNaire<MaClasse> arbre = null;
        TestArbre.depthSearch(arbre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minMax method, of class TestArbre.
     */
    @Test
    public void testMinMax()
    {
        System.out.println("minMax");
        Noeud<MaClasse> noeud = null;
        float expResult = 0.0F;
        float result = TestArbre.minMax(noeud);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}