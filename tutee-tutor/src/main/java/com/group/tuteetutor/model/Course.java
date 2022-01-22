package com.group.tuteetutor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;


@Entity 
public class Course {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    private String name;
	@ManyToOne  
	private School schools;  

	@ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Tutor> tutors;
	
	public Course( ) {

	}

    public Course(String name) {
        this.name = name;

    }


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public School getSchool() {
		return schools;
	}

	public void setSchool(School schools) {
		this.schools = schools; 
	}

    
	public Set<Tutor> getTutors() {
		return tutors;
	}
	
}
