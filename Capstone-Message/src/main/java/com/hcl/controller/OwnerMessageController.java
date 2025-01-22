package com.hcl.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.OwnerMessage;
import com.hcl.service.OwnerMessageService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerMessageController {

	@Autowired
	OwnerMessageService ownerMessageService;
	
    //add the Owner Message
	@GetMapping("/addOwnerMessage")
	public OwnerMessage addMessage(int id, String msgedDate, String adminMsg, String userEmail) {

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDate = LocalDate.parse(msgedDate);

		return ownerMessageService.addOwnerMessage(id, localDate, adminMsg, userEmail);
	}

	// get all the Owner Messages
	@GetMapping("/getallMessagesOwner")
	public List<OwnerMessage> getAllOwner() {
		return ownerMessageService.getAllOwnerMessage();
	}

	// for today's owner messages
	LocalDate todaydate = LocalDate.now();

	@GetMapping("/getOwnermessagetoday")
	public List<OwnerMessage> FindByMessageToday() {

		return ownerMessageService.findOwnerMessageByDate(todaydate, todaydate);
	}

	// get Owner Messages with in date
	@GetMapping("/getwithindateOwner")
	public List<OwnerMessage> messageWithin(String from, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDatefrom = LocalDate.parse(from, formatter);
		LocalDate localDateto = LocalDate.parse(to, formatter);

		return ownerMessageService.getwithindate(localDatefrom, localDateto);
	}

	// delete the owner-message by Message-Id
	@GetMapping("/deleteOwnerMsg")
	public String deleteOwner(int id) {
		ownerMessageService.deleteOwner(id);
		return "Deleted Successfully";
	}

	// find by owner message by user-email
	@GetMapping("/findmessageByOwneremail")
	public OwnerMessage findbyemailowner(String userEmail) {

		List<OwnerMessage> email = ownerMessageService.getMessageEmailOwner(userEmail);
		if (email != null) {
			return email.get(0);

		} else {
			return null;
		}

	}

}
