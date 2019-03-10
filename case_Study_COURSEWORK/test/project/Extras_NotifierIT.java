/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author foxst
 */
public class Extras_NotifierIT {
    
    public Extras_NotifierIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of alertWAR method, of class Extras_Notifier.
     */
    @Test
    public void testAlertWAR() {
        System.out.println("alertWAR");
        String s = "";
        Extras_Notifier instance = new Extras_Notifier();
        instance.alertWARR(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertINFO method, of class Extras_Notifier.
     */
    @Test
    public void testAlertINFO() {
        System.out.println("alertINFO");
        String s = "The test case is a prototype.";
        Extras_Notifier instance = new Extras_Notifier();
        instance.alertINFO(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertERROR method, of class Extras_Notifier.
     */
    @Test
    public void testAlertERROR() {
        System.out.println("alertERROR");
        String s = "";
        Extras_Notifier instance = new Extras_Notifier();
        instance.alertERROR(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertWARR method, of class Extras_Notifier.
     */
    @Test
    public void testAlertWARR() {
        System.out.println("alertWARR");
        String s = "";
        Extras_Notifier instance = new Extras_Notifier();
        instance.alertWARR(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class Extras_Notifier.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        List<String> data = null;
        Extras_Notifier instance = new Extras_Notifier();
        instance.checkLogin(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class Extras_Notifier.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String data = "";
        Extras_Notifier instance = new Extras_Notifier();
        int expResult = 0;
        int result = instance.checkUsername(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerMember method, of class Extras_Notifier.
     */
    @Test
    public void testRegisterMember() {
        System.out.println("registerMember");
        List<String> data = null;
        Extras_Notifier instance = new Extras_Notifier();
        int expResult = 0;
        int result = instance.registerMember(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
