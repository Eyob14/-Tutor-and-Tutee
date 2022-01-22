package com.group.tuteetutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.tuteetutor.model.Users;
import com.group.tuteetutor.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepo;

    public List<Users> getAllUsers(){

		
		List<Users> users = new ArrayList<>(); 
		userRepo.findAll().forEach(users::add);    
		return users; 
    }

    public Optional<Users> getUser(Long id) { 
		return userRepo.findById(id);
	}
	public void addUser(Users User) {
		userRepo.save(User);   
		
	}
	public void updateUser(Long id, Users User) {
		userRepo.save(User); 
	}
	public void deleteUser(Long id) {
		userRepo.deleteById(id); 
	}
    
}
