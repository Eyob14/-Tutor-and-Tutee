package com.group.tuteetutor.repository;
import java.util.List;
import com.group.tuteetutor.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>{

    public List<Course> findByName(String name);
}