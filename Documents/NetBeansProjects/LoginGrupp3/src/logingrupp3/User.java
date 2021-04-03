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
   
   // ArrayList to save valid users
   private ArrayList <User> users = new ArrayList <>();
   
   
// Methods
   public boolean ValidateUserID(){
       
       return true; 
}
   
   public boolean ValidatePassword(){
       return true;
   }
   
   public boolean CheckUserInDB(){
       return false;
   }
   
   private boolean CheckPassword(){
       return true;
   }
   
   // Add valid users to ArrayList
   public void AddUserToUsers(){
     users.add(new User(this.userID, this.password));
   }
   
   
}
