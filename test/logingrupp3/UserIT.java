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
    User testUser1;
    User testUser2;
    
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
        
        System.out.println("\nValidateUserID");
        
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
        
        System.out.println("12 user ID's tested");          
    }

    /**
     * Test of ValidatePassword method, of class User.
     */
    @Test
    public void testValidatePassword() {
        
        System.out.println("\nValidatePassword");

        //Check empty or spaces in password
        assertFalse(new User(null, null).ValidatePassword());
        assertFalse(new User(null, "").ValidatePassword());
        assertFalse(new User(null, " ").ValidatePassword());
        assertFalse(new User(null, "pj 20").ValidatePassword());
        assertFalse(new User(null, "pj20testinglonguseridwith space").ValidatePassword());
        
        //Check < 4 and > 16 size
        assertFalse(new User(null, "P2#").ValidatePassword());
        assertFalse(new User(null, "PatrikJansson20!%").ValidatePassword());
        
        //Check password with a missing number, uppercase and special character
        assertFalse(new User(null, "Path#").ValidatePassword());
        assertFalse(new User(null, "path20#").ValidatePassword());
        assertFalse(new User(null, "Path20").ValidatePassword());
        
        //Check with only special characters, numbers or letters
        assertFalse(new User(null, "!#$%&").ValidatePassword());
        assertFalse(new User(null, "12345").ValidatePassword());
        assertFalse(new User(null, "Abcde").ValidatePassword());
        
        //Correct password, all rules are met
        assertTrue(new User(null, "Path20#").ValidatePassword());
        
        //Correct userID with swedish letters, not possible to try manual input here
        assertTrue(new User(null, "Åäö20#").ValidatePassword());
        
        //Correct Password checked by Junit preprogrammed assert
        User instance = new User(null, "Patrik2021.");
        boolean expResult = true;
        boolean result = instance.ValidatePassword();
        assertEquals(expResult, result);
        
        System.out.println("16 passwords tested");
    }

    /**
     * Test of CheckUserInDB method, of class User.
     */
    @Test
    public void testCheckUserInDB() {
        
        System.out.println("\nCheckUserInDB");
        
        // Create a few new users
        User user1 = new User("Pierre1", null);
        User user2 = new User("Kalle1", null);
        User user3 = new User("Bengt4", null);
        User user4 = new User ("Niklas2", null);
        User user5 = new User ("Tom7", null);
        
        // Add new user to arraylist
        user1.AddUserToUsers();
        user2.AddUserToUsers();
        user3.AddUserToUsers();
        user4.AddUserToUsers();
        user5.AddUserToUsers();
        
        // Test if users is in database
        assertTrue(user1.CheckUserInDB());
        assertTrue(user4.CheckUserInDB());
       
        System.out.println("user1 and user4 of 5 users checked in DB");     
    }

    /**
     * Test of CheckPassword method, of class User.
     */
    @Test
    public void testCheckPassword() {
        
        System.out.println("\nCheckPassword");        
                 
        //Create new users
        User user1 = new User("path20", "Path20#");
        User user2 = new User("pierre20", "Pierre20&");
        User user3 = new User("richard20", "Richard20@");
        User user4 = new User ("axel20", "Axel20=");
        User user5 = new User ("Tom7", "Tom7!");
       
        //Add new user to the arraylist
        user1.AddUserToUsers();
        user2.AddUserToUsers();
        user3.AddUserToUsers();
        user4.AddUserToUsers();
        user5.AddUserToUsers();
       
        //Test if the user is in the arraylist
        assertTrue(user1.CheckPassword());
        assertTrue(user4.CheckPassword());
        
        System.out.println("user1 and user4 of 5 users checked in DB for correct passwords");
    }

    /**
     * Test of AddUserToUsers method, of class User.
     */
    @Test
    public void testAddUserToUsers() {
        
        System.out.println("AddUserToUsers");
        
        //Make instances of User
        testUser1 = new User("testing123", "\"Testing123");
        testUser2 = new User("testing321", "#Testing321");
        
        //Add to ArrayList
        testUser1.AddUserToUsers();
        testUser2.AddUserToUsers();
        
        //Check these users in DB
        assertTrue(testUser1.CheckUserInDB());
        assertTrue(testUser2.CheckUserInDB());
        
        //Check ArrayList size, expected size is 2
        assertEquals(2, testUser1.GetUsers().size());
        
        System.out.println(testUser1.GetUsers().size() + " users in ArrayList, 2 expected.");
    }
    
}
