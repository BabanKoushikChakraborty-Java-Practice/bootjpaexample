package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;

@RestController
public class HomeController {
	
	@Autowired
	UserRepo uRepo;
	
	@GetMapping("/add")
	public String home() {
		
		User user= new User();

		user.setName("Raja");
		user.setStatus("Active");
		user.setCity("Kolaghat");
		uRepo.save(user);
	
		return "Success!";
	}
	
	@GetMapping("/update")
	public String getAll() {
		Optional<User> optional = uRepo.findById(1);
		User user = optional.get();		
		System.out.println(user);
		user.setCity("Bangalore");
		User savedUser = uRepo.save(user);
		System.out.println(savedUser);
		
		return "getting data for id: " + user.getId();
	}

}
