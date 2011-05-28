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
     * Retourne vrai si les deux coups (lignes et colonnes sont egaux)
     * @param c1: coup 1
     * @param c2: coup 2
     * @return: vrai si les deux coups (lignes et colonnes sont egaux)
     */
    public boolean coupEqual(Coup c1, Coup c2)
    {
        return ((c1.getLigne() == c2.getLigne())
                && (c1.getColonne() == c2.getColonne()));
    }

    /**
     *
     * @param c1: le coup don't on veut tester l'appartenance a la liste de coups
     * @param coups: une liste de coups
     * @return: vrai si c1 appartient a la liste de  coups
     */
    public boolean coupIn(Coup c1, ArrayList<Coup> coups)
    {
        int i = 0;
        
        while(i<coups.size() && !coupEqual(c1, coups.get(i)))
        {
            i++;
        }
        return coupEqual(c1, coups.get(i));
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
    @Test
    public void testChercheCoupPossible()
    {
        System.out.println("chercheCoupPossible");

        Plateau plateau = new Plateau();
        Couleur couleur = Couleur.BLANC;

        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.BLANC, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };
        AbstractJoueur instance = new AbstractJoueur(couleur, plateau, TypeJoueur.HUMAIN)
         {

            @Override
            public Coup joue()
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        ArrayList coupsPossiblesExpResult = new ArrayList<Coup>();
        coupsPossiblesExpResult.add(new Coup(1,4));
        coupsPossiblesExpResult.add(new Coup(1,6));
        coupsPossiblesExpResult.add(new Coup(5,2));
        coupsPossiblesExpResult.add(new Coup(5,3));
        coupsPossiblesExpResult.add(new Coup(5,5));
        coupsPossiblesExpResult.add(new Coup(5,6));
        
        ArrayList<Coup> coupsPossiblesResult = instance.chercheCoupPossible(matricePlateau, couleur);
        assertEquals(coupsPossiblesExpResult.size(), coupsPossiblesResult.size());

        for(int i=0; i<coupsPossiblesResult.size(); i++)
        {
            assertTrue(coupIn(coupsPossiblesResult.get(i), coupsPossiblesExpResult));
        }
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
        Plateau plateau = new Plateau();
        Couleur couleur = Couleur.NOIR;
        Coup coup = new Coup(3, 2);
        
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
        AbstractJoueur instance = new AbstractJoueur(couleur, plateau, TypeJoueur.HUMAIN)
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
        int nbPionsRetournes = instance.retournerPions(matricePlateau, couleur, coup);
        
        assertArrayEquals(expResult, matricePlateau);
        assertEquals(1, nbPionsRetournes);        
    }
    
    /**
     * Test of retournerPions method, of class AbstractJoueur.
     */
    @Test
    public void testRetournerPions2()
    {
        System.out.println("retournerPions");
        Plateau plateau = new Plateau();
        Couleur couleur = Couleur.NOIR;
        Coup coup = new Coup(2, 3);
        
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
        AbstractJoueur instance = new AbstractJoueur(couleur, plateau, TypeJoueur.HUMAIN)
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
        
        int nbPionsRetournes = instance.retournerPions(matricePlateau, couleur, coup);

        assertArrayEquals(expResult, matricePlateau);
        assertEquals(2, nbPionsRetournes);
        
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
