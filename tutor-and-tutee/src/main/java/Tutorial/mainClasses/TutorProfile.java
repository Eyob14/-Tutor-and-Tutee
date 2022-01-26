package Tutorial.mainClasses;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tutor_profile")
public class TutorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Exclude
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = true)
    private Level level;

    @Column(nullable = true)
    private Course course;

    @Column(nullable = true)
    private String description;


     
    public static enum Level{
        ELEMENTARY,
        HIGHSCHOOL,
        PREPARATORY,
        COLLEGE;

        private Level() {

        }
    }


    public static enum Course{
        BIOLOGY,
        CHEMISTRY,
        ENGLISH,
        JAVA,
        PYTHON,
        C,
        DATASTRUCTURE,
        COLLEGE;

        private Course() {

        }
    }

    
    

    
}