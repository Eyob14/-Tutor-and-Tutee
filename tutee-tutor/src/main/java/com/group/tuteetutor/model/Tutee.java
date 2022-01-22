package com.group.tuteetutor.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tutee")
public class Tutee extends Users {

    private String description;

    @ManyToOne
    private Users user;
    
    
    public Tutee() {
    }

    public Tutee(String fullName, String email, String phone, String password, String role, String gender,String description, Address address) {
        super( fullName,  email,  phone,  password,  role,  gender);
        this.description = description;
    
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
    