package com.example.dto;// DTO DATA TRANSFER OBJECT

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Validated
@EqualsAndHashCode
@ToString
public class PersonDTO {
	
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size(min=2, max=30)
	private String name;

	@Min(value = 18, message="Debe ser mayor de edad")
	private int age;
	
	private AnimalDTO animal;
	
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

	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}
}
