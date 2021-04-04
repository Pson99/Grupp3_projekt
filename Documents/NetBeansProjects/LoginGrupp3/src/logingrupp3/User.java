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
   private static ArrayList <User> users = new ArrayList <>();
   
   
// Methods
   public boolean ValidateUserID(){
       boolean letter = false, number = false;
       String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}";
       String numbers = "1234567890";
              
       //Check if userID empty
       if(this.userID.isEmpty() || this.userID.equals(null))return false;
       //Check size, at least 4 characters
       if(this.userID.length() < 4)return false;
       //Check for special characters or blanc space and numbers and letters
       for (int i = 0; i < this.userID.length(); i++) {   
            if(specialCharacters.contains(Character.toString(this.userID.charAt(i))))return false;
            else if(numbers.contains(Character.toString(this.userID.charAt(i))))number = true;
            else letter = true;
        }
       //Returns true if only letters and numbers
       return(letter && number); 
}
   
   public boolean ValidatePassword(){
        char[] passwordChar = this.password.toCharArray();
        for (char c : passwordChar) {
            //Todo check chars to requirement
            //System.out.println(c);         
        }  
       return true;
   }
   
   public boolean CheckUserInDB(){       
       for (User user : users) {
           //userID not case sensitive
           if(user.userID.equalsIgnoreCase(this.userID))return true;
       }
       return false;
   }
   
   public boolean CheckPassword(){
       for (User user : users) {
           //userID not case sensitive but password is
           if(user.userID.equalsIgnoreCase(this.userID)){
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
