package com.example.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PersonDTO;
import com.example.dto.PersonUpdateDTO;
import com.example.service.MainService;

@RestController
public class MainController {
	
	@Autowired
	private MainService capService;

	@GetMapping("get/person/{name}") 
	public ResponseEntity<?> getPerson(@PathVariable String name) {
		
		try {
			return capService.getPerson(name);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Ocurrio un error: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update/person")
	public ResponseEntity<?> updatePerson(@RequestBody @Valid PersonUpdateDTO personToUpdate) {
	
		try {
			String result = capService.updatePerson(personToUpdate);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/create/person")
	public ResponseEntity<?> createPerson(@RequestBody @Valid PersonDTO personToCreate) {
	
		try {
			Integer id = capService.createPerson(personToCreate);
			return new ResponseEntity<>(id, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Ocurrio un error: " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/delete/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable int id){
		try {
			return capService.deletePerson(id);
			
		}catch(Exception e) {
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/delete/animal/{id}")
	public ResponseEntity<?> deleteAnimal(@PathVariable int id){
			return capService.deleteAnimal(id);
	
	}

}
