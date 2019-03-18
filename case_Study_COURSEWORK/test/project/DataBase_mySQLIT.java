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
public class DataBase_mySQLIT {
    
    public DataBase_mySQLIT() {
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
     * Test of main method, of class DataBase_mySQL.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DataBase_mySQL.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getALLData_Request method, of class DataBase_mySQL.
     */
    @Test
    public void testGetALLData_Request() {
        System.out.println("getALLData_Request");
        JSONArray expResult = null;
        JSONArray result = DataBase_mySQL.getALLData_Request();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getALLData_ method, of class DataBase_mySQL.
     */
    @Test
    public void testGetALLData_() {
        System.out.println("getALLData_");
        JSONArray expResult = null;
        JSONArray result = DataBase_mySQL.getALLData_();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class DataBase_mySQL.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "";
        int expResult = 0;
        int result = DataBase_mySQL.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAdmin method, of class DataBase_mySQL.
     */
    @Test
    public void testCheckAdmin() {
        System.out.println("checkAdmin");
        String username = "";
        int expResult = 0;
        int result = DataBase_mySQL.checkAdmin(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class DataBase_mySQL.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.checkPassword(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerREQmember method, of class DataBase_mySQL.
     */
    @Test
    public void testRegisterREQmember() {
        System.out.println("registerREQmember");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.registerREQmember(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserREQintoMembers method, of class DataBase_mySQL.
     */
    @Test
    public void testInserREQintoMembers() {
        System.out.println("inserREQintoMembers");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.inserREQintoMembers(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRequestROW method, of class DataBase_mySQL.
     */
    @Test
    public void testDeleteRequestROW() {
        System.out.println("deleteRequestROW");
        String idMember = "";
        int expResult = 0;
        int result = DataBase_mySQL.deleteRequestROW(idMember);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
