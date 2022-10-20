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
import com.example.dto.PersonDTO;
import com.example.dto.PersonUpdateDTO;
import com.example.entity.Animal;
import com.example.entity.Person;
import com.example.repository.AnimalRepository;
import com.example.repository.PersonRepository;
//import com.example.repository.PersonRepository;
import com.example.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private AnimalRepository animalRepo;
	
	
	public ResponseEntity<List<PersonDTO>> getPerson(String name) {
		
		List<Person> persons = personRepo.findByName(name);
		if(persons.isEmpty()) {
			throw new PropertyNotFoundException("No se encontro a la persona");
		}
		
		List<PersonDTO> personsResult = new ArrayList<>();
		
		for(Person p : persons) {
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

		return new ResponseEntity<>(personsResult, HttpStatus.OK);
	}
	
	public Integer createPerson(PersonDTO personToCreate) {
		Person newPerson = new Person();
		
		Animal newAnimal = new Animal();
		
		newAnimal.setBirth(personToCreate.getAnimal().getBirth());
		newAnimal.setColor(personToCreate.getAnimal().getColor());
		newAnimal.setType(personToCreate.getAnimal().getType());
		
		animalRepo.save(newAnimal);
		
		newPerson.setAge(personToCreate.getAge());
		newPerson.setName(personToCreate.getName());
		newPerson.setAnimal(newAnimal);
		
		
		personRepo.save(newPerson);
		
		return newPerson.getId();
	}
	
	public String updatePerson(PersonUpdateDTO personToUpdate) {
		Optional<Person> optional = personRepo.findById(personToUpdate.getId());
		if(optional.isPresent()) {
			Person p = optional.get();
			
			p.setAge(personToUpdate.getAge());
			p.setName(personToUpdate.getName());
			
			personRepo.save(p);
			
			return "Actualizado correctamente";
		}
		
		return "No se encontro el id";
		
	}
	
	public ResponseEntity<String> deletePerson(int id) {
		Optional<Person> optional = personRepo.findById(id);
		if(optional.isPresent()) {
			personRepo.deleteById(id);
			return new ResponseEntity<>("Borrado correctamente", HttpStatus.OK);
		}
		return new ResponseEntity<>("No se encontro el id", HttpStatus.CONFLICT);
	}
	
	public ResponseEntity<String> deleteAnimal(int id){
		Optional<Animal> optional = animalRepo.findById(id);
		if(optional.isEmpty()) {
			return new ResponseEntity<>("No se encontro el animal", HttpStatus.CONFLICT);
		}
		Animal animalToDelete = optional.get();
		
		List<Person> personsWithAnimal = personRepo.findByAnimal(animalToDelete);
		for(Person p : personsWithAnimal) {
			p.setAnimal(null);
			
			personRepo.save(p);
		}
		
		animalRepo.delete(animalToDelete);
		
		return new ResponseEntity<>("Borrado correctamente", HttpStatus.OK);
	}
}
