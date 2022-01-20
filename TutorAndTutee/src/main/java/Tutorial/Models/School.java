package Tutorial.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class School {
        @Id
        @GeneratedValue
        private String id;

        @ManyToMany(mappedBy = "schools", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
        private Set<Tutor> tutors;

        @OneToMany(mappedBy = "schools", fetch = FetchType.EAGER)
        private Set<Course> courses;

        @Enumerated(EnumType.STRING) 
        private Type type;
        public static enum Type {
            KG, ELEMENTARY, HIGH_SCHOOL, PREPARATORY
        }

        public Set<Tutor> getAllTutorBySchool(){
            return tutors;
        }

        public void setTutor(Tutor tutor){
            tutors.add(tutor);
            
        }

        public Set<Course> getAllCoursesBySchool(){
            return courses;
        }
    
}

