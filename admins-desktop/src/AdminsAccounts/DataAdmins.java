/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminsAccounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class DataAdmins { // Gestion des comptes sur son fichier
    
     public static AdminAccounts InitDonnees() throws FileNotFoundException, IOException, ClassNotFoundException  {
        
        /***************************************************************************************************/
        AdminAccounts dataAccounts = new AdminAccounts();
        
        /// Remplir Les informations Des Admins Manuellement;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre d'admins :");
        int n = sc.nextInt();
        String userName ;
        String passWord;
        String firstName;
        String name;
        Admin admin ;
        for (int i=0 ;i < n ; i++){
            System.out.println("userName admin "+(i+1)+"= ");
            userName = sc.next();
            System.out.println("passWord Admin "+(i+1)+"= ");
            passWord= sc.next();
            System.out.println("le nom de l'admin "+(i+1)+"= ");
            firstName= sc.next();
            System.out.println("le prenom de l'admin "+(i+1)+"= ");
            name= sc.next();
            
            admin = new Admin(userName,firstName,name,passWord);
            dataAccounts.listeAdmins.add(admin);
                
           
        }
        
        Comparator <? super Admin> c = new Comparator<Admin>()
                {
                    public int compare(Admin o1, Admin o2)
                    {
                        return(o1.compare(o1.getUserName()+o1.getPassWrod(), o2.getUserName()+o2.getPassWrod()));
                    }
                };
    
        /****************************************************/    
                dataAccounts.listeAdmins.sort(c);
        /****************************************************/
        
        /*************************************************************************************************/
        
        try {
            FileOutputStream fos = new FileOutputStream("dataAdmins.db");           
            ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dataAccounts);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
         
             return dataAccounts;
     }
    
 
    public static void ecrireDonnees(ArrayList<Admin> listeAdmins,String PasseAdmin){
        
        
        AdminAccounts dataAccounts = new AdminAccounts();
        
         /****************************************************/
        Comparator <? super Admin> c = new Comparator<Admin>()
                {
                    public int compare(Admin o1, Admin o2)
                    {
                        return(o1.compare(o1.getUserName()+o1.getPassWrod(), o2.getUserName()+o2.getPassWrod()));
                    }
                };
               listeAdmins.sort(c);
        /****************************************************/
        
        dataAccounts.listeAdmins=listeAdmins;
       
        
        /*************************************************************************************************/
        
        try {
            FileOutputStream fos = new FileOutputStream("dataAdmins.db");           
            ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dataAccounts);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
         
    }  
    
    
    public static AdminAccounts lireDonnees() throws ClassNotFoundException{ 

       AdminAccounts dataAccounts = null;
       try {
                FileInputStream fis = new FileInputStream("dataAdmins.db");
                ObjectInputStream ois = new ObjectInputStream(fis) ;
                dataAccounts = (AdminAccounts)ois.readObject();
                afficherDataAcounts(dataAccounts);
                ois.close();
           } catch (FileNotFoundException e) {
                   e.printStackTrace();
           } catch (IOException e) {
                   e.printStackTrace();
           }

        return dataAccounts;    
    }
         
    public static String encrypt(String password){
        String crypte="";
        for (int i=0; i < password.length(); i++){
            int c = password.charAt(i)^48;
            crypte = crypte+(char) c;
        }
        return crypte;
    }
     
    public static  String decrypt(String password){
        String aCrypter="";
        for (int i=0 ; i <password.length(); i++){
            int c = password.charAt(i)^48;
            aCrypter = aCrypter + (char) c;
        }
        return aCrypter;
    }
    public static String passwordGenera(){
		  
	      String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-@#";
	      Random rand = new Random();
	      String motDePasse ="";
	      for (int i=0; i<5; i++)
	        {
	                motDePasse = motDePasse +alphabet.charAt(rand.nextInt(alphabet.length()));
	        }
	       return motDePasse;
		  
	  }
    
    public static void afficherDataAcounts(AdminAccounts dataAccounts){
       
        for (int i=0 ;i < dataAccounts.listeAdmins.size(); i++ ){
            System.out.println("User Name : "+(i+1)+"= "+ dataAccounts.listeAdmins.get(i).getUserName());
            
            System.out.println("Mot de passe :"+(i+1)+"= "+dataAccounts.listeAdmins.get(i).getPassWrod());           
        }
    }
}
    
    

