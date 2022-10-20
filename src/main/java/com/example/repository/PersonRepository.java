package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Animal;
import com.example.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	public List<Person> findByName(String name);
	
	public List<Person> findByAge(int age);
	
	public List<Person> findByAnimal(Animal animal);
	
}