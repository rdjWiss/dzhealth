/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herudi.PraticiensAccounts;

import java.io.Serializable;
import java.util.Comparator;


public class Praticien implements Serializable,Comparable,Comparator<String> { /// Information ur l'éléve
    private String id;
    private String userName;
    private String firstName;
    private String name;
    private String passWrod;
    private String speciality;
    private String hospital;
    private String address;
    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Praticien() {
    }

    public Praticien(String id, String userName, String firstName, String name, String passWrod, String speciality, String hospital, String address, String tel) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.name = name;
        this.passWrod = passWrod;
        this.speciality = speciality;
        this.hospital = hospital;
        this.address = address;
        this.tel = tel;
    }

    
    
    @Override
    public int compare(String o1,String o2){
        return (o1.compareTo(o2));
    }
    @Override
    public boolean equals(Object object){
         Praticien praticien =(Praticien) object;
        return (praticien.userName.equals(this.userName) & praticien.passWrod.equals(this.passWrod) & praticien.getId().equals(this.getId()) );
    }

    @Override
    public int compareTo(Object o) {
        String username = ((Praticien) o).getUserName();
        String password = ((Praticien)o).getPassWrod();
        String id = ((Praticien)o).getId();
        return (this.getPassWrod().compareTo(password) & this.userName.compareTo(username)& this.getId().compareTo(id));
    }
    
}
