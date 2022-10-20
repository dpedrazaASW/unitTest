package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.PropertyNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.controller.CompanyController;
import com.example.dto.CompanyDTO;
import com.example.dto.PersonDTO;
import com.example.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CompanyService mockService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private CompanyDTO dto;
	
	
	@BeforeEach
	public void setUp() {
		dto = new CompanyDTO();
		dto.setName("husa");
		dto.setRut(123);
	}
	
	/*@Test
	public void getCompany() throws Exception {

		ResponseEntity<CompanyDTO> resp = new ResponseEntity<>(dto, HttpStatus.OK);
		when(mockService.getCompany(anyInt())).thenReturn(resp);
		
		mvc.perform(MockMvcRequestBuilders.get("/get/company/4").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"name\":\"husa\",\"rut\":123,\"workers\":null}")));
	}
	
	@Test
	public void getCompanyWithError() throws Exception {
		when(mockService.getCompany(anyInt())).thenThrow(new PropertyNotFoundException("Prueba"));
		
		mvc.perform(MockMvcRequestBuilders.get("/get/company/4").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError()) 
				.andExpect(content().string(equalTo("Ocurrio un error: Prueba")));
	}
	
	@Test
	public void createCompany() throws JsonProcessingException, Exception{
		List<PersonDTO> persons = new ArrayList<>();
		PersonDTO per = new PersonDTO();
		per.setAge(40);
		PersonDTO per1 = new PersonDTO();
		PersonDTO per2 = new PersonDTO();
		persons.add(per);
		persons.add(per1);
		persons.add(per2);
		
		CompanyDTO company = new CompanyDTO("name", 123, persons);
		when(mockService.createCompany(any())).thenReturn(1);
		//when(mockService.createCompany(company)).thenReturn(1);
		System.out.println("Test:" + company);

		mvc.perform(MockMvcRequestBuilders.post("/create/company").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(company)))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("1")));
	}*/
}