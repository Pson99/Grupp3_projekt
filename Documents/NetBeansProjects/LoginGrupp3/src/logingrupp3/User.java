/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingrupp3;

import java.util.ArrayList;

/**
 *
 * @author schum
 */
public class User {
    
   // Attributes 
   private String userID;
   private String password;
 
   
   // Constructor
   public User (String userID, String password){
   this.userID = userID;
   this.password = password;
   }
   
   // ArrayList to save valid users and index counter
   private static ArrayList <User> users = new ArrayList <>();
   
   
// Methods
   public boolean ValidateUserID(){
       //Check if userID empty
       if(this.userID.isEmpty() || this.userID.equals(null))return false;
       //Check size, at least 4 characters
       if(this.userID.length() < 4)return false;
       //Now check each character
       char[] userIdChar = this.userID.toCharArray();
       for (char c : userIdChar) {
           //Todo check chars to requirement
           System.out.println(c);         
       }  
       return true; 
}
   
   public boolean ValidatePassword(){
        char[] passwordChar = this.password.toCharArray();
        for (char c : passwordChar) {
            //Todo check chars to requirement
            System.out.println(c);         
        }  
       return true;
   }
   
   public boolean CheckUserInDB(){       
       for (User user : users) {
           if(user.userID.equals(this.userID))return true;
       }
       return false;
   }
   
   public boolean CheckPassword(){
       for (User user : users) {
           if(user.userID.equals(this.userID)){
               if(user.password.equals(this.password))return true;
           }        
       }
       return false;
   }
   
   // Add valid users to ArrayList
   public void AddUserToUsers(){
     users.add(new User(this.userID, this.password));
   }
   
   
}
