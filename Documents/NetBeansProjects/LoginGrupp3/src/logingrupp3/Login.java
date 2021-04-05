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
public class Login {
    private static String userID;
    private static String password;
    private static String text;

    public static void main(String[] args) {        
        //Main loop
        do {            
         //Main menu
        text = "***********************\n";
        text+= "*  L. Login           *\n";
        text+= "*  C. Create account  *\n";
        text+= "***********************\n";
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
                } else System.out.println(Errors(1));

                //If all is good goto main menu               
            } while (!valid);

        }
        //If successful with create account we will goto main menu
        //If selecting "L" in main menu we will start here
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
                if(user.CheckUserInDB()){
                    //Check password only if userID is in DB
                    if(user.CheckPassword())valid = true;
                    //If password is wrong
                    else System.out.println(Errors(3));
                }else System.out.println(Errors(2));//If userID is wrong
                
                //Lets say we give them three attempts
                if(count == 3)break;
            } while (!valid);
            if(valid){
                text = "*----------------------------*\n";
                text+= "| Success, you're logged in! |\n";
                text+= "*----------------------------*";
                System.out.println("\n"+text+"\n");
            }
        }
        //Loop back to main menu        
        } while (true);       
    }
    
        
    // Methods
  public static String InputStr(){
    Scanner scan = new Scanner(System.in);
    return scan.next().trim();
    }
    
    public static String Errors(int x){
        if(x == 1){      
            text = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
            text+= "!                           ERROR                               !\n";
            text+= "! Prerequisites:                                                !\n";
            text+= "! User ID has to be unique and consist of minimum 4 characters, !\n";
            text+= "! only letters and numbers and at least one of each, user ID    !\n";
            text+= "! is not case sensitive, no empty spaces are allowed.           !\n";
            text+= "!                                                               !\n";
            text+= "! Password has to have a minimum of 4 chars and consist of      !\n";
            text+= "! at least one letter, one number and one special character.    !\n";
            text+= "! Passwords are case sensitive.                                 !\n";
            text+= "!                                                               !\n";
            text+= "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";           
            return text;           
        }
        else if(x == 2){
            text = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
            text+= "!                         ERROR                              !\n";
            text+= "! User ID not in database, check your typing, you have       !\n";
            text+= "! three attempts.                                            !\n";
            text+= "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"; 
            return text;
        }
        else if(x == 3){
            text = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
            text+= "!                         ERROR                              !\n";
            text+= "! Password not in database, check your typing, you have      !\n";
            text+= "! three attempts.                                            !\n";
            text+= "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"; 
            return text;            
        }
        //Generic Error not used for the time being
        return "Error";
    } 
}
