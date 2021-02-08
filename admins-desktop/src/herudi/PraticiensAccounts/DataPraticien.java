/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.PraticiensAccounts;


import java.io.FileInputStream;
import herudi.PraticiensAccounts.*;
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

public class DataPraticien { // Gestion des comptes sur son fichier
    
     public static herudi.PraticiensAccounts.PraticienAccounts InitDonnees() throws FileNotFoundException, IOException, ClassNotFoundException  {
        
        /***************************************************************************************************/
       herudi.PraticiensAccounts.PraticienAccounts dataAccounts = new herudi.PraticiensAccounts.PraticienAccounts();
        
        /// Remplir Les informations Des Admins Manuellement;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nombre de Praticiens :");
        int n = sc.nextInt();
         String id;
         String userName;
         String firstName;
         String name;
         String passWord;
         String speciality;
         String hospital;
         String address;
         String tel;
        Praticien praticien ;
        for (int i=0 ;i < n ; i++){
            id= Integer.toString(i+1);
            System.out.println("userName praticien "+(i+1)+"= ");
            userName = sc.next();
            System.out.println("passWord Praticien "+(i+1)+"= ");
            passWord= sc.next();
            System.out.println("le nom du Praticien "+(i+1)+"= ");
            firstName= sc.next();
            System.out.println("le prenom du Prticien"+(i+1)+"= ");
            name= sc.next();
            System.out.println("la Spécialité du praticien "+(i+1)+"= ");
            speciality = sc.next();
            System.out.println("l'hopital du praticien "+(i+1)+"= ");
            hospital = sc.next();
            System.out.println("l'adresse du praticien "+(i+1)+"= ");
            address = sc.next();
            System.out.println("le téléphone du praticien "+(i+1)+"= ");
            tel = sc.next();
           
            praticien = new herudi.PraticiensAccounts.Praticien(id,userName,firstName,name,passWord,speciality,hospital,address,tel);
            dataAccounts.listePraticiens.add(praticien);
                
           
        }
        
        Comparator <? super Praticien> c = new Comparator<Praticien>()
                {
                    public int compare(Praticien o1, Praticien o2)
                    {
                        return(o1.compare(o1.getUserName()+o1.getPassWrod(), o2.getUserName()+o2.getPassWrod()));
                    }
                };
    
        /****************************************************/    
                dataAccounts.listePraticiens.sort(c);
        /****************************************************/
        
        /*************************************************************************************************/
        
        try {
            FileOutputStream fos = new FileOutputStream("dataPraticen.db");           
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
    
 
    public static void ecrireDonnees(ArrayList<Praticien> listePraticien){
        
        
        herudi.PraticiensAccounts.PraticienAccounts dataAccounts = new PraticienAccounts ();
        
         /****************************************************/
        Comparator <? super Praticien> c = new Comparator<Praticien>()
                {
                    public int compare(Praticien o1, Praticien o2)
                    {
                        return(o1.compare(o1.getUserName()+o1.getPassWrod(), o2.getUserName()+o2.getPassWrod()));
                    }
                };
               listePraticien.sort(c);
        /****************************************************/
        
        dataAccounts.listePraticiens=listePraticien;
       
        
        /*************************************************************************************************/
        
        try {
            FileOutputStream fos = new FileOutputStream("dataPraticen.db");           
            ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dataAccounts);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
         
    }  
    
    
    public static herudi.PraticiensAccounts.PraticienAccounts lireDonnees() throws ClassNotFoundException{ 

       herudi.PraticiensAccounts.PraticienAccounts dataAccounts = null;
       try {
                FileInputStream fis = new FileInputStream("dataPraticen.db");
                ObjectInputStream ois = new ObjectInputStream(fis) ;
                dataAccounts = (herudi.PraticiensAccounts.PraticienAccounts)ois.readObject();
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
    
    public static void afficherDataAcounts(herudi.PraticiensAccounts.PraticienAccounts dataAccounts) throws ClassNotFoundException{
        
    
        for (int i=0 ;i < dataAccounts.listePraticiens.size(); i++ ){
            System.out.println("User Name : "+(i+1)+"= "+ dataAccounts.listePraticiens.get(i).getUserName());
            
            System.out.println("Mot de passe :"+(i+1)+"= "+dataAccounts.listePraticiens.get(i).getPassWrod());           
        }
    }
}
    
    

