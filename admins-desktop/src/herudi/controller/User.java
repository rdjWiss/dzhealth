package herudi.controller;


import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class User extends RecursiveTreeObject<User> {
        private StringProperty id;
        private StringProperty userName;
        private StringProperty name;
        private StringProperty firstName;
        private StringProperty speciality;
        private StringProperty hospital;
        private StringProperty address;
        private StringProperty telephone;
        private StringProperty Pass;

        public User(String id,String userName, String name, String firstName, String speciality, String hospital, String address, String telephone, String Pass) {
            this.id = new SimpleStringProperty(id);
            this.userName = new SimpleStringProperty(userName);
            this.name = new SimpleStringProperty(name);
            this.firstName = new SimpleStringProperty(firstName);
            this.speciality = new SimpleStringProperty(speciality);
            this.hospital = new SimpleStringProperty(hospital);
            this.address = new SimpleStringProperty(address);
            this.telephone = new SimpleStringProperty(telephone);
            this.Pass = new SimpleStringProperty(Pass);
        }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public StringProperty getId() {
        return id;
    }

    public void setId(StringProperty id) {
        this.id = id;
    }

    public StringProperty getUserName() {
        return userName;
    }

    public void setUserName(StringProperty userName) {
        this.userName = userName;
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    public StringProperty getSpeciality() {
        return speciality;
    }

    public void setSpeciality(StringProperty speciality) {
        this.speciality = speciality;
    }

    public StringProperty getHospital() {
        return hospital;
    }

    public void setHospital(StringProperty hospital) {
        this.hospital = hospital;
    }

    public StringProperty getAddress() {
        return address;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public StringProperty getTelephone() {
        return telephone;
    }

    public void setTelephone(StringProperty telephone) {
        this.telephone = telephone;
    }

    public StringProperty getPass() {
        return Pass;
    }

    public void setPass(StringProperty Pass) {
        this.Pass = Pass;
    }
        
        
    }