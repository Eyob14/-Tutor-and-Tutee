package com.group.tuteetutor.service;

import java.util.ArrayList;
import java.util.List;

import com.group.tuteetutor.model.Course;
import com.group.tuteetutor.repository.CourseRepository;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseRepository courseRepo;

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepo.findAll().forEach(courses::add);
        return courses;
    }

    // public List<Course> getAllCoursesBySchool(Long schoolId){
    //     List<Course>  courses = new ArrayList<>();
    //     courseRepo.getBySchoolId(schoolId).forEach(courses::add);
    //     return courses;

    // }

    // public Set<Course> getAllCoursesByTutor(Long tutorsId){
    //     Set<Course>  courses = new HashSet<>();
    //     courseRepo.findByTutorsId(tutorsId).forEach(courses::add);
    //     return courses;
    // }

    public List<Course> getCourse(String name){

        return courseRepo.findByName(name);
    }

    public void setCourse(Course course){
        courseRepo.save(course);
    }
    
    public void deleteCourse(Long id){
        courseRepo.deleteById(id);
    }
    
}
