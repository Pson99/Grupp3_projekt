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
    
   // Attribut 
   private String userID;
   private String password;
 
   
   // Konstruktor
   public User (String userID, String password){
   this.userID = userID;
   this.password = password;
   }
   
   // ArrayLista som lagrar användare
   private ArrayList <User> users = new ArrayList <User>();
   
   
// Metoder
   private boolean ValidateUserID(){
       return true; 
}
   
   private boolean ValidatePassword(){
       return true;
   }
   
   private boolean CheckUserInDB(){
       return true;
   }
   
   private boolean CheckPassword(){
       return true;
   }
   
   // Lägger till korrekt användare till listan över användare
   private void AddUserToUsers(String userId, String password){
     users.add(new User(userID, password));
   }
   
}
