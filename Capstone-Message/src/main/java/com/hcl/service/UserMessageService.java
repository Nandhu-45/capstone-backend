package com.hcl.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.UserMessage;
import com.hcl.repository.UserMessageRepository;

@RestController
public class UserMessageService {

	@Autowired
	UserMessageRepository userMessageRepository;

	//add User Message
	public UserMessage addUserMessage(int id, String msg, LocalDate msgDate, String userName, String userEmail) {
        UserMessage um = new UserMessage(id,  msgDate,msg, userName, userEmail);
		return userMessageRepository.save(um);
	}

	// get all user messages
	public List<UserMessage> getAllUserMessage() {
		return userMessageRepository.findAll();
	}

	// user messages within dates
	public List<UserMessage> getwithindate(LocalDate from, LocalDate to) {
		return userMessageRepository.findBymsgDateBetween(from, to);
	}

	// user message today date
	public List<UserMessage> findUserMessageByDate(LocalDate from, LocalDate to) {

		List<UserMessage> bookingtoday = userMessageRepository.findBymsgDateBetween(from, to);
		return bookingtoday;
	}

	// get message by user email
	public List<UserMessage> getMessageEmail(String userEmail) {
		List<UserMessage> userMessages = userMessageRepository.findByUserEmailEquals(userEmail);
		return userMessages;
	}

	// delete message of user
	public void deleteUsermessageByid(int id) {
		userMessageRepository.deleteById(id);

	}

}
