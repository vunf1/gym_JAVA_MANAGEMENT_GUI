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
 * @author foxst
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({project.index_FRAMEIT.class, project.DataBase_mySQLIT.class, project.loginFrameIT.class, project.Admin_FRAMEIT.class, project.HomeControllerIT.class, project.Extras_NotifierIT.class})
public class ProjectITSuite {

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