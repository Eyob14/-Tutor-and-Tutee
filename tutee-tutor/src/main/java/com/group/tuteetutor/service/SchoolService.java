package com.group.tuteetutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.tuteetutor.model.School;
import com.group.tuteetutor.repository.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepo;

    public List<School> getAllSchool(){
        List<School> schools = new ArrayList<>();
        schoolRepo.findAll().forEach(schools::add);
        return schools;
    }

    public Optional<School> getSchool(Long id){
        return schoolRepo.findById(id);
    }

    public void setSchool(School school){
        schoolRepo.save(school);
    }

    public void deleteSchool(Long id){
        schoolRepo.deleteById(id);
    }
    
}
