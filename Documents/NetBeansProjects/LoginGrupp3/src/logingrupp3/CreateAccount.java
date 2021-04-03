/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingrupp3;

import java.util.Scanner;

/**
 *
 * @author schum
 */
public class CreateAccount {


    public static void main(String[] args) {
        String userID;
        String password;
        String text;
        
        //Main loop
        do {            
         //Main menu
        text = "*****************\n";
        text+= "Login\n";
        text+= "Create account\n";
        text+= "*****************\n";
        text+= "Type \"L\" or \"C\" to continue: ";
        System.out.print(text);
        String choice = InputStr();
        
        //Create account
        if(choice.equalsIgnoreCase("C")){
            boolean valid = false;
            
            do {                
                System.out.print("Make a user ID: ");
                userID = InputStr();
                System.out.print("Make a password: ");
                password = InputStr();
                //Create user object
                User user = new User(userID, password);
                //Now check for user ID already taken
                //Validate both userID and password
                //Should return false if not valid and then error meassage
                if(!user.CheckUserInDB() && user.ValidateUserID() && user.ValidatePassword()){
                    //Add to user ArrayList
                    user.AddUserToUsers();
                    //Break out of do-while loop
                    valid = true;
                }

                //If all is good goto main menu               
            } while (!valid);

        }
        
        //Goto login, already has account
        else if(choice.equalsIgnoreCase("L")){
            int count = 0;
            boolean valid = false;
            do {
                count++;
                System.out.print("Enter user ID to login: ");
                userID = InputStr();
                System.out.print("Enter your password: ");
                password = InputStr();
                //Create user object
                User user = new User(userID, password);
                //Check if user in DB and if so check password               
                //Could be the same method, we don't need two methods for
                //check user in DB and check password
                //Lets say we give them three attempts
                if(count == 3)break;
            } while (!valid);
            if(valid)System.out.println("Succes, you're logged in!");

        }
        //Loop back to main menu        
        } while (true);

        
        
    }
    
    // Attributes 
    
    
    // Methods
  public static String InputStr(){
    Scanner scan = new Scanner(System.in);
    return scan.next().trim();
    }
    
    public static String Errors(){
    return "Felmeddelande";
    }
    
}
