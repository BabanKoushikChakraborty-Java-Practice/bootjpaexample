package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo uRepo;
	
	public List<User> getAllUsers(){
		List<User> all = uRepo.findAll();
		return all;		
	}
	
	public User addNewUser(User user) {
		User save = uRepo.save(user);
		return save;
	}
	
	public User updateUser(User user) {
		Optional<User> byId = uRepo.findById(user.getId());
		User user2 = byId.get();
		user2.setCity(user.getCity());
		user2.setName(user.getName());
		user2.setStatus(user.getStatus());
		uRepo.save(user2);
		return user2;
	}
	
	public User updateUser2(User user, int userId) {
		user.setId(userId );
		uRepo.save(user);
		return user;
		
	}
	
	public void deleteUser(int userId) {
		uRepo.deleteById(userId);
	}

}
