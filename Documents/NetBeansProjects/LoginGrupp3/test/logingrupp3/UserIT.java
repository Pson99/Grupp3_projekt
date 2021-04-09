/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingrupp3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bax Musik
 */
public class UserIT {
    
    public UserIT() {
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
     * Test of ValidateUserID method, of class User.
     */
    @Test
    public void testValidateUserID() {
        System.out.println("ValidateUserID");
        //Check empty and space in userID
        assertFalse(new User(null , null).ValidateUserID());
        assertFalse(new User("", null).ValidateUserID());
        assertFalse(new User(" " , null).ValidateUserID());
        assertFalse(new User("rf 20", null).ValidateUserID());
        assertFalse(new User("rf20testinglonguseridwith space", null).ValidateUserID());
        //Check size, not possible to test trim() method as it's an manual input trim
        assertFalse(new User("rf2", null).ValidateUserID());
        //Check special character in long otherwise correct userID
        assertFalse(new User("rf20testingwithlonguser#id", null).ValidateUserID());
        //Check with only numbers or letters
        assertFalse(new User("1234567890", null).ValidateUserID());
        assertFalse(new User("abcdefghij", null).ValidateUserID());
        //Correct userID
        assertTrue(new User("rf20", null).ValidateUserID());
        //Correct userID with swedish letters, not possible to try manual input here
        assertTrue(new User("åäö20", null).ValidateUserID());
        //Correct userID checked by JUnit preprogrammed assert
        User instance = new User("RichardFehling2021", null);
        boolean expResult = true;
        boolean result = instance.ValidateUserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of ValidatePassword method, of class User.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("ValidatePassword");
        assertTrue("Felvärde", true);
        //Check password not empty

        
        /*
        User instance = null;
        boolean expResult = false;
        boolean result = instance.ValidatePassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of CheckUserInDB method, of class User.
     */
    @Test
    public void testCheckUserInDB() {
        /*
        System.out.println("CheckUserInDB");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.CheckUserInDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of CheckPassword method, of class User.
     */
    @Test
    public void testCheckPassword() {
        /*
        System.out.println("CheckPassword");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.CheckPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of AddUserToUsers method, of class User.
     */
    @Test
    public void testAddUserToUsers() {
        /*
        System.out.println("AddUserToUsers");
        User instance = null;
        instance.AddUserToUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }
    
}
