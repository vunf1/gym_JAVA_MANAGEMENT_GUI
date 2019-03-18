/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import org.json.JSONArray;
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
public class HomeControllerIT {
    
    public HomeControllerIT() {
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
     * Test of main method, of class HomeController.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        HomeController.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class HomeController.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String data = "";
        int expResult = 0;
        int result = HomeController.checkUsername(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class HomeController.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        List<String> data = null;
        int expResult = 0;
        int result = HomeController.checkPassword(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerREQmember method, of class HomeController.
     */
    @Test
    public void testRegisterREQmember() {
        System.out.println("registerREQmember");
        List<String> data = null;
        int expResult = 0;
        int result = HomeController.registerREQmember(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getREMembersData method, of class HomeController.
     */
    @Test
    public void testGetREMembersData() {
        System.out.println("getREMembersData");
        JSONArray expResult = null;
        JSONArray result = HomeController.getREMembersData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delREQmember method, of class HomeController.
     */
    @Test
    public void testDelREQmember() {
        System.out.println("delREQmember");
        String id = "";
        int expResult = 0;
        int result = HomeController.delREQmember(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertNewMember method, of class HomeController.
     */
    @Test
    public void testInsertNewMember() {
        System.out.println("insertNewMember");
        List<String> data = null;
        int expResult = 0;
        int result = HomeController.insertNewMember(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logOut method, of class HomeController.
     */
    @Test
    public void testLogOut() {
        System.out.println("logOut");
        String data = "";
        HomeController.logOut(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callNextLogin method, of class HomeController.
     */
    @Test
    public void testCallNextLogin() {
        System.out.println("callNextLogin");
        String username = "";
        HomeController.callNextLogin(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMembership method, of class HomeController.
     */
    @Test
    public void testCheckMembership() {
        System.out.println("checkMembership");
        int expResult = 0;
        int result = HomeController.checkMembership();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
