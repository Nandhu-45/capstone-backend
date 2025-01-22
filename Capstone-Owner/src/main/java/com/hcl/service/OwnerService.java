package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.hcl.entity.Owner;
import com.hcl.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	// Owner Register
	public Owner registerOwner(int ownerId, String ownerName, String ownerEmail, String ownerPassword,
			String ownerPic) {
		Owner owner = new Owner(ownerId,ownerName,ownerEmail,ownerPassword,ownerPic);
		return ownerRepository.save(owner);
	}

	// Owner Login
	public String LoginOwner(Owner owner) {
		if (ownerRepository.findByOwnerNameAndOwnerPassword(owner.getOwnerName(), owner.getOwnerPassword()) != null) {
			return "Owner Successfully logged in ";
		} else {
			return "Owner details are not correct";
		}
	}

	// Owner Logout
	public String LogoutOwner(Owner owner) {
		if (ownerRepository.findByOwnerNameAndOwnerPassword(owner.getOwnerName(), owner.getOwnerPassword()) != null) {
			return "Owner logout  Successfully";
		} else {
			return "Owner details are not correct";
		}
	}

	// Adding a single owner
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	// update a single owner
	public Owner updateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	// delete one owner
	public void deleteOwner(int id) {
		ownerRepository.deleteById(id);
	}

	// get all owners
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	// get owner by id
	public Owner findOwnerById(int id) {
		Optional<Owner> owner = ownerRepository.findById(id);
		if (owner != null) {
			return owner.get();
		} else {
			return null;
		}
	}

	// get owner by email
	public Owner searchbyOwnerEmail(String ownerEmail) {
	    Owner email1 = ownerRepository.findByOwnerEmailEquals(ownerEmail);
		return email1;
		
	}

	// get owner by name
	public List<Owner> searchbyOwnerName(String ownerName) {
		Owner name = new Owner();
		name.setOwnerEmail(ownerName);

		ExampleMatcher ex = ExampleMatcher.matching()
				.withMatcher("ownerName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("ownerId", "ownerEmail", "ownerPassword");
		Example<Owner> example = Example.of(name, ex);
		List<Owner> name1 = ownerRepository.findAll(example);
		return name1;
	}

}
