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
     * Test of DISABLEDmain method, of class TestArbre.
     */
    // @Test
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
    // @Test
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
    // @Test
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
    // @Test
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

        TestArbre.depthSearchToArrayList2(arbre, values);
        assertEquals(expResult, values);
    }

    /**
     * Test of buildArbreMaClasse method, of class TestArbre.
     */
    // @Test
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
     * Test of minMax method, of class TestArbre.
     */
    // @Test
    public void testMinMax()
    {
        System.out.println("minMax");

        float result;
        float expResult = 0.0F;
        ArbreNaire<MaClasse> arbre;
        arbre = TestArbre.buildArbreMaClasse(2, 3);
        
        result = TestArbre.minMax(arbre.racine);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMinMax2()
    {
        System.out.println("minMax");

        int result;
        int expResult = 120;

        int profondeur = 2;
        int largeur = 3;
        
        ArbreNaire arbre = TestArbre.buildArbre(profondeur, largeur);
        MinMax<Integer> minMaxInteger = new MinMax<Integer>();

        result = minMaxInteger.minMax2(arbre.racine);
        assertEquals(expResult, result);
    }

}