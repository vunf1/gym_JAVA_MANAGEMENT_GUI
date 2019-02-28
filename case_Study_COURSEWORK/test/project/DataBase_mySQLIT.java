/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.google.gson.JsonArray;
import java.util.ArrayList;
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
     * Test of getMemberData_Request method, of class DataBase_mySQL.
     */
    @Test
    public void testGetMemberData_Request() {
        System.out.println("getMemberData_Request");
        String username = "";
        ArrayList expResult = null;
        ArrayList result = DataBase_mySQL.getMemberData_Request(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getALLData_Request method, of class DataBase_mySQL.
     */
    @Test
    public void testGetALLData_Request() {
        System.out.println("getALLData_Request");
        JsonArray expResult = null;
        JsonArray result = DataBase_mySQL.getALLData_Request();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewMemberREQUEST method, of class DataBase_mySQL.
     */
    @Test
    public void testSetNewMemberREQUEST() {
        System.out.println("setNewMemberREQUEST");
        ArrayList data = null;
        boolean expResult = false;
        boolean result = DataBase_mySQL.setNewMemberREQUEST(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
