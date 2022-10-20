package com.example.springboot;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.entity.Animal;
import com.example.entity.Company;
import com.example.entity.Person;
import com.example.repository.AnimalRepository;
import com.example.repository.CompanyRepository;
import com.example.repository.PersonRepository;
import com.example.serviceImpl.CompanyServiceImpl;
import com.example.serviceImpl.MainServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
    public void getHello() throws Exception {
    	Company comp =  new Company();
    	comp.setName("Company");
    	comp.setRut(123);
    	//comp.setWorkers(new ArrayList<>());
    	
    	Optional<Company> opt = Optional.of(comp);
    	
		when(companyRepo.findById(anyInt())).thenReturn(opt);
    	companyService.getCompany(1);
    }
}