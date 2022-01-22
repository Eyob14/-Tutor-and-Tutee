package com.group.tuteetutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.tuteetutor.model.Tutor;
import com.group.tuteetutor.repository.TutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepo;

    public List<Tutor> getAllTutors(){
      List<Tutor> tutors = new ArrayList<>();
      tutorRepo.findAll().forEach(tutors::add);
      return tutors;
    }

    public Optional<Tutor> getTutor(Long id){
        return tutorRepo.findById(id);
    }

    public void addTutor(Tutor tutor){
        tutorRepo.save(tutor);
    }

    public void updateTutor(Long id, Tutor tutor){
        tutorRepo.save(tutor);
    }

    public void deleteTutor(Long id){
        tutorRepo.deleteById(id);
    }

}
