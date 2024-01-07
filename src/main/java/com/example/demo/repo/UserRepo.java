package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>   {

	/*Derived Query Method Name*/
	public List<User> findByStatus(String Status);
	
	/*JPQL*/
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	/*JPQL*/
	@Query("select u from User u where u.status = ?1")
	public List<User> getUserbyStatus(String Status);
	
	/*JPQL*/
	@Query("select u from User u where u.city= ?1 and u.status= ?2")
	public List<User> getAllUsersByCityAndStatus(String City, String Status);
	
	
	/*JPQL using Named Parameter*/
	@Query("select u from User u where u.city=:c and u.status=:s ")
	public List<User> getAllUsersByCityAndStatus2(@Param("c") String City,@Param("s") String Status);
	
	
	@Query(value = "select * from User u where u.city=?1 and u.status=?2", nativeQuery = true)
	public List<User> getAllUsersByCityAndStatus3(String City, String Status);
	
	
}

