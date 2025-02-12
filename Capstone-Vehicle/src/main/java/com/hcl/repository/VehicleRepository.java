package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Vehicle;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle, String>{
	
	public Vehicle findByRegNumberEquals(String regNumber);
	
	public List<Vehicle> findByModelEquals(String model);
	
	public List<Vehicle> findByWheelerEquals(int wheeler);

}
