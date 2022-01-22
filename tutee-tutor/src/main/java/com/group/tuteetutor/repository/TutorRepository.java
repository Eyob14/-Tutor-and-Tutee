package com.group.tuteetutor.repository;

import com.group.tuteetutor.model.Tutor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends CrudRepository<Tutor,Long>  {
    
}
