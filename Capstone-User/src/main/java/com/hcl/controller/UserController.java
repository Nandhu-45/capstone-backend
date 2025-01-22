package com.hcl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.User;
import com.hcl.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;

	//User Register
	@GetMapping("/register")
	public String registerUser(int userId, String userName, String userEmail, String userPassword, String userPic) {
		userService.registerUser(userId, userName, userEmail, userPassword, userPic);
		return "User Successfully Register";
	}

	//User Login
	@GetMapping("/login")
	public User UserLogin(String userName, String userPassword) {
		User user = userService.searchbyuserEmail(userName);
		if (user != null && user.getUserPassword().equals(userPassword)) {
			return user;
		} else {
			return null;
		}
	}

	//User Logout
	@GetMapping("/logout")
	public String userLogout(User user) {
		return userService.LogoutUser(user);
	}
	
	// adding the User
	@GetMapping("/add")
	public User addUser(int userId, String userName, String userEmail, String userPassword,String userPic) {
		User user = new User(userId, userName, userEmail, userPassword,userPic);
		return userService.addUser(user);
	}

	//updating the User
	@GetMapping("/update")
	public User updateOwner(int userId, String userName, String userPic, String userEmail, String userPassword) {
		User user = new User(userId, userName, userEmail, userPassword,userPic);
		return userService.updateUser(user);
	}

	// delete the User
	@GetMapping("/delete")
	public String deleteUser(int id) {
		userService.deleteUser(id);
		return "Deleted Successfully";
	}

	// get All Users
	@GetMapping("/getallusers")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	//find all the User by User-Email
	@GetMapping("/searchbyuserEmail")
	public User searchByEmail(String userEmail) {

		User email = userService.searchbyuserEmail(userEmail);
		if (email != null) {
			return email;

		} else {
			return null;
		}

	}

	// find by User by UserName
	@GetMapping("/searchbyuserName")
	public User searchByName(String userName) {

		User name = userService.searchbyuserEmail(userName);
		if (name != null) {
			return name;

		} else {
			return null;
		}

	}

	// find User by Id
	@GetMapping("/getbyid")
	public User getUserbyId(int id) {

		return userService.findUserById(id);
	}
}