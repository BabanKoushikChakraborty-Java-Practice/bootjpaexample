package com.example.demo.controller;

import java.util.Iterator;
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

		User user = new User();

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
		/**************** 1.8 lambda************************/
		List<User> all2 = uRepo.findAll();
		all2.forEach(u->System.out.println(u));
		/****************************************/
		/**************** 1.8 ************************/
		List<User> all = uRepo.findAll();
		all.forEach(new Consumer<User>() {

			@Override
			public void accept(User t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

		});
		/****************************************/
		/***************** old ***********************/
		Iterator<User> iterator = all.iterator();
		while (iterator.hasNext()) {
			User  u = iterator.next();
			System.out.println(u);
			
			
			
		}
		/****************************************/
		return "getting all data";
	}

	
	@GetMapping("/delete")
	public String delete() {
		uRepo.deleteById(1);
		return "deleted!";
	}
	
	@GetMapping("/customQuery")
	public String customQuery() {
		
//		List<User> byStatus = uRepo.findByStatus("Active");
//		byStatus.forEach(e->System.out.println(e));
		
//		List<User> allUsers = uRepo.getAllUsers();
//		allUsers.forEach(e->System.out.println(e));
		
//		List<User> userbyStatus = uRepo.getUserbyStatus("Active");
//		userbyStatus.forEach(e->System.out.println(e));
		

//		List<User> allUsersByCityAndStatus = uRepo.getAllUsersByCityAndStatus("New Town","Active");
//		allUsersByCityAndStatus.forEach(e->System.out.println(e));
		
//		List<User> allUsersByCityAndStatus2 = uRepo.getAllUsersByCityAndStatus2("New Town","Active");
//		allUsersByCityAndStatus2.forEach(e->System.out.println(e));
		
		List<User> allUsersByCityAndStatus3 = uRepo.getAllUsersByCityAndStatus3("New Town","Active");
		allUsersByCityAndStatus3.forEach(e->System.out.println(e));
		
//		
		
		return "success!";
	}
}
