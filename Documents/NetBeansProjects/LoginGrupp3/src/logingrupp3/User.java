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
       if(this.userID == null)return false;
       if(this.userID.isEmpty())return false;
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
       boolean specialChar = false, number = false, letter = false, upperCase = false;
       String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
       String emptySpace = " ";
       String numbers = "1234567890";
       String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
      
      
       //check if userID empty
       if(this.password == null)return false;
       if(this.password.isEmpty())return false;
       //Check size, at least 4 characters and a maximum om 16 characters
       if(this.password.length() < 4 || this.password.length() > 16) return false;
      
       //Check for no empty space but at least one letter, one number and one special character
       for (int i = 0; i < this.password.length(); i++) {
           if(emptySpace.contains(Character.toString(this.password.charAt(i))))return false;
           else if(specialCharacters.contains(Character.toString(this.password.charAt(i)))) specialChar = true;
           else if (numbers.contains(Character.toString(this.password.charAt(i)))) number = true;
           else if (capitalLetters.contains(Character.toString(this.password.charAt(i)))) upperCase = true;
           else letter = true;
       }  
       //returns true if all the criteria is there
       return(specialChar && number && upperCase && letter);
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
