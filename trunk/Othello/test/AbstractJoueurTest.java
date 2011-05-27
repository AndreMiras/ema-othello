/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ntomio
 */
public class AbstractJoueurTest
{
    
    public AbstractJoueurTest()
    {
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
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of joue method, of class AbstractJoueur.
     */
    // @Test
    public void testJoue()
    {
        System.out.println("joue");
        AbstractJoueur instance = null;
        Coup expResult = null;
        Coup result = instance.joue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chercheCoupPossible method, of class AbstractJoueur.
     */
    // @Test
    public void testChercheCoupPossible()
    {
        System.out.println("chercheCoupPossible");
        Couleur[][] matricePlateau = null;
        Couleur couleur = null;
        AbstractJoueur instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.chercheCoupPossible(matricePlateau, couleur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copieTableau method, of class AbstractJoueur.
     */
    // @Test
    public void testCopieTableau()
    {
        System.out.println("copieTableau");
        Plateau plateau = null;
        AbstractJoueur instance = null;
        Couleur[][] expResult = null;
        Couleur[][] result = instance.copieTableau(plateau);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retournerPions method, of class AbstractJoueur.
     */
    @Test
    public void testRetournerPions1()
    {
        System.out.println("retournerPions");
        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        Couleur couleur = Couleur.NOIR;
        Coup coup = new Coup(3, 2);
        AbstractJoueur instance = new AbstractJoueur(couleur, null, TypeJoueur.HUMAIN)
         {

            @Override
            public Coup joue()
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        Couleur[][] expResult = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        Couleur[][] result = instance.retournerPions(matricePlateau, couleur, coup);
        
        assertArrayEquals(expResult, result);
        
        /*
        for(int i=0; i<matricePlateau.length; i++)
        {
            assertArrayEquals(expResult[i], result[i]);
        }
         * 
         */
        
    }
    
    /**
     * Test of retournerPions method, of class AbstractJoueur.
     */
    @Test
    public void testRetournerPions2()
    {
        System.out.println("retournerPions");
        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        Couleur couleur = Couleur.NOIR;
        Coup coup = new Coup(2, 3);
        AbstractJoueur instance = new AbstractJoueur(couleur, null, TypeJoueur.HUMAIN)
         {

            @Override
            public Coup joue()
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        Couleur[][] expResult = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        Couleur[][] result = instance.retournerPions(matricePlateau, couleur, coup);
        
        assertArrayEquals(expResult, result);
        
        /*
        for(int i=0; i<matricePlateau.length; i++)
        {
            assertArrayEquals(expResult[i], result[i]);
        }
         * 
         */
        
    }

    /**
     * Test of getType method, of class AbstractJoueur.
     */
    // @Test
    public void testGetType()
    {
        System.out.println("getType");
        AbstractJoueur instance = null;
        TypeJoueur expResult = null;
        TypeJoueur result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCouleur method, of class AbstractJoueur.
     */
    // @Test
    public void testGetCouleur()
    {
        System.out.println("getCouleur");
        AbstractJoueur instance = null;
        Couleur expResult = null;
        Couleur result = instance.getCouleur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlateau method, of class AbstractJoueur.
     */
    // @Test
    public void testGetPlateau()
    {
        System.out.println("getPlateau");
        AbstractJoueur instance = null;
        Plateau expResult = null;
        Plateau result = instance.getPlateau();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractJoueurImpl extends AbstractJoueur
    {

        public AbstractJoueurImpl()
        {
            super(null, null, null);
        }

        public Coup joue()
        {
            return null;
        }
    }
}
