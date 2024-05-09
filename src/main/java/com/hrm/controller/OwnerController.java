package com.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.model.House;
import com.hrm.model.Owner;
import com.hrm.repo.HouseRepo;
import com.hrm.repo.OwnerRepo;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin("*")
public class OwnerController {
	
	@Autowired
	OwnerRepo repo;

	@PostMapping
	public ResponseEntity<String> addOwner(@RequestBody Owner owner) {

		try {
			repo.saveAndFlush(owner);
			return new ResponseEntity<>("Owner value inserted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Owner value inserted faild", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getIdList")
	public ResponseEntity<List<Integer>>getOwnerIdList(){
		List<Integer>OwnerData = repo.getIdList();
		return new ResponseEntity<>(OwnerData,HttpStatus.OK);	
	}

	
}
