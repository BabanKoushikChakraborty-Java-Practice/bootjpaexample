package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;

@SpringBootApplication
public class BootjpaexampleApplication {


	public static void main(String[] args) {
		SpringApplication.run(BootjpaexampleApplication.class, args);
	}		
	

}
