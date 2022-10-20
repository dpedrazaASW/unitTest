package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name = "person")
public class Person {
	
	@Id
	@Column(name = "id_person")
	@GenericGenerator(name = "id_generator", strategy = "increment") 
	@GeneratedValue(generator = "id_generator")
	private Integer id;

	private String name;
	
	private int age;

	@JoinColumn(name = "animal_fk", referencedColumnName= "idAnimal")
	@ManyToOne
	private Animal animal;
	
	
	@JoinColumn(name = "work", referencedColumnName= "id_empresa")
	@ManyToOne
	private Company work;
	
	public Integer getId() {
		return id;
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
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Company getWork() {
		return work;
	}

	public void setWork(Company work) {
		this.work = work;
	}
	
	
}
