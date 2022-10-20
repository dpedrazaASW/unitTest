package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.dto.CompanyDTO;

public interface CompanyService {

	
	public ResponseEntity<CompanyDTO> getCompany(int id);
	
	public Integer createCompany(CompanyDTO companyToCreate);
	
}
