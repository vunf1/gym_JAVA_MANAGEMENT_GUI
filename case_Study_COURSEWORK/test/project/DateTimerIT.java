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
 * @author deoiveij
 */
public class DateTimerIT {
    
    public DateTimerIT() {
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
     * Test of run method, of class DateTimer.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        DateTimer instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRunning method, of class DateTimer.
     */
    @Test
    public void testSetRunning() {
        System.out.println("setRunning");
        boolean isRunning = false;
        DateTimer instance = null;
        instance.setRunning(isRunning);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitProcedure method, of class DateTimer.
     */
    @Test
    public void testExitProcedure() {
        System.out.println("exitProcedure");
        DateTimer instance = null;
        instance.exitProcedure();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
