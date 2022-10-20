package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.dto.PersonDTO;
import com.example.dto.PersonUpdateDTO;

public interface MainService {

	
	public ResponseEntity<?> getPerson(String name);
	
	public Integer createPerson(PersonDTO personToCreate);
	
	public String updatePerson(PersonUpdateDTO personToUpdate);
	
	public ResponseEntity<?> deletePerson(int id);
	
	public ResponseEntity<?> deleteAnimal(int id);
}
