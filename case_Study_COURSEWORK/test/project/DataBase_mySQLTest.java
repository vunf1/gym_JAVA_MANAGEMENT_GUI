/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
/**
 *
 * @author deoiveij
 * 
 * Source: 
 *      https://www.mkyong.com/unittest/junit-run-test-in-a-particular-order/
 *      https://stackoverflow.com/a/10660606 - Lists
 *      https://stackoverflow.com/a/5762502 - Colors
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBase_mySQLTest {
    public static final String _RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    public DataBase_mySQLTest() {
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
     * Test of getALLData_Request method, of class DataBase_mySQL.
     */
    @Test
    public void testGetALLData_Request() {//DONE
        System.out.print("getALLData_Request - NotNull");
        JSONArray result = DataBase_mySQL.getALLData_Request();
        assertNotNull(result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of getALLData_ method, of class DataBase_mySQL.
     */
    @Test
    public void testGetALLData_() {//DONE
        System.out.print("getALLData_Members - NotNull ");
        JSONArray result = DataBase_mySQL.getALLData_();
        assertNotNull(result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
    }

    /**
     * Test of getUserData_ method, of class DataBase_mySQL.
     * DONE - NotNull
     */
    @Test
    public void testGetUserData_() {//DONE - NotNull
        System.out.print("getUserData_ - Exist");
        String username = "qw";
        JSONArray result = DataBase_mySQL.getUserData_(username);
        assertNotNull(result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }
    /**
     * Test of getUserData_NotFound method, of class DataBase_mySQL.
     * DONE - Null(empty)
     */
    @Test
    public void testGetUserData_NotFound() {//DONE - Null(empty)
        System.out.print("getUserData_ NotFound (empty)");
        String username = "randomnametoTestiT";
        JSONArray  expResult=new JSONArray();
        JSONArray result = DataBase_mySQL.getUserData_(username);
        
        assertEquals(expResult.isEmpty(),result.isEmpty());
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of checkUsername method, of class DataBase_mySQL.
     * Done
     */
    @Test
    public void testCheckUsername() {//Done
        System.out.print("checkUsername - If exists");
        String username = "qw";
        int expResult = 1;
        int result = DataBase_mySQL.checkUsername(username);
        assertEquals(expResult,result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
    }

    /**
     * Test of checkUsername method, of class DataBase_mySQL.
     * Done
     */
    @Test
    public void testCheckUsername_notInDB() {//Done
        System.out.print("checkUsername - If not exists");
        String username = "somethingaboutthisiscorrect";
        int expResult = 0;
        int result = DataBase_mySQL.checkUsername(username);
        assertEquals(expResult,result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
    }

    /**
     * Test of checkAdmin method, of class DataBase_mySQL.
     * Done
     */
    @Test
    public void testCheckAdmin_manager() {//Done
        System.out.print("checkAdmin- Club Manager");
        String username = "qw";
        int expResult = 2;
        int result = DataBase_mySQL.checkAdmin(username);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of checkAdmin method, of class DataBase_mySQL.
     * Done
     */
    @Test
    public void testCheckAdmin_advisor() {//Done
        System.out.print("checkAdmin- Club Advisor");
        String username = "joao";
        int expResult = 1;
        int result = DataBase_mySQL.checkAdmin(username);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of checkAdmin method, of class DataBase_mySQL.
     * Done
     * -
     */
    @Test
    public void testCheckAdmin_member() {//Done
        System.out.print("checkAdmin- Club Member ");
        String username = "james";
        int expResult = 0;
        int result = DataBase_mySQL.checkAdmin(username);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of checkPassword method, of class DataBase_mySQL.
     * Done
     * 
     */
    @Test
    public void testCheckPassword() {//Done
        System.out.print("checkPassword - Exist");
        List<String> data=Arrays.asList("qw",EncryptClass.setPassword2Hash("22222222"));
        
        int expResult = 1;
        int result = DataBase_mySQL.checkPassword(data);
        assertEquals(expResult ,result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of registerREQmember method, of class DataBase_mySQL.
     * NOT DONE
     * Insert new Data from new member - after register
     */
    
    public void testRegisterREQmember() {//NOT DONE
        System.out.println("registerREQmember");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.registerREQmember(data);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of inserREQintoMembers method, of class DataBase_mySQL.
     * NOT DONE
     * Insert memberRequest Data into Member
     */
    
    public void testInserREQintoMembers() {//NOT DONE
        System.out.println("inserREQintoMembers");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.inserREQintoMembers(data);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteRequestROW method, of class DataBase_mySQL.
     * NOT DONE
     * Delete member Request
     */
    
    public void testDeleteRequestROW() {//NOT DONE
        System.out.println("deleteRequestROW");
        String idMember = "";
        int expResult = 0;
        int result = DataBase_mySQL.deleteRequestROW(idMember);
        /*MEMBER ID GENERATED AUTOMATICALY*/
    }

    /**
     * Test of modifyMember method, of class DataBase_mySQL.
     * NOT DONE
     * Admin Frame modify Member
     */
    
    public void testModifyMember() {//NOT DONE
        System.out.println("modifyMember");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.modifyMember(data);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteMemberROW method, of class DataBase_mySQL.
     * NOT DONE
     * Delete member
     */
    
    public void testDeleteMemberROW() {//NOT DONE
        System.out.println("deleteMemberROW");
        String idMember = "";
        int expResult = 0;
        int result = DataBase_mySQL.deleteMemberROW(idMember);
        /*THINK */
    }

    /**
     * Test of setUserDataUpdate method, of class DataBase_mySQL.
     * NOT DONE 
     * MemberFrame Update Data
     */
    
    public void testSetUserDataUpdate() {//NOT DONE
        System.out.println("setUserDataUpdate");
        List<String> data = null;
        int expResult = 0;
        int result = DataBase_mySQL.setUserDataUpdate(data);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of revokeUser method, of class DataBase_mySQL.
     * NOT DONE
     * date is the actual date from Date_Timer class
     */
    
    public void testRevokeUser() {//NOT DONE
        System.out.println("revokeUser");
        String username = "";
        String date = "";
        int expResult = 0;
        int result = DataBase_mySQL.revokeUser(username, date);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of addBookClass method, of class DataBase_mySQL.
     * NOT DONE
     * value is the actual value from the user on Booking collumn +1
     */
    
    public void testAddBookClass() {//NOT DONE
        System.out.println("addBookClass");
        String username = "";
        String value = "";
        int expResult = 1;
        int result = DataBase_mySQL.addBookClass(username, value);
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of setMembership method, of class DataBase_mySQL.
     * Done but Overwrite actual DATA
     */
    
    public void testSetMembership() {
        System.out.print("setMembership");
        String username = "qw";
        String membership = "silver";
        int expResult = 1;
        int result = DataBase_mySQL.setMembership(username, membership);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }
    
}
