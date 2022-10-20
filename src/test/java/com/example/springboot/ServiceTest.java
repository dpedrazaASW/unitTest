package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.dto.AnimalDTO;
import com.example.dto.CompanyDTO;
import com.example.dto.PersonDTO;
import com.example.entity.Animal;
import com.example.entity.Company;
import com.example.entity.Person;
import com.example.repository.AnimalRepository;
import com.example.repository.CompanyRepository;
import com.example.repository.PersonRepository;
import com.example.serviceImpl.CompanyServiceImpl;
import com.example.serviceImpl.MainServiceImpl;

@SpringBootTest
public class ServiceTest {

	@MockBean
	private AnimalRepository animalRepo;
	
	@MockBean
	private CompanyRepository companyRepo;
	
	@MockBean
	private PersonRepository personRepo;
	
	@Autowired
	private CompanyServiceImpl companyService;
	
	@Autowired
	private MainServiceImpl mainService;

    @Test
    public void getCompanyWithError() throws Exception {
    	Optional<Company> opt = Optional.empty();
    	
		when(companyRepo.findById(anyInt())).thenReturn(opt);
    	try {
    		companyService.getCompany(1);
    	}catch(Exception e) {
    		assertEquals("No se encontro a la persona", e.getMessage()); 	
    	}
    }
	
    @Test
    public void getCompany() throws Exception {
    	CompanyDTO dto = new CompanyDTO("Company",123, new ArrayList<>());
    	CompanyDTO expected = dto;
    	
    	Company comp =  new Company();
    	comp.setName("Company");
    	comp.setRut(123);
    	comp.setWorkers(new ArrayList<>());
    	
    	Optional<Company> opt = Optional.of(comp);
    	
		when(companyRepo.findById(anyInt())).thenReturn(opt);
    	
		assertEquals(expected, companyService.getCompany(1)); 
    }
    
    @Test
    public void getCompanyWithPerson() throws Exception {
    	PersonDTO pDto =  new PersonDTO();
    	List<PersonDTO> personsDto = new ArrayList<>();
    	personsDto.add(pDto);
    	
    	CompanyDTO dto = new CompanyDTO("Company",123, personsDto);
    	CompanyDTO expected = dto;
    	
    	Person p = new Person();
    	
    	List<Person> persons = new ArrayList<>();
    	persons.add(p);
    	
    	Company comp =  new Company();
    	comp.setName("Company");
    	comp.setRut(123);
    	comp.setWorkers(persons);
    	
    	Optional<Company> opt = Optional.of(comp);
    	
		when(companyRepo.findById(anyInt())).thenReturn(opt);
    	
		assertEquals(expected, companyService.getCompany(1)); 
    }
    
    @Test
    public void getCompanyWithPersonAndAnimal() throws Exception {
    	AnimalDTO animDto = new AnimalDTO();
    	animDto.setBirth(new Date());
    	animDto.setColor("azul");
    	animDto.setType("PERRO");
    	
    	PersonDTO pDto =  new PersonDTO();
    	pDto.setAnimal(animDto);
    	List<PersonDTO> personsDto = new ArrayList<>();
    	personsDto.add(pDto);
    	
    	CompanyDTO dto = new CompanyDTO("Company",123, personsDto);
    	CompanyDTO expected = dto;
    	
    	
    	Animal a = new Animal();
    	a.setBirth(new Date());
    	a.setColor("azul");
    	a.setType("PERRO");
    	
    	Person p = new Person();
    	p.setAnimal(a);
    	
    	List<Person> persons = new ArrayList<>();
    	persons.add(p);
    	
    	Company comp =  new Company();
    	comp.setName("Company");
    	comp.setRut(123);
    	comp.setWorkers(persons);
    	
    	Optional<Company> opt = Optional.of(comp);
    	
		when(companyRepo.findById(anyInt())).thenReturn(opt);
    	
		assertEquals(expected, companyService.getCompany(1)); 
    }
}