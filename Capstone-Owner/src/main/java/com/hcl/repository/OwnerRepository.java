package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{
	
	public Owner findByOwnerNameAndOwnerPassword(String ownerName, String ownerPassword);
	public Owner findByOwnerEmailEquals(String ownerEmail);
	public List<Owner> findByOwnerName(String ownerName);

}
