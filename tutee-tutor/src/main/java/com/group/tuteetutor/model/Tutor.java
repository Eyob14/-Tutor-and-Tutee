package com.group.tuteetutor.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutor")
public class Tutor extends Users {

    private String educationlevel;
    private String description;
    private String price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<School> schools;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Course> courses;

    @ManyToOne
    private Users user;
    
    public Tutor() {
    }

    public Tutor(String fullName, String email, String phone, String password, String role, String gender, String educationlevel, String description, String price) {
        super( fullName,  email,  phone,  password,  role,  gender);
        this.educationlevel = educationlevel;
        this.description = description;
        this.price = price;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(School schools) {
        this.schools.add(schools);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses.add(courses);
    }
}
    