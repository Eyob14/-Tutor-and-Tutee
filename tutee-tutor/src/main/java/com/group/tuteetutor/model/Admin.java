package com.group.tuteetutor.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends Users {
    
    
    public Admin() {
    }

    public Admin(String fullName, String email, String phone, String password, String role, String gender,String description) {
        super( fullName,  email,  phone,  password,  role,  gender);
    
    }

}
    