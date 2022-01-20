package Tutorial.Repository;

import org.springframework.data.repository.CrudRepository;

import Tutorial.Models.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
    
}
