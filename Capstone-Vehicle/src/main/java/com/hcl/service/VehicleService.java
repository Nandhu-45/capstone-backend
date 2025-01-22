package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hcl.entity.Vehicle;
import com.hcl.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	// Adding a single vehicle
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	// update a single vehicle
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	// delete one vehicle
	public void deleteVehicle(String regNumber) {
		vehicleRepository.deleteById(regNumber);
	}

	// get all vehicles
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	// get vehicle by regNumber
	public Vehicle searchbyRegName(String regNumber) {
		Vehicle vehicle =  vehicleRepository.findByRegNumberEquals(regNumber);
		return vehicle;
	}

	// find vehicles by vehicle-model
	public List<Vehicle> searchbymodel(String model) {		
		List<Vehicle> vehicles = vehicleRepository.findByModelEquals(model);
		return vehicles;
	}

	// find vehicles by Wheeler
	public List<Vehicle> searchbyWheeler(int wheeler) {
		List<Vehicle> vehicles = vehicleRepository.findByWheelerEquals(wheeler);
		return vehicles;

	}

	// Sort the vehicles
	public List<Vehicle> VehicleSorting() {

		return vehicleRepository.findAll(Sort.by(Direction.ASC, "pricePerKm"));
	}

}
