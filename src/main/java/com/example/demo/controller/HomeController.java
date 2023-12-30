package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
	public String update() {
		Optional<User> optional = uRepo.findById(1);
		User user = optional.get();		
		System.out.println(user);
		user.setCity("Bangalore");
		User savedUser = uRepo.save(user);
		System.out.println(savedUser);
		
		return "getting & updating data for id: " + user.getId();
	}
	
	@GetMapping("/getAll")
	public String getAll() {
		List<User> all = uRepo.findAll();
		all.forEach(new Consumer<User>() {

			@Override
			public void accept(User t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		});
		
		return "getting all data";
	}

}
