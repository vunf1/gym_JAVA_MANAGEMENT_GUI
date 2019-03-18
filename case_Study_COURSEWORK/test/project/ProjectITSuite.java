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
@Suite.SuiteClasses({project.loginFrameIT.class, project.DataBase_mySQLIT.class, project.assets.AssetsITSuite.class, project.Admin_FRAMEIT.class, project.index_FRAMEIT.class, project.DateTimerIT.class, project.HomeControllerIT.class, project.Extras_NotifierIT.class, project.EncryptClassIT.class})
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
