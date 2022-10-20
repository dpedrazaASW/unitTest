package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Animal {

	@Id
	@GenericGenerator(name = "id_generator_animal", strategy = "increment") 
	@GeneratedValue(generator = "id_generator_animal")
	//nombre en SQL id_animal
	private Integer idAnimal;
	
	static int i2;
	
	int i1;
	
	private String type;
	
	@Column(name = "birth_date")
	private Date birth;
	
	private String color;
	
	public Animal() {
	}
	
	public Animal(int in) {
		i1 = in;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
