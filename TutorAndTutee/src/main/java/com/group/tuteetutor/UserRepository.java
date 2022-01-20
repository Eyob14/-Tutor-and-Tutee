package com.group.tuteetutor;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tutorial.Models.Users;

@Repository
@Primary
public interface UserRepository extends CrudRepository<Users, Long> {
    
}
