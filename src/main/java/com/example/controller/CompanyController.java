package com.example.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CompanyDTO;
import com.example.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@GetMapping("get/company/{id}") 
	public ResponseEntity<?> getCompany(@PathVariable int id) {
		
		try {
			//return companyService.getCompany(id);
			return new ResponseEntity<>(companyService.getCompany(id), HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Ocurrio un error: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	@PostMapping("/create/company")
	public ResponseEntity<?> createCompany(@RequestBody @Valid CompanyDTO companyToCreate) {
	
		try {
			System.out.println("Controller: "+companyToCreate);
			Integer id = companyService.createCompany(companyToCreate);
			return new ResponseEntity<>(id, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Ocurrio un error: " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
