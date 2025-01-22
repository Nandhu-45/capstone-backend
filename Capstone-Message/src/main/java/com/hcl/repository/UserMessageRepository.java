package com.hcl.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Integer> {
	
	public List<UserMessage> findBymsgDateBetween(LocalDate from, LocalDate to);
	
	public List<UserMessage> findByUserEmailEquals(String userEmail);

}
