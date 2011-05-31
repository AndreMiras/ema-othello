
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * JoueurMeilleurCoup1Test.java
 * Author : Miras Andre & Tomio Nicolas
 */
public class JoueurMeilleurCoup1Test {

    public JoueurMeilleurCoup1Test() {
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
     * Test of meilleurCoupImmediat method, of class JoueurMeilleurCoup1.
     */
    @Test
    public void testMeilleurCoupImmediat1()
    {
        System.out.println("meilleurCoupImmediat1");

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

        JoueurMeilleurCoup1 instance = new JoueurMeilleurCoup1(couleur, plateau);

        /*
         * Deux meilleur coup immediats sont en faite possible
         * mais la fonction ne retourne que le premier
         */
        ArrayList<Coup> expResult = new ArrayList<Coup>();
        expResult.add(new Coup(1,6));
        expResult.add(new Coup(5,4));

        Coup result = instance.meilleurCoupImmediat(matricePlateau, couleur);

        /*
         * Verifions que le coup retourne fait partie des deux meilleurs coups
         */
        assertTrue(Helper.coupIn(result, expResult));
    }

    /**
     * Test of meilleurCoupImmediat method, of class JoueurMeilleurCoup1.
     */
    @Test
    public void testMeilleurCoupImmediat2()
    {
        System.out.println("meilleurCoupImmediat2");

        Plateau plateau = new Plateau();
        Couleur couleur = Couleur.BLANC;

        Couleur[][] matricePlateau = {
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR},
            {Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.BLANC, Couleur.BLANC},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.VIDE, Couleur.BLANC},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.NOIR, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC, Couleur.VIDE, Couleur.NOIR},
            {Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.BLANC, Couleur.NOIR, Couleur.BLANC, Couleur.BLANC, Couleur.BLANC},
            {Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE},
            {Couleur.VIDE, Couleur.VIDE, Couleur.NOIR, Couleur.NOIR, Couleur.NOIR, Couleur.VIDE, Couleur.VIDE, Couleur.VIDE}
        };

        JoueurMeilleurCoup1 instance = new JoueurMeilleurCoup1(couleur, plateau);

        /*
         * Le meilleur coup devrait etre celui de la case 1,6 qui retourne 5 pions
         */
        Coup expResult = new Coup(1,0);

        Coup result = instance.meilleurCoupImmediat(matricePlateau, couleur);
        
        assertTrue(Helper.coupEqual(result, expResult));
    }

    /**
     * Test of joue method, of class JoueurMeilleurCoup1.
     */
    // @Test
    public void testJoue()
    {
        System.out.println("joue");
        JoueurMeilleurCoup1 instance = null;
        Coup expResult = null;
        Coup result = instance.joue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}