package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Owner;
import com.hcl.service.OwnerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	
    //Owner Registration
	@GetMapping("/register")
	public String registerOwner(int ownerId, String ownerName, String ownerEmail, String ownerPassword,
			String ownerPic) {
		ownerService.registerOwner(ownerId, ownerName, ownerEmail, ownerPassword, ownerPic);
		return "Owner Successfully Register";
	}

	//Owner Login
	@GetMapping("/login")
	public Owner OwnerLogin(String ownerName, String ownerPassword) {
		Owner owner = ownerService.searchbyOwnerEmail(ownerName);
		if (owner != null && owner.getOwnerPassword().equals(ownerPassword)) {
			return owner;
		} else {
			return null;
		}
	}

	//Owner logout
	@GetMapping("/logout")
	public String OwnerLogout(Owner owner) {
		return ownerService.LogoutOwner(owner);
	}

	// adding the Owner
    @GetMapping("/addOwner")
	public Owner addOwner(int ownerId,String ownerName,String ownerEmail,String ownerPassword, String ownerPic) {
    	Owner owner = new Owner(ownerId,ownerName,ownerEmail,ownerPassword,ownerPic);
		return ownerService.addOwner(owner);
	}
	
	// updating the Owner
	@GetMapping("/updateOwner")
	public Owner updateOwner(int ownerId, String ownerName, String ownerEmail, String ownerPassword, String ownerPic) {
		Owner owner = new Owner(ownerId,ownerName,ownerEmail,ownerPassword,ownerPic);
		return ownerService.updateOwner(owner);
	}

	// delete the Owner by Owner-id
	@GetMapping("/deleteOwner")
	public String deleteOwner(int id) {
		ownerService.deleteOwner(id);
		return "Deleted Successfully";
	}

	// get all the Owners
	@GetMapping("/getallOwners")
	public List<Owner> getAllOwner() {
		return ownerService.getAllOwners();
	}

	//Find Owner by Email
	@GetMapping("/searchbyOwnerEmail")
	public Owner searchByEmail(String ownerEmail) {

		Owner email = ownerService.searchbyOwnerEmail(ownerEmail);
		if (email != null) {
			return email;

		} else {
			return null;
		}

	}

	// find Owner by name
	@GetMapping("/searchbyOwnerName")
	public Owner searchByName(String ownerName) {

		List<Owner> name = ownerService.searchbyOwnerName(ownerName);
		if (name != null) {
			return name.get(0);

		} else {
			return null;
		}

	}

	// find Owner by Id
	@GetMapping("/getbyid")
	public Owner getOwnerbyId(int id) {

		return ownerService.findOwnerById(id);
	}
}
