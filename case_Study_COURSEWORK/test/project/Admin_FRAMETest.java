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
public class Admin_FRAMETest {
    
    public Admin_FRAMETest() {
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
     * Test of ImageIconSetup method, of class Admin_FRAME.
     */
    @Test
    public void testImageIconSetup() {
        System.out.println("ImageIconSetup");
        int option = 0;
        Admin_FRAME instance = new Admin_FRAME();
        instance.ImageIconSetup(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of noOnAdvisor method, of class Admin_FRAME.
     */
    @Test
    public void testNoOnAdvisor() {
        System.out.println("noOnAdvisor");
        int op = 0;
        Admin_FRAME instance = new Admin_FRAME();
        instance.noOnAdvisor(op);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
