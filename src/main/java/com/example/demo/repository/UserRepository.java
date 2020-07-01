package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	// JPA Naming 쿼리
	
	// User fimdByUsernameAndPassword(String username, String password);
	 
	@Query(value = "SELECT * FROM user WHERE username =? AND password =?", nativeQuery =true)
	User login(String username, String password);

}
