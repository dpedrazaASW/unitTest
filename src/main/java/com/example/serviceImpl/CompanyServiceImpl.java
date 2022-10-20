package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.el.PropertyNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.AnimalDTO;
import com.example.dto.CompanyDTO;
import com.example.dto.PersonDTO;
import com.example.entity.Animal;
import com.example.entity.Company;
import com.example.entity.Person;
import com.example.repository.CompanyRepository;
import com.example.repository.PersonRepository;
import com.example.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	
	public CompanyDTO getCompany(int id){
		
		Optional<Company> optCompany = companyRepo.findById(id);
		if(optCompany.isEmpty()) {
			throw new PropertyNotFoundException("No se encontro a la persona");
		} 
		Company comp = optCompany.get(); 
		
		List<PersonDTO> personsResult = new ArrayList<>(); 
		
		for(Person p : comp.getWorkers()) {
			PersonDTO personResult = new PersonDTO();
			personResult.setAge(p.getAge());
			personResult.setName(p.getName());
			
			if(p.getAnimal() != null) {
				AnimalDTO animalResult = new AnimalDTO();
				
				Animal animal = p.getAnimal(); 
				
				animalResult.setBirth(animal.getBirth());
				animalResult.setColor(animal.getColor());
				animalResult.setType(animal.getType());
				
				personResult.setAnimal(animalResult);	
			}
			
			personsResult.add(personResult);
		}
		
		CompanyDTO companyResult = new CompanyDTO(comp.getName(),comp.getRut(), personsResult);

		//return new ResponseEntity<>(companyResult, HttpStatus.OK);
		return companyResult;
	}

	public Integer createCompany(CompanyDTO companyToCreate){
		
		Company newCompany = new Company();
		newCompany.setName(companyToCreate.getName());
		newCompany.setRut(companyToCreate.getRut());
		
		companyRepo.save(newCompany);
		
		List<Person> newPersons = new ArrayList<>();
		
		for(PersonDTO personToCreate : companyToCreate.getWorkers()) {
			Person newPerson = new Person();
			
			newPerson.setAge(personToCreate.getAge());
			newPerson.setName(personToCreate.getName());
			newPerson.setWork(newCompany);
			
			newPersons.add(newPerson);
		}
		personRepo.saveAll(newPersons);
		
		
		return newCompany.getIdCompany();
	}
	
}
