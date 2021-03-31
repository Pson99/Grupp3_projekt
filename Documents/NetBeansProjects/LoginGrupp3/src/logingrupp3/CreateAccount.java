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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
    // Attribut 
    private String userID;
    private String password;
    
    
    // Metoder
  public static String InputStr(){
    Scanner scan = new Scanner (System.in);
    String input = scan.next();
    return input;
    }
    
    public static String Errors(){
    return "Felmeddelande";
    }
    
}
