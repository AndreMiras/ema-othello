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
 * @author Nicolas
 */
public class HelperTest {

    public HelperTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of coupEqual method, of class Helper.
     */
    @Test
    public void testCoupEqual() {
        System.out.println("coupEqual");
        Coup c1 = new Coup(3,2);
        Coup c2 = new Coup (4,5);
        boolean expResult = false;
        boolean result = Helper.coupEqual(c1, c2);
        assertEquals(expResult, result);

    }

    /**
     * Test of coupIn method, of class Helper.
     */
    @Test
    public void testCoupIn() {
        System.out.println("coupIn");
        Coup c1 = new Coup(3,2);
        ArrayList<Coup> coups =  new ArrayList<Coup>();
        coups.add(new Coup(4,5));
        coups.add(new Coup(7,8));
        boolean expResult = false;
        boolean result = Helper.coupIn(c1, coups);
        assertEquals(expResult, result);
    }

}