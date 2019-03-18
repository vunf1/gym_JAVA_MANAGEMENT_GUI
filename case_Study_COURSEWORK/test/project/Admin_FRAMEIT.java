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
public class Admin_FRAMEIT {
    
    public Admin_FRAMEIT() {
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
     * Test of displayUser method, of class Admin_FRAME.
     */
    @Test
    public void testDisplayUser() {
        System.out.println("displayUser");
        Admin_FRAME instance = new Admin_FRAME();
        instance.displayUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Admin_FRAME.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Admin_FRAME.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
