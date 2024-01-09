package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	/* Derived Query Method Name */
	public List<User> findByStatus(String Status);

	/* JPQL */
	@Query("select u from User u")
	public List<User> getAllUsers();

	/* JPQL */
	@Query("select u from User u where u.status = ?1")
	public List<User> getUserbyStatus(String Status);

	/* JPQL */
	@Query("select u from User u where u.address.city= ?1 and u.status= ?2")
	public List<User> getAllUsersByCityAndStatus(String City, String Status);

	/* JPQL using Named Parameter */
	@Query("select u from User u where u.address.city=:c and u.status=:s ")
	public List<User> getAllUsersByCityAndStatus2(@Param("c") String City, @Param("s") String Status);

	/* Native SQL Query */
	@Query(value = "select * from User as u, address as a where a.add_id=u.address_add_id and a.city=?1 and u.status=?2", nativeQuery = true)
	public List<User> getAllUsersByCityAndStatus3(String City, String Status);

}
