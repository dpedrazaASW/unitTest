package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	public List<Company> findByName(String name);
	
	
}