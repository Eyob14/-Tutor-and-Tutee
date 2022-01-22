package com.group.tuteetutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.tuteetutor.model.Tutee;
import com.group.tuteetutor.repository.TuteeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuteeService {

    @Autowired
    private TuteeRepository tuteeRepo;

    public List<Tutee> getAllTutees(){
      List<Tutee> tutees = new ArrayList<>();
      tuteeRepo.findAll().forEach(tutees::add);
      return tutees;
    }

    public Optional<Tutee> getTutee(Long id){
        return tuteeRepo.findById(id);
    }

    public void addTutee(Tutee tutee){
        tuteeRepo.save(tutee);
    }

    public void updateTutee(Long id, Tutee tutee){
        tuteeRepo.save(tutee);
    }

    public void deleteTutee(Long id){
        tuteeRepo.deleteById(id);
    }

}
