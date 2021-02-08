/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminsAccounts;

import java.io.Serializable;
import java.util.Comparator;


public class Admin implements Serializable,Comparable,Comparator<String> { /// Information ur l'éléve
    private String userName;
    private String firstName;
    private String name;
    private String passWrod;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWrod() {
        return passWrod;
    }

    public void setPassWrod(String passWrod) {
        this.passWrod = passWrod;
    }

    public Admin(String userName, String firstName, String name, String passWrod) {
        this.userName = userName;
        this.firstName = firstName;
        this.name = name;
        this.passWrod = passWrod;
    }

  
    
    @Override
    public int compare(String o1,String o2){
        return (o1.compareTo(o2));
    }
    @Override
    public boolean equals(Object object){
        Admin admin =(Admin) object;
        return (admin.userName.equals(this.userName) & admin.passWrod.equals(this.passWrod));
    }

    @Override
    public int compareTo(Object o) {
        String username = ((Admin) o).getUserName();
        String password = ((Admin)o).getPassWrod();
        return (this.getPassWrod().compareTo(password) & this.userName.compareTo(username));
    }
    
}
