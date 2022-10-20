package com.example.dto;// DTO DATA TRANSFER OBJECT

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class PersonUpdateDTO {

	@Min(value = 1, message="El id debe ser mayor a 0")
	private int id;
	
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size(min=2, max=30)
	private String name;

	@Min(value = 18, message="Debe ser mayor de edad")
	private int age;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
