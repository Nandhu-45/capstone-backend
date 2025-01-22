package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Vehicle;
import com.hcl.service.VehicleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
	
	@Autowired
	VehicleService service;


 	@GetMapping("/")
//	@ResponseBody
	public String HomePage() {
		return "Welcome";
	}

	// get all vehicles
	@GetMapping("/getallvehicles")
	public List<Vehicle> showAllVehicles() {
		return service.getAllVehicle();

	}

	// get all vehicles by Wheeler
	@GetMapping("/getallByWheeler")
	public List<Vehicle> getAllByWheeler(int wheeler) {
		return service.searchbyWheeler(wheeler);

	}

	// adding the vehicle
	@GetMapping("/addVehicle")
	public Vehicle addVehicle(String regNumber, String model, String vehiclePic, int wheeler, int pricePerKm,int ownerId) {
		Vehicle vehicle = new Vehicle(regNumber, model, wheeler,vehiclePic, pricePerKm,ownerId);
		return service.addVehicle(vehicle);
	}

	// updating the vehicle
	@GetMapping("/updateVehicle")
	public Vehicle updateVehicle(String regNumber, String model, String vehiclePic, int wheeler, int pricePerKm, int ownerId) {
		Vehicle vehicle = new Vehicle(regNumber, model,wheeler, vehiclePic, pricePerKm,ownerId);
		return service.updateVehicle(vehicle);
	}

	// delete the vehicle
	@GetMapping("/deletevehicle")
	public String deleteVehicle(String regNumber) {
		Vehicle veh = service.searchbyRegName(regNumber);
		service.deleteVehicle(regNumber);
		return "Deleted Successfully";
	}

	// find vehicle by regNumber
	@GetMapping("/findbyregNumber")
	public Vehicle getById(String regNumber) {

		Vehicle vehicle = service.searchbyRegName(regNumber);
		if (vehicle != null) {
			return vehicle;

		} else {
			return null;
		}

	}

	// find vehicle by model
	@GetMapping("/searchbymodel")
	public Vehicle searchByName(String model) {

		List<Vehicle> modelname = service.searchbymodel(model);
		if (modelname != null) {
			return modelname.get(0);

		} else {
			return null;
		}

	}

	// Sort the Vehicle's(Low-High)
	@GetMapping("/SortVehicles")
	public List<Vehicle> VehicleSort() {

		return service.VehicleSorting();
	}

}
