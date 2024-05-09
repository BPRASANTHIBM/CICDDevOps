package com.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.model.House;
import com.hrm.repo.HouseRepo;


@RestController
@RequestMapping("/api/house")
@CrossOrigin("*")
public class HouseController {

	@Autowired
	HouseRepo repo;

	@PostMapping
	public ResponseEntity<String> addHouse(@RequestBody House house) {

		try {
		if(house!=null && house.getOwner()!=null) {
			System.out.println(house);
			repo.saveAndFlush(house);
			return new ResponseEntity<>("House value inserted successfully", HttpStatus.OK);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value inserted faild", HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	public ResponseEntity<List<House>> getAllHouse() {
		List<House> houses = repo.findAll();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<House> getAllHouseById(@RequestParam Integer id) {
	     House houses = repo.findById(id).get();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/findByLocation")
	public ResponseEntity<List<House>> findByLocation(@RequestParam String location){
		List<House> houses = repo.findBylocation(location);
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/locationList")
	public ResponseEntity<List<String>> getLocationList(){
		List<String> houses = repo.getLocationList();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/rentList")
	public ResponseEntity<List<Integer>> getRentList(){
		List<Integer> houses = repo.getRentList();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/bedRoomList")
	public ResponseEntity<List<String>> getRoomList(){
		List<String> houses = repo.getBedroomList();
		return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	@GetMapping("/filterHouse")
	public ResponseEntity<List<House>>filterHouse(@RequestParam String location,@RequestParam double rent,@RequestParam String bedroom){
		 List<House> houses=repo.filterHouseList(location, rent, bedroom);
		 return new ResponseEntity<>(houses, HttpStatus.OK);
	}
	
	

	@DeleteMapping
	public ResponseEntity<String> deleteHouse(@RequestParam Integer houseId) {
		try {
        if(houseId>0) {
			repo.deleteById(houseId);

			return new ResponseEntity<>("House value deleted successfully", HttpStatus.OK);
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value deleted faild", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	public ResponseEntity<String>updateHouse(@RequestBody House house){
		
		try {
			if(house!=null && house.getOwner()!=null) {
			repo.saveAndFlush(house);

			return new ResponseEntity<>("House value updated successfully", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("House value updation faild", HttpStatus.BAD_REQUEST);
		
	}

}
