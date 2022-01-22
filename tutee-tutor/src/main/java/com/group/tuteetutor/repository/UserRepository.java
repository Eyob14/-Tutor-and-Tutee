package com.group.tuteetutor.repository;

import com.group.tuteetutor.model.Users;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepository extends CrudRepository<Users, Long> {
    @Query("SELECT u FROM Tutor u WHERE u.email = ?1")
   public  Users findByEmail(String username);
    
}
