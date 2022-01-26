package Tutorial.mainClasses;

import Tutorial.mainClasses.TutorProfile.Course;
import Tutorial.mainClasses.TutorProfile.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTutor {
    private Level level;
    private Course course;
}
