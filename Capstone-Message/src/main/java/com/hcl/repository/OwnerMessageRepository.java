package com.hcl.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.OwnerMessage;

@Repository
public interface OwnerMessageRepository extends JpaRepository<OwnerMessage, Integer> {
	
	public List<OwnerMessage> findBymsgedDateBetween(LocalDate from, LocalDate to);
	
	public List<OwnerMessage> findByUserEmailEquals(String userEmail);

}

