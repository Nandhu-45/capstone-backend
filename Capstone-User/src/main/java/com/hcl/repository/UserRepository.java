package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserNameAndUserPassword(String userName, String userPassword);
	
	public List<User> findByUserNameEquals(String userName);
	
	public User findByUserEmailEquals(String userEmail);

}
