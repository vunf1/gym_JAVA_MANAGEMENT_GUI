/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

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
        instance.alertWAR(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertINFO method, of class Extras_Notifier.
     */
    @Test
    public void testAlertINFO() {
        System.out.println("alertINFO");
        String s = "";
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
     * Test of centerFrame method, of class Extras_Notifier.
     */
    @Test
    public void testCenterFrame() {
        System.out.println("centerFrame");
        Extras_Notifier instance = new Extras_Notifier();
        instance.centerFrame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
