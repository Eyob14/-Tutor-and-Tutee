package com.group.tuteetutor.repository;

import com.group.tuteetutor.model.Tutee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteeRepository extends CrudRepository<Tutee,Long> {
    
}
