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

import com.hcl.entity.UserMessage;
import com.hcl.service.UserMessageService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserMessageController {

	@Autowired
	UserMessageService userMessageService;

	//add the User Message
	@GetMapping("/addMessage")
	public UserMessage addMessage(int id, String msg, String msgDate, String userName, String userEmail) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDate = LocalDate.parse(msgDate);

		return userMessageService.addUserMessage(id, msg, localDate, userName, userEmail);
	}

	// get all the user-messages
	@GetMapping("/getallMessages")
	public List<UserMessage> getAllOwner() {
		return userMessageService.getAllUserMessage();
	}

	// get all the today's message
	LocalDate todaydate = LocalDate.now();

	@GetMapping("/getmessagetoday")
	public List<UserMessage> FindByMessageToday() {

		return userMessageService.findUserMessageByDate(todaydate, todaydate);
	}

    //get the message with-in date
	@GetMapping("/getwithindate")
	public List<UserMessage> messageWithin(String from, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDatefrom = LocalDate.parse(from, formatter);
		LocalDate localDateto = LocalDate.parse(to, formatter);

		return userMessageService.getwithindate(localDatefrom, localDateto);
	}

	// delete user-message by user-message-id
	@GetMapping("/deleteUserMsg")
	public String deleteUsermsg(int id) {
		userMessageService.deleteUsermessageByid(id);
		return "Deleted Successfully";
	}

	// search all the messages by User-Email
	@GetMapping("/findmessageByemail")
	public UserMessage searchByEmail(String userEmail) {

		List<UserMessage> email = userMessageService.getMessageEmail(userEmail);
		if (email != null) {
			return email.get(0);

		} else {
			return null;
		}

	}

}
