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

import static org.hamcrest.CoreMatchers.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
/**
 *
 * @author deoiveij
 * Source: 
 *      https://www.mkyong.com/unittest/junit-run-test-in-a-particular-order/
 *      https://stackoverflow.com/a/5762502 - Colors
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EncryptClassTest {
    
    public static final String _RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public EncryptClassTest() {
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
     * Test of setPassword2Hash method, of class EncryptClass.
     */
    @Test
    public void testSetPassword2Hash() {
        System.out.print("setPassword2Hash");
        String password = "tesTencryption";
        String expResult = "BAFAE753CC0E35F04914BB0934D26072";
        String result = EncryptClass.setPassword2Hash(password);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }

    /**
     * Test of getPlainText method, of class EncryptClass.
     */
    @Test
    public void testGetPlainText() {
        System.out.print("getPlainTextfromHash");
        String encrypPW = "BAFAE753CC0E35F04914BB0934D26072";
        String expResult = "tesTencryption";
        String result = EncryptClass.getPlainText(encrypPW);
        assertEquals(expResult, result);
        System.out.print(GREEN+"\t**Test Passed**"+_RESET);
        System.out.println();
        
    }
    
}
