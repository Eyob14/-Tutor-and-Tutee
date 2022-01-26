package Tutorial.repository;

import java.util.List;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.TutorProfile.Course;
import Tutorial.mainClasses.TutorProfile.Level;

public interface TutorProfileRepository extends JpaRepository<TutorProfile, Long> {
    // public Optional<TutorProfile> findById(Long Id);
    List<TutorProfile> searchByLevelAndCourse(Level level, Course course);

}
