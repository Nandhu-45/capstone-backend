package com.hcl.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.OwnerMessage;
import com.hcl.repository.OwnerMessageRepository;

@RestController
public class OwnerMessageService {

	@Autowired
	OwnerMessageRepository ownerMessageRepository;

	//add the Owner Message
	public OwnerMessage addOwnerMessage(int id, LocalDate msgedDate, String adminMsg, String userEmail) {
		OwnerMessage ownerMessage = new OwnerMessage(id, msgedDate, adminMsg, userEmail);
		return ownerMessageRepository.save(ownerMessage);
	}

	// get all Owner Messages
	public List<OwnerMessage> getAllOwnerMessage() {
		return ownerMessageRepository.findAll();
	}

	// Owner Messages within dates
	public List<OwnerMessage> getwithindate(LocalDate from, LocalDate to) {
		return ownerMessageRepository.findBymsgedDateBetween(from, to);
	}

	// Owner Message's today date
	public List<OwnerMessage> findOwnerMessageByDate(LocalDate from, LocalDate to) {

		List<OwnerMessage> ownertoday = ownerMessageRepository.findBymsgedDateBetween(from, to);
		return ownertoday;
	}

	// get message by user email
	public List<OwnerMessage> getMessageEmailOwner(String userEmail) {
		List<OwnerMessage> ownerMessages = ownerMessageRepository.findByUserEmailEquals(userEmail);
		return ownerMessages;
		
	}

	// delete owner message
	public void deleteOwner(int id) {
		ownerMessageRepository.deleteById(id);
	}

}
