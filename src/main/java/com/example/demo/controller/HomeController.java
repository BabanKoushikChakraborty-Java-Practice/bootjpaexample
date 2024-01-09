package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.UserService;

@RestController
public class HomeController {

	@Autowired
	UserRepo uRepo;

	@Autowired
	UserService userService;

	// C
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.addNewUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	// R
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	// U
	@PutMapping("/updateUser2/{UserId}")
	public ResponseEntity<User> updateUser2(@RequestBody User user, @PathVariable("UserId") int userId) {
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<User>(updateUser, HttpStatus.OK);
	}

	// D
	@DeleteMapping("/delete/{UserId}")
	public ResponseEntity deleteUser(@PathVariable("UserId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity(null, HttpStatus.OK);
	}

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
	public List<User> getAll() {
//		/**************** 1.8 lambda************************/
//		List<User> all2 = uRepo.findAll();
//		all2.forEach(u->System.out.println(u));
//		/****************************************/
//		/**************** 1.8 ************************/
//		List<User> all = uRepo.findAll();
//		all.forEach(new Consumer<User>() {
//
//			@Override
//			public void accept(User t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}
//
//		});
//		/****************************************/
//		/***************** old ***********************/
//		Iterator<User> iterator = all.iterator();
//		while (iterator.hasNext()) {
//			User  u = iterator.next();
//			System.out.println(u);
//			
//			
//			
//		}
//		/****************************************/
//		return "getting all data";		
		/****************************************/
		List<User> allUsers = userService.getAllUsers();
		return allUsers;

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

		List<User> allUsersByCityAndStatus3 = uRepo.getAllUsersByCityAndStatus3("New Town", "Active");
		allUsersByCityAndStatus3.forEach(e -> System.out.println(e));

//		

		return "success!";
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		User updateUser = userService.updateUser(user);
		return updateUser;
	}

}
