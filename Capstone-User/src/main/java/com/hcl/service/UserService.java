package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.hcl.entity.User;
import com.hcl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	

// User Register
	public User registerUser(int userId, String userName, String userEmail, String userPassword, String userPic) {
		User user = new User(userId,userName,userEmail,userPassword,userPic);
		return userRepository.save(user);
	}

//	 User Login
	public String LoginUser(User user) {
		if (userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword()) != null) {
			return "User Successfully logged in ";
		} else {
			return "User details are not correct";
		}
	}

//	 User Logout
	public String LogoutUser(User user) {
		if (userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword()) != null) {
			return "User logout  Successfully";
		} else {
			return "User details are not correct";
		}
	}

	// Adding a single user
	public User addUser(User user) {
		return userRepository.save(user);
	}

	// update a single user
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	// delete one user
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	// get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// get user by id
	public User findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user != null) {
			return user.get();
		} else {
			return null;
		}
	}

	// get user by name
	public List<User> searchbyuserName(String userName) {
		List<User> users = userRepository.findByUserNameEquals(userName);
		return users;
	}

	// get user by email
	public User searchbyuserEmail(String userEmail) {
		User user = userRepository.findByUserEmailEquals(userEmail);
		return user;
	}
}