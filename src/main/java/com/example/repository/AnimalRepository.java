package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	public List<Animal> findByColor(String color);
	
}