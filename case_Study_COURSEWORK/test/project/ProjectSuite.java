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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author deoiveij
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({project.loginFrameTest.class, project.DataBase_mySQLTest.class, project.assets.AssetsSuite.class, project.Admin_FRAMETest.class, project.index_FRAMETest.class, project.DateTimerTest.class, project.HomeControllerTest.class, project.Extras_NotifierTest.class, project.EncryptClassTest.class})
public class ProjectSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
