package com.group.tuteetutor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class School {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany(mappedBy = "schools", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
        private Set<Tutor> tutors;

        @Enumerated(EnumType.STRING) 
        private Type type;
        public static enum Type {
            KG, ELEMENTARY, HIGH_SCHOOL, PREPARATORY
        }

        public Set<Tutor> getAllTutorBySchool(){
            return tutors;
        }

        public void ListTutor(Tutor tutor){
            tutors.add(tutor);
            
        }
}

