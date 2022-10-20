package com.example.dto;// DTO DATA TRANSFER OBJECT

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class CompanyDTO {
	
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size(min=2, max=30)
	private String name;

	@Min(value = 1, message="Debe ser mayor de edad")
	private int rut;
	
	@NotNull
	private List<PersonDTO> workers;

	
	public CompanyDTO() {
		
	}
	
	public CompanyDTO(String name, int rut, List<PersonDTO> workers) {
		super();
		this.name = name;
		this.rut = rut;
		this.workers = workers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public List<PersonDTO> getWorkers() {
		return workers;
	}

	public void setWorkers(List<PersonDTO> workers) {
		this.workers = workers;
	}

	@Override
	public String toString() {
		return "CompanyDTO [name=" + name + ", rut=" + rut + ", workers=" + workers + "]";
	}
}
